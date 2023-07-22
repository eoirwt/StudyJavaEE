package create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 方式四: 创建一个有返回值的线程
 */
public class Mode4{
    /** 1、定义一个 Task 并现实 Callable 接口，重写 call() 方法 (设置一个将会执行的任务)*/
    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return 3;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(1);
        System.out.println(2);

        /** 2、创建一个 FutureTask类型的实例 (加载你设置的任务) */
        FutureTask<Integer> futureTask = new FutureTask<>(new Mode4.Task());
        /**
         3、启动线程 (你设置的任务将会在这个线程上执行) */
        new Thread(futureTask).start();
        /**
         4、调用 FuterTask 实例 的 get()方法 (启动任务)

         执行 get() 时，会堵塞当前线程，并等待 被你启动 的另外一个线程的返回结果，
         在没得到返回结果之前，不会放行当前线程

         返回结果: 就是被你重写的 call() 的返回结果
         */
        System.out.println("线程堵塞...");
        Integer result = futureTask.get();
        System.out.println(result);


        System.out.println(4);
    }

}
