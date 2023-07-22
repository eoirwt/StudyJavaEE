/**
 *  “死锁” 的案例
 */
public class DeadLock {
    public static final Object OBJ = new Object();
    public static final String STR = "abc";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized(OBJ){
                ThreadUtils.threadSleep(200);
                System.out.println("线程" + Thread.currentThread().getName() + " 拿到了 OBJ 对象锁");
                synchronized (STR){
                    ThreadUtils.threadSleep(200);
                    System.out.println("线程" + Thread.currentThread().getName() + " 拿到了 STR 对象锁");
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (STR){
                ThreadUtils.threadSleep(200);
                System.out.println("线程" + Thread.currentThread().getName() + " 拿到了 STR 对象锁");
                synchronized (OBJ) {
                    ThreadUtils.threadSleep(200);

                    System.out.println("线程" + Thread.currentThread().getName() + " 拿到了 OBJ对象锁");
                }
            }
        }, "thread2").start();

        /**
         结果是：
         线程thread1 拿到了 OBJ 对象锁
         线程thread2 拿到了 STR 对象锁

         然后程序卡死，
         因为 thread1 占有 OBJ 锁不释放，想要 STR 锁并等待锁持有者释放
             thread2 占有 STR 锁不释放，想要 OBJ 锁并等待锁持有者释放
         */
    }
}
