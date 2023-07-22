/**
 * @Description:  数组反转 思路②
 */
public class ArrayReverse2 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,23,434};
        // 思路二
        // 收尾两两交换
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
