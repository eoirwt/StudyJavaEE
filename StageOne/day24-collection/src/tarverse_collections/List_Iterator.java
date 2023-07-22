package tarverse_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 使用迭代器遍历 List
 */
public class List_Iterator {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("AA");
        arrayList.add("BB");
        arrayList.add(null);
        arrayList.add("CC");
        Iterator<String> arrayListIterator = arrayList.iterator();
        while (arrayListIterator.hasNext()){
            String next = arrayListIterator.next();
            System.out.println(next);
        }

        System.out.println("-------------");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("DD");
        linkedList.add(null);
        linkedList.add("EE");
        linkedList.add("FF");
        Iterator<String> linkedListIterator = linkedList.iterator();
        while (linkedListIterator.hasNext()){
            String next = linkedListIterator.next();
            System.out.println(next);
        }
    }
}
