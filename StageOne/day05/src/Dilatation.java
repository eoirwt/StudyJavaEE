/**
 * @Description:  数组的扩容
 */
public class Dilatation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // 1、创建一个大数组
        int[] temp = new int[nums.length*2];
        // 拷贝的过程
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        // 改变引用
        nums = temp;

        nums[3] = 9;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
