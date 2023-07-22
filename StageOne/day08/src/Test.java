/**
 * 了解 String 类
 */
public class Test {
    public static void main(String[] args)  {

        String s1 = "abc";

        String s2 = new String("abc");

        char[] value = {'a',45665,'1','2','3'};
        String s3 = new String(value);

        String s5 = new String(value);
        System.out.println(s5);

    }
}
