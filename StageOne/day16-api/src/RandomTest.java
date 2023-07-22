import java.util.Random;

/**
 * 练习使用 Random类
 */
public class RandomTest {
    public static void main(String[] args) {
        // new Random()
        Random random = new Random();
        // random.nextInt(int bound)
        System.out.println(random.nextInt(100));// 输出100以内的随机数
        // random.nextBytes(Byte[] byte)
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        for(byte item:bytes){
            System.out.print(item + ", ");
        }
        System.out.println();
        // random.ints()
        random.ints(10).forEach(e -> {
            System.out.println(e + ", ");
        });
    }
}
