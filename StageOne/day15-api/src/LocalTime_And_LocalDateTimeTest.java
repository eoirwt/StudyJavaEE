import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * ClassName: LocalTime_And_LocalDateTimeTest
 * Package: PACKAGE_NAME
 * Description: 练习使用 LocalTime 和 LocalDateTime 时间类
 *
 * @Author guohong
 * @Create 2023/3/20 9:28
 * @Version 1.0
 */
public class LocalTime_And_LocalDateTimeTest {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);// 09:31:26.134
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);// 2023-03-20T09:32:46.626
    }
}
