public class Test3 {

    public static void main(String[] args) {
        Integer num1 = 127;
        Integer num2 = 127;
        System.out.println(num1 == num2);

        num1 = new Integer(127);
        num2 = new Integer(127);
        System.out.println(num1 == num2);

        num1 = 128;
        num2 = 128;
        System.out.println(num1 == num2);

    }

}
