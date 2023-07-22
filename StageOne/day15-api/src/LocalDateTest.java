import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Description: 练习使用 LocalDate 类
 *
 * @Author guohong
 * @Create 2023/3/19 16:28
 * @Version 1.0
 */
public class LocalDateTest {
    public static void main(String[] args) {
        // 创建实例
        LocalDate now = LocalDate.now();
        System.out.println(now);
        // 获取当年有多少天
        int y1 = now.lengthOfYear();
        System.out.println(y1);
        // 获取当月有多少天
        int m1 = now.lengthOfMonth();
        System.out.println(m1);
        // 获取 当年
        int year = now.getYear();
        System.out.println(year);
        // 获取当月
        int monthValue = now.getMonthValue();
        System.out.println(monthValue);
        // 添加时间量
        LocalDate localDate = now.plus(3, ChronoUnit.DAYS);
        System.out.println(localDate);
        // 创建时间副本并修改时间
        LocalDate localDate1 = now.withMonth(4);
        System.out.println(localDate1);

        if(now.isSupported(ChronoField.DAY_OF_WEEK)){
            int i = now.get(ChronoField.DAY_OF_WEEK);
            System.out.println(i);
        }

    }
}
