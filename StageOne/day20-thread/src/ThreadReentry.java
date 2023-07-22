/**
 * 线程重入
 */
public class ThreadReentry {
    public static final Object OBJ1 = new Object();
    public static final Object OBJ2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (OBJ1){
                synchronized (OBJ2){
                    /** 该线程再次获取相同的锁，不会被堵塞 */
                    synchronized (OBJ1){
                        synchronized (OBJ2){
                            System.out.println("线程执行结束");
                        }
                    }
                }
            }
        }).start();
    }
}
