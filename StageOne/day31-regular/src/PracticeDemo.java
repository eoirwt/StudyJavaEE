import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: PracticeDemo
 * @Package: PACKAGE_NAME
 * @Description: 三个正则的练习案例
 */
public class PracticeDemo {
    @Test // 邮箱检测
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        java.lang.String email = scanner.next();
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean matches = matcher.matches();
        if(matches){
            System.out.println("您输入的是一个邮箱！");
        } else {
            System.out.println("您输入的不是邮箱！");
        }
    }

    @Test // 在文件中查找出邮箱
    public void test2() throws IOException {
        // 1、读取文件，把内容加载到内存中
        InputStream inputStream = new FileInputStream("D:\\gh_09\\Desktop\\user.txt");
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            sb.append(new String(buffer, 0, len));
        }
        // 2、使用正则匹配邮箱
        String regex = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()){
            // 3、获取邮箱
            System.out.println(matcher.group());
        }
    }

    @Test // 修改文件中的电话号码, 比如 15236985456 -->  152xxxx5456
    public void test3() throws IOException {
        // 1、读取文件，把内容加载到内存中
        InputStream inputStream = new FileInputStream("D:\\gh_09\\Desktop\\user.txt");
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            sb.append(new String(buffer, 0, len));
        }
        // 2、使用正则匹配电话号码
        String regex = "(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])(\\d{4})(\\d{4})";
        // 通过正则的 “反向引用” 的方式来修改
        // 方式一：
        /*
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb.toString());
        String result = matcher.replaceAll("$1xxxx$2");
        System.out.println(result);
         */
        // 方式二
        String result = sb.toString().replaceAll(regex, "$1xxxx$2");
        System.out.println(result);
    }
}
