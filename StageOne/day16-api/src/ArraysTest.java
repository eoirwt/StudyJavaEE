import java.util.Arrays;
import java.util.Random;

/**
 * Arrays工具类的使用
 */
public class ArraysTest {
    public static void toStringFunc() {
        int[] ints = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ints));
    }
    public static void sortFunc(int[] ints){
        Arrays.sort(ints);
    }
    public static int binarySearchFunc(int[] ints, int targetValue){
        return Arrays.binarySearch(ints, targetValue);
    }
    public static void equalsFunc(){
        int[] ints = new int[]{1,2,3,4};
        int[] ints1 = new int[]{1,2,3,4};
        System.out.println(Arrays.equals(ints, ints1));
    }
    public static void copyOfFunc(){
        // Arrays.copyOf
        int[] ints = {1,2,3,4,5};
        int[] ints1 = Arrays.copyOf(ints, ints.length * 2);
        System.out.println(Arrays.toString(ints1));

        // Arrays.copyOf 实际又调用了 System.arraycopy() 这个底层方法
        int[] ints2 = new int[ints.length * 2];
        System.arraycopy(ints,0, ints2, 3, ints.length);
        System.out.println(Arrays.toString(ints2));

        // Arrays.copyOfRange()
        int[] ints3 = Arrays.copyOfRange(ints1, 0, 3);
        System.out.println(Arrays.toString(ints3));

    }
    public static void main(String[] args) {

        // Arrays.toString()
//        toStringFunc();// [1, 2, 3, 4, 5]

/*
        int[] ints = new int[1000_0000];
        Random random = new Random();

        for (int i = 0; i < ints.length - 1; i++) {
            ints[i] = random.nextInt();
        }
*/

        // Arrays.sort() 排序 一千万的数据 仅需 1.120秒
//        sortFunc(ints);

//        long start = System.currentTimeMillis();

        // Arrays.binarySearch()
/*
        int index = binarySearchFunc(ints, random.nextInt());
        System.out.println(index);
*/

//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

        // Arrays.equals()
//        equalsFunc();
        // Arrays.copyOf()
        copyOfFunc();
    }
}
