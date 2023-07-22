package error;

/**
 * 该案例简单展示了 OutOfMemoryError （堆内存溢出错误）
 */
public class ErrorTest1 {
    public static void main(String[] args) {
        // 运行前先设置通过jvm指令设置对内存空间
        /*
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	    at error.ErrorTest1.main(ErrorTest1.java:8)
        */
        byte[] bytes = new byte[1024 * 1024];
    }
}
