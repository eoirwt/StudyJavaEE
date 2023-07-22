package thread_synchronizer;

import tool.ThreadUtils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 线程同步器的使用
 */
public class CountDownLatch_Test {
    public static void main(String[] args) throws InterruptedException {
        /** 初始化计数器 */
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        Runnable task1 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算山西分公司的账目");
            /** 每当一个任务线程执行完毕，就将计数器减1 */
            countDownLatch.countDown();
        };

        Runnable task2 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算北京分公司的账目");
            /** 每当一个任务线程执行完毕，就将计数器减1 */
            countDownLatch.countDown();
        };

        Runnable task3 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算上海分公司的账目");
            /** 每当一个任务线程执行完毕，就将计数器减1 */
            countDownLatch.countDown();
        };

        newCachedThreadPool.submit(task1);
        newCachedThreadPool.submit(task2);
        newCachedThreadPool.submit(task3);

        /** 等待所有线程执行完，唤醒线程 */
        countDownLatch.await();

        System.out.println("计算总账！");



    }
}
