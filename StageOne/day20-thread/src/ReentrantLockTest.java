import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock(可重入锁) 的使用
 *
 * 简单写个售票逻辑，运用 可重入锁
 */
public class ReentrantLockTest {
    public static int count = 100;
    public static Lock lock = new ReentrantLock();
    static class Ticket implements Runnable{
        @Override
        public void run() {
            while (ReentrantLockTest.count > 0){
                ThreadUtils.threadSleep(200);
                /*synchronized (ReentrantLockTest.class){
                    if(ReentrantLockTest.count > 0){
                        System.out.println(Thread.currentThread().getName() + " :已售出一张票, " + "票数还剩余: " + (--ReentrantLockTest.count));
                    }else {
                        System.out.println(Thread.currentThread().getName() + " :票已售空");
                    }
                }*/

                /** 获取锁 */
                ReentrantLockTest.lock.lock();
                /**
                 当代码执行时抛出异常时，ReentrantLock 不会像 synchronized 一样主动释放锁
                 所以需要我们捕获异常后，主动释放锁
                 */
                try {
                    if(ReentrantLockTest.count > 0){
                        System.out.println(Thread.currentThread().getName() + " :已售出一张票, " + "票数还剩余: " + (--ReentrantLockTest.count) + " 张!");
                    }else {
                        System.out.println(Thread.currentThread().getName() + " :票已售空");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    /** 释放锁 */
                    ReentrantLockTest.lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Ticket(), "窗口一");
        t1.start();

        Thread t2 = new Thread(new Ticket(), "窗口二");
        t2.start();


    }
}
