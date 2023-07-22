package thread_safe;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 场景：
 * 多个线程同时使用集合原生的api操作一个共享的集合引发数据错误的问题
 * 说明：
 * 在多线程的情况下，没有使用集合的迭代器，使用集合原生的api去操作元素，
 * 虽然不会发生 ConcurrentModifyException,但会导致多线程共享的集合发生错误！
 */
public class DataErrorTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        // CountDownLatch: 工具类，线程同步器
        CountDownLatch countDownLatch = new CountDownLatch(200);
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                arrayList.add(1);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(arrayList.size());
        /**
         结果不确定，有两种情况：
         1. 抛出 异常
         Exception in thread "Thread-34" java.lang.ArrayIndexOutOfBoundsException: 15
         at java.util.ArrayList.add(ArrayList.java:463)
         原来，ArrayList 在添加数据时也可能发生 “数组脚标越界异常",
         那么肯定是这种情况，在容量满足且当前数量到达临界值时，有多个线程同时执行添加元素，才导致异常的发生

         2. 不抛异常，正常执行并得到 size，但结果却不是200

         总结：
         ArrayList，SetMap，HashMap它们本身是安全的，但在多线成下就不安全了，所以使用它们时要避免多线程的场景！
         */
    }
}
