/**
 * @Description:  数组中查早元素
 */

import java.util.Scanner;
public class FindOne {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5,6,23};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        // 用下标来代替具体的值，因为下标没有负数，我们可以用负数代替 未找到
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                result = i;
                break;
            }
        }
        if(result < 0 || result > nums.length-1){
            System.out.println("该身份证没有记录");
        } else {
            System.out.println("该身份证是："+nums[result]);
        }

    }
}
