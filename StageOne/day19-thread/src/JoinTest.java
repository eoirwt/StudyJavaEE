/**
 * 线程实例方法 join() 的使用
 */
public class JoinTest {
    public static void main(String[] args) {
        System.out.println("main主线程开始...");

        Thread t1 = new Thread(() -> {
            System.out.println("t1线程开始执行...");
            ThreadUtils.threadSleep(2000);
            for (int i = 0; i < 10; i++) {
                System.out.println("t1线程执行中...");
            }
            System.out.println("t1线程结束!");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2线程开始执行...");
            ThreadUtils.threadSleep(2000);
            for (int i = 0; i < 10; i++) {
                System.out.println("t2线程执行中...");
            }
            System.out.println("t2线程结束!");
        });

        t1.start();
        t2.start();

        /**
         Thread实例的 join()
         阻塞 创建t1线程的 main主线程，
         等待 t1线程执行结束，放行，继续执行主线程
         */
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main主线程结束!");
    }
}
