package generic_wipe;

/**
 *  泛型不能是基本数据类型
 */
public class Test1 {
    public static void main(String[] args) {
        /*
        Comparator<int> comparator = new Comparator<int>(){
            // ...
        };
        */
        // 编译报错: Type argument cannot be of primitive type
    }
}
