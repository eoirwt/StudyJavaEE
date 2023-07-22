package thread_safe;

/**
 * 线程安全实现方案之：【无同步方案】 案例
 */
public class Test4{
    public static int num = 0;

    /** 创建ThreadLocal实例，为每个线程单独 存储（获取）变量，变量类型为指定的泛型 */
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            /*
            for (int i = 0; i < 100; i++) {
                System.out.println("t1----" + (++num));
            }
            */
            for (int i = 0; i < 100; i++) {
                // 通过 set() 来设置变量
                threadLocal.set(++num);
                // 通过 get() 来获取变量
                System.out.println("t1----" + threadLocal.get());
            }
        });
        Thread t2 = new Thread(() -> {
            /*
            for (int i = 0; i < 100; i++) {
                System.out.println("t2----" + (++num));
            }
            */
            for (int i = 0; i < 100; i++) {
                threadLocal.set(++num);
                System.out.println("t2----" + threadLocal.get());
            }
        });
        t1.start();
        t2.start();
    }
}
