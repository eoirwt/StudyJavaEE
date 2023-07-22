package tarverse_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用迭代器遍历 hashMap (多种方式)
 *
 * 该案例有两种遍历方式，分别在 func1() 与 func2() 中体现
 */
public class HashMap_Iterator {
    public static void func1(Map<Integer,String> hashMap){
        Set<Integer> keySet = hashMap.keySet();
        Iterator<Integer> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()){
            Integer key = keySetIterator.next();
            String value = hashMap.get(key);
            System.out.println(value);
        }
    }
    public static void func2(Map<Integer,String> hashMap){
        // 1. 转换成保存 entry 的 Set 集合, entry 就是 Map 中的 node
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        // 2. 获取迭代器
        Iterator<Map.Entry<Integer, String>> entryIterator = entries.iterator();
        while(entryIterator.hasNext()){
            // 3. 拿到每一个 entry
            Map.Entry<Integer, String> entry = entryIterator.next();
            // 4. 获取 key 和 value
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("[key:" + key + ", value:"+value+"]");
        }
    }
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "AA");
        hashMap.put(2, "BB");
        hashMap.put(3, "CC");
        hashMap.put(4, "DD");
        hashMap.put(5, "EE");

        /** 方式 1：转化成 keySet，再遍历 keySet 的同时，通过 key 获取 value */
//        func1(hashMap);

        /** 方式 2：转换成保存 entry 的 Set 集合， 通过 entry 获取 Map 的 key 和 value */
        func2(hashMap);
    }
}
