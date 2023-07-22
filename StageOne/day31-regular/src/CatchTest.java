import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: CatchTest
 * @Package: PACKAGE_NAME
 * @Description: 正则的 ”捕获和非捕获“
 */
public class CatchTest {
    @Test // 数字编号捕获组
    public void catchByGroupNumber(){
        String context = "020-85653333 030-85656666";
        String regex="(0\\d{2})-(\\d{8})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()){
            System.out.println("当前分组个数有:" + matcher.groupCount() + "个");
            for (int i = 0; i <= matcher.groupCount(); i++){
                System.out.println(i + "组: " + matcher.group(i)); // group(0) = group()
            }
            System.out.println("--------------------");
        }
        /* 输出结果：
        当前分组个数有:2个
        0组: 020-85653333
        1组: 020
        2组: 85653333
        --------------------
        当前分组个数有:2个
        0组: 030-85656666
        1组: 030
        2组: 85656666
        --------------------
         */
    }
    @Test // 命名编号捕获组
    public void catchByGroupName() {
        String context = "020-85653333 030-85656666";
        String regex="(?<areacode>0\\d{2})-(?<phone>\\d{8})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()){
            System.out.println("当前分组个数有:" + matcher.groupCount() + "个");
            System.out.println("areacode组: " + matcher.group("areacode"));
            System.out.println("phone组: " + matcher.group("phone"));
            System.out.println("--------------------");
        }
        /* 输出结果：
        当前分组个数有:2个
        areacode组: 020
        phone组: 85653333
        --------------------
        当前分组个数有:2个
        areacode组: 030
        phone组: 85656666
        --------------------
         */
    }
    @Test // 非捕获组
    public void unCatchGroup() {
        String context = "020-85653333";
        String regex="(?:0\\d{2})-(\\d{8})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()){
            System.out.println("当前分组个数有:" + matcher.groupCount() + "个");
            for (int i = 0; i <= matcher.groupCount(); i++){
                System.out.println(i + "组: " + matcher.group(i)); // group(0) = group()
            }
        }
        /* 输出结果：
        当前分组个数有:1个
        0组: 020-85653333
        1组: 85653333
         */
    }
}
