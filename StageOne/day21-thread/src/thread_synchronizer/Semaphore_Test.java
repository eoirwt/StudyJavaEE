package thread_synchronizer;

import tool.ThreadUtils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 线程同步器的使用
 */
public class Semaphore_Test {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            cachedThreadPool.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("线程池中的一个线程执行中...");
                    ThreadUtils.threadSleep(new Random().nextInt(5000));
                    semaphore.release();
                    System.out.println("线程池中的一个线程执行结束!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
//            cachedThreadPool.execute();
        }
    }
}
