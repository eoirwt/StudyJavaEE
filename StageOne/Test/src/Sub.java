/**
 * ClassName: Sub
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/10 20:50
 * @Version 1.0
 */
public class Sub extends Base{
    public String name = "dog";

    public void add(int a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("sub_1");
    }
//    	public void add(int a, int b, int c) {
//		System.out.println("sub_2");
//	}
}
