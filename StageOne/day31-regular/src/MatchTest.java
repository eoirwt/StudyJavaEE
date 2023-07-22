import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Matching
 * @Package: PACKAGE_NAME
 * @Description: Matcher实例的”匹配“方法举例
 * start()、end()
 */
public class MatchTest {
    @Test // start()、end()、 find()的使用案例
    public void test(){
        // 下面是一个对单词 "cat" 出现在输入字符串中出现次数进行计数的例子
        String regex = "cat";
        String content = "cat cat dog dog cat";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        int count = 0;
        /*
        find(): 在 content 里从头开始依次匹配正则；
        如果匹配成功, 返回 true，反之返回 false
        下一次再次调用find(), 将会在上一次匹配时的末尾开始再次匹配；
        如此往复，直至 content 的最后一位
         */
        while (matcher.find()){
            count++;
            System.out.println("matcher.start() = " + matcher.start());
            System.out.println("matcher.end() = " + matcher.end());
        }
        System.out.println("cat 出现了：" + count + "次");
        /*
            "cat cat dog dog cat"
             0123456789........18
         */
        /*
        matcher.start() = 0
        matcher.end() = 3
        matcher.start() = 4
        matcher.end() = 7
        matcher.start() = 16
        matcher.end() = 19
        cat 出现了：3次
         */
    }
}
