/**
 * @Description: 定义数组，遍历数组
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1,23,12,3,4};

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        // 能不能使用while来遍历nums

        int i = 0;
        while (i < nums.length){
            System.out.println(nums[i]);
            i++;
        }

    }
}
