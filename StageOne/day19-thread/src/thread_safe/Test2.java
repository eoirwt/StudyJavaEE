package thread_safe;

/**
 * 多线程下的 【可见性】 问题
 *
 * 当你在 A线程里修改了一个变量的值，其他线程是不可见的，它们不知道你在A线程修改了变量，它们依然会按照它们各自缓存里的变量值
 *
 * 通过 valatile 修饰该变量，就能解决这个问题
 */
public class
Test2 {
//    private static boolean isOver = false;
    private static volatile boolean isOver = false;
    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                }
                System.out.println(number);
            }
        });
        thread.start();
        Thread.sleep(1000);
        number = 50;
        /**
         isOver 被 volatile修饰后，它的读写被强制在主存中操作
         thread线程 它缓存里的 isOver将不可用，它只能在主存里读写 isOver
        */
        isOver = true;
    }
}
