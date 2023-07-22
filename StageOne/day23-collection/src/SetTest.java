import java.util.ArrayList;
import java.util.HashSet;

/**
 * HashSet 线性表的使用
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        /**
         与 List 类似有增和删功能，但 Set 没有改和差功能,
         并且它的结构特性与 List 不同:
            1. 数据不重复
            2. 无序添加
         */
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("e");
        hashSet.add("z");
        hashSet.add("m");
        hashSet.add("n");
        hashSet.add("h");
        hashSet.add("r");

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("e");
        arrayList.add("z");
        arrayList.add("m");
        arrayList.add("n");
        arrayList.add("h");
        arrayList.add("r");

        System.out.println("List: " + arrayList); // List: [a, b, c, e, z, m, n, h, r]
        System.out.println("Set: " + hashSet); // Set: [a, b, r, c, e, h, z, m, n]

        /** 向 List 中重复添加相同数据 */
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        System.out.println(arrayList); // [a, b, c, e, z, m, n, h, r, a, b, c]

        /** 利用 Set 的结构特性, 来删除 List 中重复的相同数据, 但 List 中原来数据的顺序会被打乱 */
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.addAll(arrayList);
        arrayList.clear(); // 清空
        arrayList.addAll(hashSet1);
        System.out.println(arrayList); // [a, b, r, c, e, h, z, m, n]


    }

}
