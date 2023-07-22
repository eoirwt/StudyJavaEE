package thread_safe;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * 场景:
 * 在多线程的场景中使用 Vector 代替 ArrayList
 * 说明：
 * 在 DataErrorTest 案例中已经知道 ArrayList、HashMap 等不适合用与多线程模式，
 * 采用 Vector 和 HashTable 来替代它们是一种过时的解决方案
 */
public class HashTable_Vector_Test {
    public static void main(String[] args) throws InterruptedException {
//        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        // CountDownLatch: 工具类，线程同步器
        CountDownLatch countDownLatch = new CountDownLatch(200);
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                vector.add(1);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(vector.size()); // 200
        /**
         总结：
         在多线程场景下可以考虑 Vector、HashTable 这些过时的解决方案，
         它们的原理都一样，都是上了 ”悲观锁“，
         在它们的源码里可以看到具体操作元素的方法 都被 syncronized 修饰， 这是非常损耗性能的
         */
    }
}
