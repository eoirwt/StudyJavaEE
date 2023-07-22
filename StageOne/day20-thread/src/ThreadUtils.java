/**
 *
 */
public class ThreadUtils {
    public static void threadSleep(long sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
