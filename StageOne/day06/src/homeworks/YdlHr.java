/**
 * @Description: 工号管理系统
 */
package homeworks;
import java.util.Scanner;

public class YdlHr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums[] = new int[2];
        int currentIndex = -1;
        // 可以一直选择功能，1 添加  2 查找 3 退出
        while (true){
            // 选择功能
            System.out.println("请选择功能：1 添加工号  2 查找工号 3 打印所有员工 4 退出");
            int function = scanner.nextInt();
            if(function == 4){
                break;
            }
            if(function == 1){
                System.out.println("请输入要添加的工号：");
                int num = scanner.nextInt();

                // 一定要判断，是否需要扩容
                currentIndex++;
                // 不满足条件先去扩容
                if(currentIndex > nums.length-1){
                    int[] temp = new int[nums.length*2];
                    // 拷贝的过程
                    for (int i = 0; i < nums.length; i++) {
                        temp[i] = nums[i];
                    }
                    // 改变引用
                    nums = temp;
                }
                nums[currentIndex] = num;
            }
            if(function == 2){
                System.out.println("请输入要查找的工号：");
                int num = scanner.nextInt();
                int result = -1;
                for (int i = 0; i < nums.length; i++) {
                    if(nums[i] == num){
                        result = i;
                        break;
                    }
                }
                System.out.println( result == -1 ? "改工号不存在" : "该工号存在："+nums[result] );
            }
            if(function == 3){
                for (int i = 0; i <= currentIndex; i++) {
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
