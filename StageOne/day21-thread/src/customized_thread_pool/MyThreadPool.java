package customized_thread_pool;

import java.util.concurrent.*;

/**
 * 自定义一个线程池
 */
public class MyThreadPool {
    public static ExecutorService newMyThreadPool() {
        /** 自定义线程池 */
        return new ThreadPoolExecutor(
                5,
                10,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(50),

                /**
                 可使用自定义的线程工厂 ，否者使用 java/util/concurrent/Executors.class
                 内部定义的 efaultThreadFactory (静态内部类)
                */
                new MyThreadFactory("业务线程"),

                /**
                 可使用自定义的拒绝策略;
                 否者使用 java/util/concurrent/ThreadPoolExecutor.class
                 内部定义的 AbortPolicy (静态内部类), 线程池接受的任务数量超出热任务队列且无法再创建新线程时就会报错
                */
                new MyHandler()
        );
    }
}
