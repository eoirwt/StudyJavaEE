import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: FindTest
 * @Package: PACKAGE_NAME
 * @Description: Matcher实例的”查找“方法举例
 */
public class FindTest {
    @Test // lookingAt()、matches() 的使用案例
    public void test(){
        String regex = "java";
        String content1 = "java";
        String content2 = "java is very good  !";
        String content3 = "My work is java.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(content1);
        Matcher matcher2 = pattern.matcher(content2);
        Matcher matcher3 = pattern.matcher(content3);
        System.out.println("matcher1.lookingAt() = " + matcher1.lookingAt()); // true
        System.out.println("matcher1.matches() = " + matcher1.matches()); // true
        System.out.println("matcher2.lookingAt() = " + matcher2.lookingAt()); // true
        System.out.println("matcher2.matches() = " + matcher2.matches()); // false
        System.out.println("matcher3.lookingAt() = " + matcher3.lookingAt()); // false
        System.out.println("matcher3.matches() = " + matcher3.matches()); // false
    }
    @Test // find() 在 MatchTest 中具体已使用并解释过；find(int start) 的使用案例
    public void TestFind(){
        String regex = "java";
        String content = "java php java c#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        // find(int start): 指定起始位置开始匹配正则
        System.out.println(matcher.find(13)); // false
    }
}
