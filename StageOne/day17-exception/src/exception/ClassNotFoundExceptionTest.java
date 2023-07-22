package exception;

/**
 * 简单了解 ClassNotFoundException 异常
 */
public class ClassNotFoundExceptionTest {
    public static void main(String[] args) {
        try {
            // 该方法动态加载 指定包下的类，如果指定包下的类不存在，就会抛出 ClassNotFoundException 异常
            Class.forName("error.Dog1");
            System.out.println("error.Dog1类成功加载");
        } catch (ClassNotFoundException e) {
            System.out.println("error.Dog1类加载失败");
            throw new RuntimeException(e);
        }

    }
}
