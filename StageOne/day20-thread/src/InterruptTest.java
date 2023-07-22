/**
 * 线程实例方法 interrupt() 的使用
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("线程开始执行...");
            /** interrupt 打断 线程 sleep */
            /*
            System.out.println("线程睡上很长时间...");
            try {
                Thread.sleep(60000000);
            } catch (InterruptedException e) {
                System.out.println("线程被强制唤醒了");
                throw new RuntimeException(e);
            }
            */

            /** interrupt 打断线程 wait */
            /*
            synchronized (InterruptTest.class){
                System.out.println("线程被挂起");
                try {
                    InterruptTest.class.wait();
                } catch (InterruptedException e) {
                    System.out.println("线程被强制唤醒了");
                    throw new RuntimeException(e);
                }
            }
            */

            /** interrupt 不能打断线程正常执行 */
            for (int i = 0; ; i++) {
                System.out.println(i);
            }

        });
        t1.start();
        ThreadUtils.threadSleep(3000);
        /** 主线程打断 t1线程 的堵塞过程 */
        t1.interrupt();


    }
}
