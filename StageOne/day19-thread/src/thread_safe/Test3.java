package thread_safe;

/**
 * 多线程下的 【线程争抢】 问题
 *
 * 举例：线程1和线程2分别对count累计10000次，合适的结果应该是20000才对
 */
public class Test3 {
    private static int COUNT = 0;

    public static void adder(){
        COUNT++;
    }

    /**
     发现怎么也 COUNT 怎么也得不到 20000,
     解决方法：加锁，
     synchronized 的作用:
     被它修饰的方法不能被多个线程同时调用，必须一个线程调用完了，下个线程再调用
    */
//    public synchronized static void adder(){
//        COUNT++;
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                adder();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                adder();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("最后的结果是："+COUNT);
    }
}
