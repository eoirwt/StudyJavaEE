/**
 * @Description:  数组中查找最大值
 */
public class FindMax {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 143, 5, 6, 23};

        // 第一个人先上擂台
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            // 擂台上的小于当前的，当前的人留在擂台
            if(nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
        }

        System.out.println(nums[maxIndex]);

    }

}
