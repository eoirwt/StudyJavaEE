/**
 * @Description: 二分法查找 ☆
 */
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {1,3,5,7,8,12,23};
        System.out.println("请输入您要查找的数字：");
        int target = scanner.nextInt();

        // 需要两个变量去确定检索范围
        int left = 0;
        int right = nums.length - 1;

        if(target < nums[0] || target > nums[nums.length-1]){
            System.out.println("您输入的不在范围之内！");
        } else {
            // 保存我们的结果
            int res = -1;
            // 左右边界不重合就继续
            while (left <= right){
                int middle = (left + right)/2;
                if(nums[middle] == target){
                    res = middle;
                    break;
                } else if(nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            System.out.println(res);
        }
    }
}
