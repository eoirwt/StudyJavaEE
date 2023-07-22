import java.time.*;
import java.util.Date;

/**
 * Description: 练习 各种时间类 的相互转换
 *
 * @Author guohong
 * @Create 2023/3/20 15:52
 * @Version 1.0
 */
public class TimeClassInterconversion {
    public static void main(String[] args) {
         // Instant <-> Date
        Instant instant = Instant.now();
        Date date1 = Date.from(instant);
        System.out.println(date1);

        Date date = new Date();
        Instant instant1 = date.toInstant();
        System.out.println(instant1);

        // Instant <-> LocalDataTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);

        Instant instant2 = localDateTime.toInstant(ZoneOffset.UTC);
        System.out.println(instant2);

        // LocalDate <- LocalDateTime
        LocalDate localDate = LocalDate.from(localDateTime);
        System.out.println(localDate);

        // LocalTime <- LocalDateTime
        LocalTime localTime = LocalTime.from(localDateTime);
        System.out.println(localTime);

        /*
        思考: LocalTime -> LocalDateTime ?
             LocalDate -> LocalDateTime ?
        结果: 不能这么转换，会报错，因为精度会丢失!
        */


        // Date <-> LocalDateTime
        //Date -> Instant -> LocalDateTime
        /*
        Date date = new Date();
        Instant instant1 = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
        */

        // LocalDateTime -> instant -> Date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Instant instant3 = localDateTime1.toInstant(ZoneOffset.UTC);
        Date date2 = Date.from(instant3);


    }
}
