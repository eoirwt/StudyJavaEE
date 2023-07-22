package create_thread;

/**
 * 方式一 :
 * 通过继承 java.lang.Thread 的方式创建线程
 */

/** 1、继承 java.lang.Thread类  **/
public class Mode1 extends Thread{

    @Override
    /** 2、Override Thread.run() **/
    public void run(){
        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        /**
         3、通过 start() 开启线程
         该方法大致执行过程：
         -> 执行 Thread 实例的 start()
         -> start() 里面又执行 start0()
         -> start0 里面执行 run()

         所以我主动重写的 run() 方法被执行了
         */
        new Mode1().start();
        System.out.println(3);
        /**
         开启一个线程不会堵塞当前线程，
         当然，开启线程需要资源开销
         所以会依次输出 1 > 3 > 2
         */
    }
}
