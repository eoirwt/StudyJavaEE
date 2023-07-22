package create_thread;

/**
 * 方式二:
 * 通过实现 Runnable 接口的方式创建线程
 */

/** 1、实现 Runable接口  */
public class Mode2 implements Runnable{
    @Override
    /** 2、重写 抽象方法 run() */
    public void run(){
        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        /**
         3、创建 Thread 实例 并传入 实现 Runnable接口 类的实例,
           通过 Thread 实例的 start() 开启线程

         基本上与 Mode1.java 相似，但有细微差别:
         -> 执行 Thread 实例的 start()
         -> start() 里面又执行 start0()
         -> start0 里面执行 run()
         -> run() 里面又执行了 我传入的 Runnable类型 的实例的 run()

         所以我主动重写的 run() 方法被执行了
         */
        new Thread(new Mode2()).start();
        System.out.println(3);
    }
}
