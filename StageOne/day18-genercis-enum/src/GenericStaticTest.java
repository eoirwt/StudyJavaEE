/**
 * 静态方法和静态类中的问题
 */
public class GenericStaticTest<T> {
    /*
    public static T value;
    public static T func(T t){
        return t;
    }
    */
    public static <T> T func1(T t){
        return t;
    }
}
