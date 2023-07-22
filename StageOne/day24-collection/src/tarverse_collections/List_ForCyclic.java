package tarverse_collections;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 使用普通 for 循环遍历 List
 */
public class List_ForCyclic {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ZS");
        arrayList.add("LS");
        arrayList.add("WW");
        // list 可以添加 null
        arrayList.add(null);
        // 关键：通过下标遍历List！
        for (int i = 0; i < arrayList.size(); i++) {

            System.out.println(arrayList.get(i));
            /*
                ZS
                LS
                WW
                null
             */
        }

        System.out.println("--------");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("AA");
        linkedList.add("BB");
        linkedList.add("CC");
        linkedList.add(null);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
            /*
                AA
                BB
                CC
                null
             */
        }

    }
}
