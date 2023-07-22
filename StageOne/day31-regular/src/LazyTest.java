import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: LazyTest
 * @Package: PACKAGE_NAME
 * @Description: 懒惰匹配
 */
public class LazyTest {
    @Test // 懒惰、贪婪匹配共存的情况
    public void testNotGreed(){
        String reg="(\\d{1,2}?)(\\d{3,4})";
        String test="61762828 176 2991 87321";
        Pattern pattern =Pattern.compile(reg);
        Matcher matcher = pattern.matcher(test);
        while(matcher.find()){
            /* 具体情况分析
            "61762" -> true
            "828 " -> false
            "176 " -> false
            "2991" -> true
            " " -> false
            "87321" -> true
             */
            System.out.println("匹配结果："+matcher.group());
        }
        /* 输出结果：
        匹配结果：61762
        匹配结果：2991
        匹配结果：87321
         */
    }
}
