import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: GreedTest
 * @Package: PACKAGE_NAME
 * @Description: 贪婪匹配
 */
public class GreedTest {
    @Test // 单个重复限定符时的贪婪匹配的情况
    public void test1(){
        String regex = "\\d{3,6}"; // 默认是贪婪匹配，会尽可能多的去匹配
        String context ="61762828 176 2991 871";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while(matcher.find()){
            /* 具体过程分析：
            "617628" -> true
            "28 " -> false
            "176" -> true
            " " -> false
            "2991" -> true
            " " -> false
            "871" -> true
             */
            System.out.println("匹配结果：" + matcher.group());
        }
        /*输出结果：
        匹配结果：617628
        匹配结果：176
        匹配结果：2991
        匹配结果：871
         */
    }
    @Test // 多个重复限定符的贪婪匹配的情况
    public void test2(){
        String regex = "\\d{1,2}\\d{3,5}";
        String context ="61762828 176 2991 871";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while(matcher.find()){
            /* 具体过程分析：
            "6176282" -> true
            "8 " -> false
            "176 " -> false
            "2991” -> true
            " " -> false
            "871" -> false
             */
            System.out.println("匹配结果：" + matcher.group());
        }
        /*输出结果：
        匹配结果：6176282
        匹配结果：2991
         */
    }
}
