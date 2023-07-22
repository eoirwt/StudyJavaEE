package customized_thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义一个简单的 线程工厂
 *
 * Java自定义的线程池都使用
 * java/util/concurrent/Executors.java 中
 * 的静态内部类 DefaultThreadFactory 的实例
 *
 * 想定义线程工厂，就要模仿 DefaultThreadFactory
 */
public class MyThreadFactory implements ThreadFactory {

    /** 自定义线程名 */
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final String namePrefix;
    MyThreadFactory(String prefix) {
        namePrefix = prefix +
                poolNumber.getAndIncrement() +
                "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, namePrefix);
    }


}
