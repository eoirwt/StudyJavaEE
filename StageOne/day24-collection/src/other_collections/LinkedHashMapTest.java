package other_collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 的使用及特性
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("m","abc");
        linkedHashMap.put("a","abc");
        linkedHashMap.put("g","bcd");
        linkedHashMap.put("s","cde");
        linkedHashMap.put("z","def");

        // 迭代遍历 linkedHashMap，看看元素的排列情况
        Iterator<Map.Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("[key:" + next.getKey() + ", value:" + next.getValue() + "]");
            /**
             [key:m, value:abc]
             [key:a, value:abc]
             [key:g, value:bcd]
             [key:s, value:cde]
             [key:z, value:def]

             由此可见，LinkedHashMap集合的元素是有顺序的，默认是按照插入顺序排列,
             假若换成 HashMap 就会变成无序了
             */
        }
    }
}
