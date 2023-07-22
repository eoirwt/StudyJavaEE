/**
 * @Description:  数组反转 思路①
 */
public class ArrayReverse {
    public static void main(String[] args) {
        int[] nums = {1,2,4,23,434};
        // 思路一
        // 创建一个新的数组
        int[] temp = new int[nums.length];
        // 讲nums的数据反着放入temp
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[nums.length - 1 - i];
        }
        nums = temp;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
