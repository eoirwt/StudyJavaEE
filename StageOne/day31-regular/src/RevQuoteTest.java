import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RevQuoteTest
 * @Package: PACKAGE_NAME
 * @Description: 正则捕获分组后的 “反向引用”
 *
 */
public class RevQuoteTest {
    @Test // 需求：要查找一串字母"aabbbbgbddesddfiid"里成对的字母
    public void test1(){
        String context = "aabbxxccdddsksdhfhshh";
        // 数字编号捕获组 的 反向引用，表达式 \number
        /* 具体解释：
        当匹配子字符序列时，\number 反向引就是当前分组的第 number 组的内容
        比如，当匹配到 "aa" 时，"(\w)\1" 经过内部处理后变成 "(\w)a",
        返回出匹配结果后，继续匹配下两位 "bb" ， 以此往复...
         */
        String regex = "(\\w)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
        /* 输出结果：
        aa bb xx cc dd hh */
    }
    @Test // 需求同上
    public void test2(){
        String context = "aabbxxccdddsksdhfhshh";
        // 命名编号捕获组 的 反向引用，表达式 \k<name>
        // 具体逻辑跟 test1() 里的一样
        String regex = "(?<letter>\\w)\\k<letter>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
        /* 输出结果：
        aa bb xx cc dd hh */
    }
    @Test // String类实例的 replaceAll() 使用举例
    public void test3(){ // 需求："abc aabc bc xxx mm"把其中匹配正则的子字符序列替换成指定分组
        String context = "abc aabc bc xxx mm";
        String regex = "(a*)(b)(c)";
        /*
        $number 的意义：
        它表示 每次匹配正则的子字符序列分组过后的 第 number 组的内容,
        比如，当匹配到 “bc”时，第 1 组的内容就是 空
         */
        String result = context.replaceAll(regex, "$1");
        System.out.println(result); // a aa  xxx mm
    }
}
