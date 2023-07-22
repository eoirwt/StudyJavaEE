package customized_thread_pool;

import tool.ThreadUtils;

import java.util.concurrent.ExecutorService;

/**
 * 测试 自定义线程池
 */
public class Test {
    public static void main(String[] args) {
        /** 创建自定义的线程池 */
        ExecutorService myThreadPool = MyThreadPool.newMyThreadPool();

        /** 添加任务 */
        for (int i = 0; i < 70; i++) {
            myThreadPool.submit(()->{
                ThreadUtils.threadSleep(1000);
                System.out.println("--------");
            });
        }

//        myThreadPool.shutdown(); // 停止线程池
    }
}
