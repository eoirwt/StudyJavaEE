package exception;

import java.util.regex.Pattern;

/**
 * 该案例列举了一些 运行时异常 (非受检查常),
 * 包括 NullPoiterException、ArithmeticException、ClassCastException、IndexOutOfBoundsException、NumberFormatException
 */
public class OuterExceptionsTest {
    public static void Func1(String str){
        // boolean result = str.equals("abc");

        // 解决方式①
        try{
            boolean result = str.equals("abc");
        }catch (NullPointerException e){
            System.out.println("str 是 null, 无法比较");
//            e.printStackTrace();
        }

        // （推荐）解决方式②
        /*if (str != null){
            boolean result = str.equals("abc");
        }*/
    }
    public static void Func2(int i){
        //int val = 10 / i;
        //Exception in thread "main" java.lang.ArithmeticException: / by zero

        // 解决：
        if( i != 0 ){
            int val = 10 / i;
        }
    }
    public static void Func3(){
        /*
        Animal animal = new Dog();
        Cat cat = (Cat)animal;
        */
        /*
        //解决:
        if(animal instanceof  Cat){
            Cat cat = (Cat)animal;
        }
        */
    }
    public static void Func4(int index){
        int[] ints = new int[3];
        // ints[index] = 6;
        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3

        // 解决:
        if(index > -1 && index < ints.length){
            ints[index] = 6;
        }
    }
    public static void Func5(String str){
//        int i = Integer.parseInt(str);
//        Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"

        // 解决:
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if(pattern.matcher(str).matches()){
            int i = Integer.parseInt(str);
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        // 了解 NullPoiterException
        Func1(null);

        // 了解 ArithmeticException
//        Func2(0);

        // 了解 ClassCastException
//        Func3();

        // 了解 IndexOutOfBoundsException
//        Func4(3);

        // 了解 NumberFormatException
//        Func5("abc");

    }
}
