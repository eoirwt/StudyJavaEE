package performances_contrast;

import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Hashtable 与 ConcurrentHashMap 的性能对比
 * 开辟50个线程，每个线程向集合中put100000个元素，测试两个类所需要的时间
 */
public class Hashtable_VS_ConcurrentHashMap {
    @Test
    public void hashtableTest() throws InterruptedException {
        System.out.println("----------------开始测试Hashtable------------------");
        final Map<Integer,Integer> map = new Hashtable<>(500);
        final CountDownLatch countDownLatch = new CountDownLatch(50);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            final int j = i;
            new Thread(()->{
                for (int k = 0; k < 100000; k++) {
                    map.put(j*k,1);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("hashtable:(end-start) = " + (end - start));
        /*
         ----------------开始测试Hashtable------------------
         hashtable:(end-start) = 777
         */
    }

    @Test
    public void ConcurrentHashMapTest() throws InterruptedException {
        System.out.println("----------------开始测试ConcurrentHashMap------------------");
        final Map map2 = new ConcurrentHashMap<>(500);
        final CountDownLatch countDownLatch = new CountDownLatch(50);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            final int j = i;
            new Thread(()->{
                for (int k = 0; k < 100000; k++) {
                    map2.put(j*k,1);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap:(end-start) = " + (end - start));
        /*
        ----------------开始测试ConcurrentHashMap------------------
        ConcurrentHashMap:(end-start) = 2
         */
    }
    /**
     总结：
     对于支持多线程的 Map，优先使用 ConcurrentHashMap ，它的性能远优于 Hashtable
     */
}
