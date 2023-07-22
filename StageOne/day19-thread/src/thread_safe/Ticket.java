package thread_safe;

/**
 * 运用 【同步代码块】 解决多线程下的 “线程争抢” 问题
 * 场景：两个线程同时售卖 100 张票
 */
public class Ticket implements Runnable{
    private static final Object monitor = new Object();
    private static Integer COUNT = 100;

    String name;

    public Ticket(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (Ticket.COUNT > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 在这里加入了同步代码块
            synchronized (Ticket.monitor) {
                System.out.println(name + "出票一张，还剩" + Ticket.COUNT-- + "张！");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(new Ticket("一号窗口"));
        Thread two = new Thread(new Ticket("二号窗口"));
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("票已售完!");
    }
}
