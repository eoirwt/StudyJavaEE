package create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  多线程的案例: 把一个任务拆分给多个线程来完成
 */
public class ThreadApplyExample {
    /** 单线程计算  1 ~ 1_000_000_000 依次累加 */
    public static void singleThreadCalculate(){

        long start = System.currentTimeMillis();
        long res = 0L;
        for (long i = 1; i <= 1_000_000_000; i++) {
            res += i;
        }
        long end = System.currentTimeMillis();
        float calculateTime = end - start;
        System.out.println("计算结果是: " + res + ", 耗时: " + calculateTime + "毫秒");
    }

    /**
     多线程计算 1~10_0000_0000 依次累加
     把这个任务拆分成多个线程来完成，但线程不是同步的
     */
    public static void mutiThreadCalculate() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        /** 加载 5 个任务，开启 5 个线程 */
        FutureTask[] futureTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            /**
             * 0:           1 ~ 200_000_000
             * 1: 200_000_001 ~ 400_000_000
             * 2: 400_000_001 ~ 600_000_000
             * 3: 600_000_001 ~ 800_000_000
             * 4: 800_000_001 ~ 1_000_000_000
             */
            FutureTask<Long> futureTask = new FutureTask<>(new Task(i * 200_000_000 + 1, (i + 1) * 200_000_000));
            futureTasks[i] = futureTask;
            new Thread(futureTask).start();
        }

        /** 依次执行每个线程里的任务，记录结果 */
        long result = 0L;
        for (int i = 0; i < futureTasks.length; i++) {
            Long res = (Long)futureTasks[i].get();
            result += res;
        }

        long end = System.currentTimeMillis();
        float calculateTime = end - start;
        System.out.println("计算结果是: " + result + ", 耗时: " + calculateTime + "毫秒");
    }

    static class Task implements Callable<Long>{
        long from;
        long to;
        public Task() {
        }
        public Task(long from, long to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public Long call() throws Exception {
            long res = 0L;
            for (long i = from; i <= to; i++) {
                res += i;
            }
            return res;
        }
    }
    /** 从结果上看，拆分任务 成多个线程执行，会快一点 */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ThreadApplyExample.singleThreadCalculate(); // 计算结果是: 500000000500000000, 耗时: 303.0毫秒
        ThreadApplyExample.mutiThreadCalculate(); // 计算结果是: 500000000500000000, 耗时: 204.0毫秒
    }
}
