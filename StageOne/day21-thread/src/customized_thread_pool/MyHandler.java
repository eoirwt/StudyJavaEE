package customized_thread_pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义一个简单的 拒绝策略
 *
 * 实现 RejectedExecutionHandler 接口即可
 * 具体可模仿 java/util/concurrent/ThreadPoolExcutor.java
 * 内部定义的 AbortPolicy (静态内部类)
 */
public class MyHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("线程池任务队列溢出, 无法创建新线程, 拒接任务!");
    }
}
