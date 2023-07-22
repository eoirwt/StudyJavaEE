import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock (读写锁) 的使用
 */
public class ReadWriteLockTest {
    public static volatile int count = 0;

    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        /** 读取数据的线程, 允许多个线程同时读取数据，效率较高 */
        Runnable readThread = () -> {
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            readLock.lock();
            try{
                ThreadUtils.threadSleep(2000);
                System.out.println(Thread.currentThread().getName() + "线程 在读取数据count: " + ReadWriteLockTest.count);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                readLock.unlock();
            }
        };

        /** 修改数据的线程，只允许一个线程修改数据，其他读取或修改数据的线程都要停下来等待 */
        Runnable wirteThread = () -> {
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            writeLock.lock();
            try{
                ThreadUtils.threadSleep(2000);
                System.out.println(Thread.currentThread().getName() + "线程 在修改数据count: " + (++count));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                writeLock.unlock();
            }
        };

        /** 创建多个线程来测试，其中读取线程远多余写入线程 */
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int num = random.nextInt(100);
            if (num < 20) {
                new Thread(wirteThread, "wirteThread"+num).start();
            }else {
                new Thread(readThread, "readThread"+num).start();
            }
        }

    }

}
