package thread_synchronizer;

import tool.ThreadUtils;

import javax.lang.model.element.VariableElement;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 线程同步器的使用
 */
public class CyclicBarrier_Test {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        Runnable task4 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算总账");
        };

        /** 创建实例, 计数器为3 */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, task4);

        Runnable task1 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算山西分公司的账目");
            /** 每当一个任务线程执行完毕, 执行await(), 计数器减1 */
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task2 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算北京分公司的账目");

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task3 = () -> {
            ThreadUtils.threadSleep(new Random().nextInt(5000));
            System.out.println("计算上海分公司的账目");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        newCachedThreadPool.submit(task1);
        newCachedThreadPool.submit(task2);
        newCachedThreadPool.submit(task3);

        ThreadUtils.threadSleep(6000);

        /** 复用 */
        cyclicBarrier.reset();
        System.out.println("-------reset-------");

        newCachedThreadPool.submit(task1);
        newCachedThreadPool.submit(task2);
        newCachedThreadPool.submit(task3);

    }
}
