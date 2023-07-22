package tarverse_collections;

import java.sql.Array;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * 使用（增强 for 循环） 来遍历 List、hashSet、hashMap、以及普通的数组
 */
public class StrongForCyclic {
    public static void traversalArray(){
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        for(int i : nums){
            System.out.println(i);
        }
    }
    public static void traversalList(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ZS");
        arrayList.add("LS");
        arrayList.add("WW");
        arrayList.add(null);

        for(String s : arrayList){
            System.out.println(s);
        }

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("DD");
        linkedList.add(null);
        linkedList.add("EE");
        linkedList.add("FF");

        for(String s : linkedList){
            System.out.println(s);
        }
    }

    public static void traversalHashSet(){
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

        for (String s : hashSet){
            System.out.println(s);
        }
    }

    public static void traversalHashMap(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "AA");
        hashMap.put(2, "BB");
        hashMap.put(3, "CC");
        hashMap.put(4, "DD");
        hashMap.put(5, "EE");

        for(Map.Entry<Integer, String> entry : hashMap.entrySet() ){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]" );
        }
    }


    public static void main(String[] args) {
        /** 使用增强 for 循环遍历 普通数组 */
//        traversalArray();
        /** 使用增强 for 循环遍历 List */
//        traversalList();

        /** 使用增强 for 循环遍历 hashSet */
//        traversalHashSet();

        /** 使用增强 for 循环遍历 hashMap */
        traversalHashMap();
    }
}
