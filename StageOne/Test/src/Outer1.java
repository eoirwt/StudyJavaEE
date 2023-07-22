/**
 * ClassName: Outer
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/4 18:45
 * @Version 1.0
 */
public class Outer1 {
    static {
        System.out.println("outer class is loaded");
    }
    public Inner test(){
        // 在外部类的实例方法中创建内部类实例
        return new Inner();
    }
    class Inner {
        //Static declarations in inner classes are not supported at language level '8'
        /*static {

        }*/
        {
            System.out.println("inner class is loaded");
        }

    }

    public static void main(String[] args) {
        Inner innerClass1 = new Outer1().new Inner();
        System.out.println(innerClass1);
        Inner innerClass2 = new Outer1().new Inner();
        System.out.println(innerClass2);
        Inner innerClass3 = new Outer1().test();
        System.out.println(innerClass3);
    }
}
