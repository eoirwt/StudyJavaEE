package generic_wipe;

import generic_extend.Comparator;
import generic_extend.User;

/**
 * 方法参数为 带类型参数的泛型的时候, 可能无法构成重载
 */
public class Test2 {
//    public static void func(Comparator<Student> studentComparator){}
    public static void func(Comparator<User> userComparator){}

    /*
    上面两个方法不会构成重载, 反而会引起冲突,
    应为在编译时会擦除泛型, 用Object替代，那就相当于有两份
    public static void func(Comparator xxxxxxx){}
     */


}
