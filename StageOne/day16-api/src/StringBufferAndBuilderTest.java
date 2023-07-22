/**
 * StringBuffer 和 StringBuilder 类的练习使用
 */
public class StringBufferAndBuilderTest {
    public static void main(String[] args) {
        // new StringBuilder()
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append().append()
        stringBuilder.append(1).append('c').append(1.5).append(true).append(1234556789).append("asdf");
        // stringBuilder.insert()
        stringBuilder.insert(2, 2);
        // stringBuilder.reverse()
        stringBuilder.reverse();
        // stringBuilder.toString()
        String s = stringBuilder.toString();
        System.out.println(s);
        // stringBuilder.lastIndexOf()
        int i = stringBuilder.lastIndexOf("5");
        System.out.println(i);

        // StringBuffer 用法也类似，接下来比较它们的性能， 批量插入
        long start = System.currentTimeMillis();

        // StringBuilder 100万次插入数据需要 13毫秒！
        StringBuilder stringBuilder1 = new StringBuilder(100_0000);
        for (int j = 0; j < 100_0000 - 1; j++) {
            stringBuilder1.append("a");
        }
        /*
        // StringBuffer 100万次插入数据需要 27毫秒!
        StringBuffer stringBuffer = new StringBuffer(100_0000);
        for (int j = 0; j < 100_0000 - 1; j++) {
            stringBuffer.append("a");
        }
        */

        /*
        // String 100万次插入数据非常久！
        String str = "";
        for (int j = 0; j < 100_0000 - 1; j++) {
            str += "a";
        }
        */
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        /*
        总结: 如果需要频繁的操作字符串（比如字符串的拼接），
             优先考虑 StringBuffer（性能交低，线程安全） or StringBuilder（性能交高，线程不安全），
             因为String性能非常差！
        */


    }
}
