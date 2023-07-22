package other_collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于 LinkedHashMap 实现 LRU 算法的缓存
 */
public class LRU<k,v> extends LinkedHashMap<k,v> {
    static int num = 0;

    int CacheNum;

    public LRU(int initialCapacity, float loadFactor, int CacheNum) {
        super(initialCapacity, loadFactor, true);
        this.CacheNum = CacheNum;
    }

    public LRU() {
        super(16, 0.75F, true);
        this.CacheNum = 8;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        LRU.num++;
        /**
         * 当集合元素长度大于8时，就会自动删除头元素，应为 accessOrder 为 true，所以头元素是不常用的元素
         */
        return this.size() > this.CacheNum;
    }

    /** 该测试方法主要了解 LinkedHashMap 集合的排列顺序 */
    public static void testFunc(){
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75F, true);
//        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("m","abc");
        linkedHashMap.put("a","abc");
        linkedHashMap.put("g","bcd");
        // get()访问指定元素
        linkedHashMap.get("a");
        linkedHashMap.put("s","cde");
        linkedHashMap.get("m");
        linkedHashMap.put("z","def");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]");
            /**
             [key:g, value:bcd]
             [key:a, value:abc]
             [key:s, value:cde]
             [key:m, value:abc]
             [key:z, value:def]

             如果 accessOrder 为 false 的话，顺序会按照插入的顺序
             [key:m, value:abc]
             [key:a, value:abc]
             [key:g, value:bcd]
             [key:s, value:cde]
             [key:z, value:def]
             */
        }
    }
    public static void main(String[] args) {
//        testFunc();
        Map<String,String> map = new LRU<>();
        map.put("m","abc");
        map.put("g","bcd");
        map.put("s","cde");
        map.put("z","def");
        map.put("z1","def");
        map.put("z2","def");

        map.get("m");

        map.put("z3","def");
        map.put("z4","def");
        map.put("z5","def");
        map.put("z6","def");
        for ( Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]" );
            /**
             [key:z, value:def]
             [key:z1, value:def]
             [key:z2, value:def]
             [key:m, value:abc]
             [key:z3, value:def]
             [key:z4, value:def]
             [key:z5, value:def]
             [key:z6, value:def]
             */
        }

        /**
         removeEldestEntry() 被调用了 10 次，
         由此可见 每次 put() 都会调用 removeEldestEntry()
         */
        System.out.println("removeEldestEntry() 被调用了 " + LRU.num + " 次");

        Comparable comparable = "123";
        String s = (String)comparable;
    }
}
