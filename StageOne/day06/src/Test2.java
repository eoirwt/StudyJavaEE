/**
 * @Description: 二维数组深度理解
 */
public class Test2 {
    public static void main(String[] args) {

        // 一位数组不写数字不行
        int[] nums = new int[5];

        // 二为数组一个数字不写，也不行。可以只写第一个
        int[][] nums2 = new int[3][3];
        nums2[0] = new int[3];
        nums2[1] = new int[4];
        nums2[2] = new int[5];

        int nums3[][] = {{1},{1,2},{1,2,3}};

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums3[i].length; j++) {
                System.out.print(nums3[i][j]);
            }
            System.out.println();
        }


    }
}
