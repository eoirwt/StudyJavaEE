import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: AssertTest
 * @Package: PACKAGE_NAME
 * @Description: 正则的 ”零宽断言“
 */
public class AssertTest {
    @Test // 正向先行断言, 获取阅读数
    public void test1(){
        String regex = "\\d*(?=</span>)";
        String context = "<span class=\"read-count\">阅读数：641</span>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while(matcher.find()){
            System.out.println(matcher.group()); // 641
        }
    }
    @Test // 正向后行断言, 获取阅读数
    public void test2(){
        String regex = "(?<=<span class=\"read-count\">阅读数：)\\d*";
        String context = "<span class=\"read-count\">阅读数：641</span>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while(matcher.find()){
            System.out.println(matcher.group()); // 641
        }
    }
    @Test // 负向先行断言，找到不是'的烂叶'前面的祖国
    public void test3() {
        String regex = "祖国(?!的烂叶)";
        String context = "我爱祖国，我是祖国的烂叶";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while(matcher.find()){
            System.out.println(matcher.group()); // 祖国
        }
    }
    @Test // 负向后行断言，要找到不是'我爱'后面的祖国
    public void test4() {
        String regex = "(?<!我爱)祖国";
        String context = "我爱祖国，我是祖国的烂叶";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while(matcher.find()){
            System.out.println(matcher.group()); // 祖国
        }
    }
}
