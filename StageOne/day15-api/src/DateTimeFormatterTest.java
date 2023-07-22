import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: DateTimeFormatterTest
 * Package: PACKAGE_NAME
 * Description: 练习使用 DateTimeFormatter 类
 *
 * @Author guohong
 * @Create 2023/3/20 9:33
 * @Version 1.0
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        // 创建一个 LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // DateTimeFormatter.ofPattern("...") 创建DateTimeFormatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 使用format
        System.out.println(now.format(dateTimeFormatter));
        // 使用 DateTimeFormat 解析时间字符串
        LocalDateTime parse = LocalDateTime.parse("2023-03-20 11:05:02", dateTimeFormatter);
        System.out.println(parse);

    }
}
