/**
 * 线程的退出
 * 方式一：打上标记位
 * 方式二：通过 interrupte() 退出 (具体案例在 InterruptTest.java中)
 */
public class ThreadExit {
    private volatile static boolean isFlag = true;

    public static void StopThread(){
        System.out.println("线程停止运行!");
        ThreadExit.isFlag = false;
    }

    public static void main(String[] args) {
        new Thread(()->{
            while (ThreadExit.isFlag){
                System.out.println("线程运行中...");
            }
        }).start();

        ThreadUtils.threadSleep(2000);
        ThreadExit.StopThread();
    }
}
