package exception;

/**
 * 简单了解 InterruptedException 异常
 */
public class InterruptedExceptionTest {
    public static void main(String[] args) {
        try {
            /*
            线程堵塞 3 秒
            当有其他先程中断堵塞时，会抛出 InterruptedException 异常
             */
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("程序继续执行...");
    }
}
