package thread_safe;

/**
 * 多线程下 【指令重排】 的问题
 */
public class Test1 {
//    private static int x = 0, y = 0;
//    private static int a = 0, b = 0;
    /** 通过 volatile 修饰的变量，将来再读写这些变量的时候，就避免了指令重排 */
     private static volatile int a = 0, b= 0, x = 0, y = 0;
    private static int count = 0;

    private static volatile int NUM = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (;;) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    /** 因为有 volatile 修饰这些变量，所以代码执行的顺序不会被重排 */
                    a = 1;
                    x = b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("一共执行了：" + (count++) + "次");
            if(x==0 && y==0){
                long end = System.currentTimeMillis();
                System.out.println("耗时：+"+ (end-start) +"毫秒，(" + x + "," + y + ")");
                break;
            }
            a=0;b=0;x=0;y=0;
        }
    }
}
