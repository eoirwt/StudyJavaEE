import java.util.Scanner;
/**
 * 了解什么是 异常, 异常产生的后果，练习简单的处理异常
 */
public class ExceptionTest1 {
    public static void main(String[] args) {
        while (true){
            int num1 = 10;
            Scanner scanner = new Scanner(System.in);
            int num2 = scanner.nextInt(); // 如果 输入值 为 0, 再下部运算时, 系统会报错
            try {
                int res = num1 / num2;
                System.out.println(res);
            }catch (Exception e){
                System.out.println("输入数值不能为 0 ");
            }

            System.out.println("后边还有代码呦！");
        }
    }
}
