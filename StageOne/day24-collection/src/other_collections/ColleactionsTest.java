package other_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Colleactions 工具类的使用
 */
public class ColleactionsTest {
    public static void test(){
        /**
         Arrays.asList() 返回一个长度内容固定的List集合,
         它的类型是 java.util.Arrays.ArrayList<E>，
         切记不要与 java.util.ArrayList<E>弄混淆!
        */
        List<String> stringList = Arrays.asList("tom", "kobe", "jordan", "tracy", "westbook", "yaoming", "ace", "stephen");
        System.out.println(stringList instanceof ArrayList); // false
        Collections.sort(stringList);
        System.out.println(stringList); // [ace, jordan, kobe, stephen, tom, tracy, westbook, yaoming]
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        // addAll(): 方法可以往集合中添加元素，也可往集合中添加一个集合
        Collections.addAll(arrayList, 12,3,4,1);
        System.out.println(arrayList); // [12, 3, 4, 1]

        // sort(): 将集合的元素按照默认的规则排序
        Collections.sort(arrayList);
        System.out.println(arrayList); // [1, 3, 4, 12]

        // reverse(): 将集合中的元素反转
        Collections.reverse(arrayList);
        System.out.println(arrayList); // [12, 4, 3, 1]

        // shuffle(): 打乱集合中的元素
        Collections.shuffle(arrayList);
        System.out.println(arrayList); // [4, 12, 1, 3]

        /** Arrays.asList() !特别注意！ */
        test();
    }
}
