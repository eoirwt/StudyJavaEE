import tool.ThreadUtils;

/**
模仿 CAS 核心思想，来弥补 volatile 的无原子性
 继续完善 AtomicTest.java
 */
public class CasTest {
    public static volatile int count;
    public synchronized static boolean compareAndSwap(int expect, int update){
        if(expect == CasTest.count){
            CasTest.count = update;
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                ThreadUtils.threadSleep(10);
                // 模拟自旋
                while (CasTest.compareAndSwap(CasTest.count, count+1)){}
            }).start();
        }
        ThreadUtils.threadSleep(3000);
        System.out.println(CasTest.count); // 500
    }
}
