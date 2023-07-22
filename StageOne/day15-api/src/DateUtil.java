import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  时间工具类
 */
public class DateUtil {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 获取当前时间对象实例
     * @return new Date()
     */
    public static Date getNowTime(){
        return new Date();
    }

    /**
     * 指定 时间字符串 返回时间对象实例
     * @param date 符合默认时间模式的时间字符串
     * @return 时间对象实例
     */
    public static Date getNowTime(String date){
        return getNowTime(date, DateUtil.DEFAULT_PATTERN);
    }

    /**
     * 指定 时间字符串 、时间模式，返回时间对象实例
     * @param date 时间字符串(符合指定时间模式)
     * @param pattern 时间模式
     * @return Date parse or null
     */
    public static Date getNowTime(String date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }

    /**
     * 使用默认时间格式获取当前时间
     * @return
     */
    public static String getNowTimeString(){
        return getNowTimeString(DateUtil.DEFAULT_PATTERN);
    }

    /**
     * 指定时间格式获取当前时间
     * @param pattern
     * @return
     */
    public static String getNowTimeString(String pattern){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(date);
    }
}
