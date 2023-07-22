/**
 * @Description: 数组中元素交换
 */
public class ArrayChange {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,2,45,565};

        int temp = nums[3];
        nums[3] = nums[2];
        nums[2] = temp;


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
