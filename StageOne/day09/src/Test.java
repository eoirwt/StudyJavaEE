/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/8 22:18
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        SuperLink superLink = new SuperLink();
//        superLink.add(1);
//        superLink.add(2);
//        superLink.add(3);
//        superLink.add(4);
//        superLink.delete(0);
//        superLink.delete(2);
//        superLink.set(0,4);
//        superLink.set(1,6);
//        int val1 = superLink.select(0);
//        int val2 = superLink.select(1);
//        String val = superLink.linkToString();
//        System.out.println(val);
        superLink.addToHead(10);
        superLink.addToHead(9);
        superLink.addToHead(8);
        superLink.add(superLink.currentIndex+1, 11);
        superLink.add(superLink.currentIndex+1, 12);
        superLink.add(superLink.currentIndex+1, 13);
        superLink.add(superLink.currentIndex + 1, 14);
        superLink.add(2, 99);
        superLink.add(5, 133);
        String val = superLink.linkToString();
        System.out.println(val);
    }
}
