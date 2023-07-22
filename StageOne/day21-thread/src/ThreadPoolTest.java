import tool.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程池的使用
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadUtils.threadSleep(1000);
            System.out.println("-------");
        };

        /** 创建线程池 */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        /** 添加任务 */
        for (int i = 0; i < 100; i++) {
//            cachedThreadPool.submit(task);
//            fixedThreadPool.submit(task);
//            singleThreadExecutor.submit(task);
            scheduledThreadPool.submit(task);
        }
    }
}
