package tarverse_collections;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 使用迭代器遍历 hashSet
 */
public class HashSet_Iterator {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("e");
        hashSet.add("z");
        hashSet.add("m");
        hashSet.add("n");
        hashSet.add("h");
        hashSet.add("r");

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
