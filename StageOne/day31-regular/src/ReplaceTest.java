import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: ReplaceTest
 * @Package: PACKAGE_NAME
 * @Description: Matcher实例的”替换“方法举例
 */
public class ReplaceTest {
    @Test // replaceAll(String ..)、replaceFirst(String ..) 的使用案例
    public void test1(){
        String regex = "java";
        String context = "I like use java, java is very good language.";
        String replacement = "php";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        String str1 = matcher.replaceAll(replacement);
        System.out.println(str1); // I like use php, php is very good language.
        String str2 = matcher.replaceFirst(replacement);
        System.out.println(str2); // I like use php, java is very good language.
    }
    @Test // appendReplacement(StringBuffer .., String ..)、appendTail(StringBuffer sb) 的使用案例
    public void test2(){
        String regex = "a*b";
        String context = "aabfooaabfooabfooabkkk";
        String replacement = "-";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(stringBuffer, replacement);

            /* 具体过程
               matcher             stringBuffer
            1: "aab"            -> "-"
            2: "-fooaab"        -> "-foo-"
            3: "-foo-fooab"     -> "-foo-foo-"
            4: "-foo-foo-fooab" -> "-foo-foo-foo-"
             */
        }
        System.out.println(stringBuffer); // "-foo-foo-foo-"
        stringBuffer = matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer); // "-foo-foo-foo-kkk"
    }
}
