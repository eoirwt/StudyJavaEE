import java.sql.SQLOutput;
import java.util.Date;

/**
 * ClassName: FormatTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/16 21:40
 * @Version 1.0
 */
public class FormatTest {
    public static void main(String[] args) {
        Date nowTime1 = DateUtil.getNowTime();
        System.out.println(nowTime1);
        Date nowTime2 = DateUtil.getNowTime("2019-9-14 09:25:36");
        System.out.println(nowTime2);

        System.out.println(DateUtil.getNowTimeString());
        System.out.println(DateUtil.getNowTimeString("yyyy年MM月dd日 HH时mm分ss秒"));
    }

}
