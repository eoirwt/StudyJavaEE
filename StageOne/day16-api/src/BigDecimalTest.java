import java.math.BigDecimal;

/**
 * 练习 BigDecimal 类的使用
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2); // 0.30000000000000004

        BigDecimal bigDecimal = new BigDecimal("0.1");
        BigDecimal addResult = bigDecimal.add(new BigDecimal("0.2"));
        double v = addResult.doubleValue();
        System.out.println(v); // 0.3

        // 使用 CaculateUtil 工具类
        double additionRes = CaculateUtil.addition(0.1, 0.2);
        System.out.println(additionRes);// 0.3
        double subtractionRes = CaculateUtil.subtraction(0.1, 0.2);
        System.out.println(subtractionRes); // -0.1
    }
}
