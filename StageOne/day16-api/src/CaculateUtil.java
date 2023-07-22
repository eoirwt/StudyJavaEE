import java.math.BigDecimal;

/**
 * 基于 BigDecimal类 封装一个计算工具类: CaculateUtil
 */
public class CaculateUtil {
    public static double addition(double d1, double d2){
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d1));
        BigDecimal addResult = bigDecimal.add(new BigDecimal(Double.toString(d2)));
        return addResult.doubleValue();
    }

    public static double subtraction(double d1, double d2){
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d1));
        BigDecimal subResult = bigDecimal.subtract(new BigDecimal(Double.toString(d2)));
        return subResult.doubleValue();
    }
}
