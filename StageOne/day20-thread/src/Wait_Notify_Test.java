/**
 * Object成员方法 wait()、notify()、notifyAll()的使用
 */
public class Wait_Notify_Test {
    public static final Object MONITOR  = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (MONITOR){
                System.out.println("线程1执行中...");
                System.out.println("线程1被挂起!");
                try {
                    /**
                     wait(): 线程被永久挂起，等待被唤醒
                     wait(long): 线程被指定挂起多久
                     线程被挂起后，会释放所持有的锁
                     */
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程1继续执行...");
                System.out.println("线程1执行结束!");
            }
        }).start();

        new Thread(() -> {
            synchronized (MONITOR){
                System.out.println("线程2执行中...");
                ThreadUtils.threadSleep(2000);
                System.out.println("线程2唤醒其他线程");
                /**
                 notify(): 唤醒线程被锁挂起的线程，该线程继续执行
                 notifyAll(): 唤醒所有线程，其他线程都来争抢锁
                 */
                MONITOR.notify();
                System.out.println("线程2继续执行...");
                System.out.println("线程2执行结束!");
            }
        }).start();
    }
}
