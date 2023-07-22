/**
 * @Description: 归并的思路☆
 */
public class Merger {

    public static void main(String[] args) {
        int[] array1 = {1,3};
        int[] array2 = {2,4,5};

        // 代表上擂台的两个人的下标，一个来自一队，一个来自二队
        int i = 0;
        int j = 0;

        // 创建一个大的数组
        int[] newArray = new int[array1.length + array2.length];

        // 从开始下标为零的一个一个比较
        while ( i < array1.length || j <array2.length){
            // 一队已经全部结束了，二队剩余的全部放入
            if(i == array1.length){
                newArray[i+j] = array2[j];
                j++;
                continue;
            }

            // 二队已经全部结束了，一队剩余的全部放入
            if(j == array2.length){
                newArray[i+j] = array1[i];
                i++;
                continue;
            }

            if(array1[i] > array2[j]){
                newArray[i+j] = array2[j];
                j++;
            } else {
                newArray[i+j] = array1[i];
                i++;
            }
        }

        for (int k = 0; k < newArray.length; k++) {
            System.out.println(newArray[k]);
        }
    }
}
