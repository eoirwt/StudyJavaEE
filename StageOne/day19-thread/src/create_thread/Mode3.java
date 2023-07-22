package create_thread;

/**
 * 方式三:
 * 通过 方式二 的简化形式 创建线程
 */
public class Mode3 {
    public static void main(String[] args) {
        System.out.println(1);

        /** 使用匿名内部类 */
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).start();
        */
        /** 再次简化 写成 Lammbda 表达式 */
        new Thread(() -> System.out.println(2)).start();

        System.out.println(3);
    }
}
