/**
 * @Description: 可变参数的使用
 */
public class Computer {

    int age;

    public int plus(int b,int c,int...nums){
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (; i < nums.length; i++) {
                res += nums[i];
            }
            res += nums[i];
        }

        return res;
    }

    public int plus(int b,int c){
        int a = age;
        return b + c;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.plus(1,1,2,3,4,5));
    }

}
