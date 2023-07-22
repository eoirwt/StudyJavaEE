/**
 * 守护线程的案例
 */
public class GuardThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> {
                while (true){
                    ThreadUtils.threadSleep(200);
                    System.out.println("t2线程正在运行中...");
                }
            });
            /** 守护线程的开关 */
            t2.setDaemon(true);
            t2.start();

            for (int i = 10; i > 0 ; i--) {
                ThreadUtils.threadSleep(200);
                System.out.println("t1线程正在运行中...");
            }

            System.out.println("t1线程结束!");
        });
        /** 守护线程的开关 */
//        t1.setDaemon(true);
        t1.start();
    }
}
