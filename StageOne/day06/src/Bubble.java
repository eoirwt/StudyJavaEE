/**
 * @Description: 冒泡排序
 */
public class Bubble {

    public static void main(String[] args) {
        int[] nums = {122,31,24,6,3,34,22,12};

        for (int j = 0; j < nums.length- 1; j++) {
            for (int i = 0; i < nums.length-1; i++) {
                // 当前的下标和他的下一位比较
                if(nums[i] > nums[i+1]){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
