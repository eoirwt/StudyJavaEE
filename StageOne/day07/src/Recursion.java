/**
 * @Description: 递归的应用： 斐波那契数列 与 阶乘
 */
public class Recursion {

    //斐波那切数列的第几项是几？
    public int fibonacci(int num){
        if(num == 0 || num == 1){
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    // 求传入参数的阶乘
    public int factorial(int num){
        if(num == 1){
            return 1;
        }
        return num * factorial(num-1);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        int fibonacci = recursion.fibonacci(10);
        System.out.println(fibonacci);

        int factorial = recursion.factorial(5);
        System.out.println(factorial);
    }

}
