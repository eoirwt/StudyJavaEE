import java.util.Scanner;

/**
 * 异常的抛出与捕获
 */
public class ExceptionTest2 {
    public static void func(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if(i < 5){
                System.out.println("数值小于5");
            }else {
                throw new RuntimeException("数值不小于5"); // 抛出异常，程序终止！
            }
        }
    }
    public static void func2(){
        try {
            // 捕获异常
            func();
        }catch (RuntimeException e) {
            // 处理异常
//            e.printStackTrace(); // 打印异常信息
            throw e;
        }
    }
    public static void main(String[] args) {
        try {
            func2();
        }catch (RuntimeException e){
            System.out.println("在main方法里处理 func2() 抛出的异常");
            e.printStackTrace();
        }
    }
}
