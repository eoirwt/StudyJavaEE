/**
 * @Description: 杨辉三角的实现
 */
public class YangHuiSanJiao {

    public static void main(String[] args) {
        // 杨辉三角的高度
        int maxHeight = 15;
        // 搞一个二维数组
        int[][] nums = new int[maxHeight][];
        for (int i = 0; i < maxHeight; i++) {
            nums[i] = new int[i+1];
        }

        // 从第三层开始计算 nums[n][i] = nums[n-1][i-1] + nums[n-1][i]
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                // 边界判断，边界就是1
                if(j == 0 || j == nums[i].length - 1){
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }


    }

}
