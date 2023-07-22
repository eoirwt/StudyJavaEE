/**
 * synchronized 锁的基本使用, 列举了 5 种使用方式
 */
public class SynchronizedTest {
    public static final Object Lock = new Object();
    public static final SynchronizedTest monitor = new SynchronizedTest();
    /** 实例方法上 synchronized 锁 */
    public synchronized void func1(){
        ThreadUtils.threadSleep(200);
        System.out.println("func1()...");
        System.out.println("--------" + Math.random() + "--------");
    }
    /** 静态方法上 synchronized 锁 */
    public static synchronized void func2(){
        ThreadUtils.threadSleep(200);
        System.out.println("func2()...");
        System.out.println("--------" + Math.random() + "--------");
    }

    public void func3(){
        synchronized (this) {
            ThreadUtils.threadSleep(200);
            System.out.println("func3...");
            System.out.println("--------" + Math.random() + "--------");
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {

                /**
                 方式一：
                 多个线程都执行这个被上锁的方法
                 静态方法的 “锁”，就是 “类对象” ，
                  “类对象” 是类被加载的时候生成的独一无二的对象，
                 所以，这里多个线程都是用的同一个锁，
                 每个线程都会拿到 “锁” ，有 上锁 解锁的过程，所以每个线程排队等着上个线程解锁后再执行这个方法。
                 */
                //SynchronizedTest.func2();

//              -------------------------------------------------------------------------

                /**
                 方式二：
                 多个线程执行被上锁的实例方法，
                 实例方法的锁，就是调用该方法的实例对象，
                 这里多个线程都会有它们自己 new Demo1() 的锁，
                 所以它们用的不是同一把锁，自然无法形成同步互斥的效果，乱套了, 需要改进
                 */
                //new SynchronizedTest().func1();
                /** 进一步改进，使得所有线程都共用一把锁 */
                // SynchronizedTest.monitor.func1();

//              -------------------------------------------------------------------------

                /** 方式三：synchronized代码块的锁可以是 “调用成员方法的实例” */
                //SynchronizedTest.monitor.func3();

//              -------------------------------------------------------------------------

                /** 方式四：synchronized代码块的锁可以是 “类对象” */
                /*
                synchronized (SynchronizedTest.class) {
                    ThreadUtils.threadSleep(200);
                    System.out.println("func4...");
                    System.out.println("--------" + Math.random() + "--------");
                }
                */
//              -------------------------------------------------------------------------

                /** 方式五：synchronized代码块的锁可以是 “一个任意类型的共用的实例对象” */
                /*
                new Thread(() -> {
                    synchronized (SynchronizedTest.Lock){
                        ThreadUtils.threadSleep(200);
                        System.out.println("func5...");
                        System.out.println("--------" + Math.random() + "--------");
                    }
                }).start();
                */
            }).start();
        }
    }
}
