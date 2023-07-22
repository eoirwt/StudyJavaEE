import tool.ThreadUtils;

/**
 * 证明 volatile 不具备原子性
 */
public class AtomicTest {
    public static volatile int count;
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                ThreadUtils.threadSleep(10);
                AtomicTest.count++;
            }).start();
        }
        /** 主线程等所有线程执行完，再去读取变量，3秒足够 */
        ThreadUtils.threadSleep(3000);
        /** 因为valatile不具备原子性，所以 count 不能得到理想值 500 */
        System.out.println(AtomicTest.count);
    }


}
