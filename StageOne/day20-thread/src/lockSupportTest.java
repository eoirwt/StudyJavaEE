import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport 线程堵塞工具类的使用
 */
public class lockSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            ThreadUtils.threadSleep(2000);
            System.out.println("线程开始执行...");
            System.out.println("线程被暂停!");
            /**
             park(Object obj): 暂停当前线程，并传递信息数据obj
             */
            LockSupport.park("thread is parked");

            /**
             线程 park() 后如果被 interrupt() 打断堵塞后是不会抛出 InterruptedException 异常的，
             这时需要通过 Thread.currentThread().isInterrupted() 判断状态,
             其返回值如果为: true; 说明线程是被 interrupte() 打断的，否者反之
             */
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("线程的堵塞状态被 interrupt() 打断了!");
            }

            System.out.println("线程恢复执行...");
            System.out.println("线程执行结束!");
        });
        thread.start();

        ThreadUtils.threadSleep(3000);

        /** getBlocker(Thread thread): 获取线程暂定时传出的信息数据 */
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println(blocker);

        /**
         线程被 park() 后，有两种方式可以打断他的阻塞方式:
         1. unpark(Thread thread): 恢复被暂停的线程
         2. interrupt()
         */
        LockSupport.unpark(thread);
//        thread.interrupt();
    }
}
