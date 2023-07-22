import tool.ThreadUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类 AtomicInteger 的使用
 */
public class AtomicIntegerTest {
    public static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                ATOMIC_INTEGER.getAndAdd(1);
            }).start();
        }
        ThreadUtils.threadSleep(2000);
        System.out.println(ATOMIC_INTEGER.get());
    }
}
