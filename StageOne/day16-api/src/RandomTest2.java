import java.util.Random;

/**
 * 这个类主要探讨 Randow类的有参构造和无参构造的区别
 */
public class RandomTest2 {
    public static void main(String[] args) {
        System.out.println("Random 不含参构造方法：");
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            byte[] bytes = new byte[5];
            random.nextBytes(bytes);
            for (int j = 0; j < 5; j++) {
                System.out.print(bytes[j] + ", ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
        System.out.println("Random 含参构造方法：");
        for (int i = 0; i < 4; i++) {
            Random random = new Random(50);
            byte[] bytes = new byte[5];
            random.nextBytes(bytes);
            for (int j = 0; j < 5; j++) {
                System.out.print(bytes[j] + ", ");
            }
            System.out.println();
        }
    }
}
