package error;

/**
 * 该案例简单展示了 StackOverflowError（栈内存溢出错误）
 */
public class ErrorTest2 {
    public static void Func(){
        Func();
    }
    public static void main(String[] args) {
        /*
        Exception in thread "main" java.lang.StackOverflowError
	        at error.ErrorTest2.Func(ErrorTest2.java:8)
	        ...
        */
        Func();
    }
}
