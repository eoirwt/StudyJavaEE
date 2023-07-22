import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
在Java中正则表达式的基本使用

以下实例中使用了正则表达式 .*java.* 用于查找字符串中是否包了 java子串：
 */
public class RegexTest {
    @Test
    public void test1(){
        String context = "fssfasfjavadfdfkjkj";
        String regex = ".*java.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
    @Test
    public void test2(){
        String context = "fssfasfjavadfdfkjkj";
        String pattern = ".+java.+";
        boolean matches = Pattern.matches(pattern, context);
        System.out.println(matches);
    }
}
