/**
 * Thread.yield() 的使用
 */
public class YieldTest {
    public static int count1 = 0;
    public static int count2 = 0;
    public static void add1(){
        System.out.println(Thread.currentThread().getName() + ":  " + (++count1));
    }
    public static void add2(){
        System.out.println(Thread.currentThread().getName() + ":  " + (++count2));
    }
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                /** t1 主动放弃这次cpu执行权，下一次的执行权任会被所有前程争抢，使得 t2 会得到更多的优先执行权 */
                Thread.yield();
                YieldTest.add1();
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                YieldTest.add2();
            }
        }, "t2").start();
    }
}
