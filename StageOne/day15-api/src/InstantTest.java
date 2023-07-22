import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

/**
 * ClassName: InstantTest
 * Package: PACKAGE_NAME
 * @Description: 练习 Instant 时间类的使用
 *
 * @Author guohong
 * @Create 2023/3/19 10:04
 * @Version 1.0
 */
public class InstantTest {
    public static void main(String[] args) {
        // 创建 Instant 实例
        Instant install = Instant.now();
        System.out.println(install);
        // 获取微妙
        int s = install.get(ChronoField.MICRO_OF_SECOND);
        System.out.println(s);
        // 添加时间 秒
        Instant instant = install.plusSeconds(60 * 60 * 24 * 2);
        System.out.println(instant);
        // 添加时间 时间量
        Instant instant1 = install.plus(Duration.ofDays(6));
        System.out.println(instant1);
        // 解析时间字符串
        Instant instant2 = Instant.parse("2023-03-25T07:22:44.722Z");
        // 指定时区
        /*ZonedDateTime zonedDateTime = install.atZone(ZoneId.of("GMT+08:00"));
        System.out.println(zonedDateTime);*/
        // 指定默认时区
        /*ZonedDateTime zonedDateTime = install.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);*/




    }
}
