import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
    ArrayList 和 LinkedList 两种线性表的使用(常见的增删改查)
 */
public class ListTest {
    public static void add(List<String> list) {
        list.add("a");
        list.add("b");
    }
    public static void addAll(List<String> list1, List<String> list2){
        list1.addAll(list2);
    }

    public static void remove(List<String> list){
        list.remove(0);
    }

    public static void removeAll(List<String> list1, List<String> list2){
        list1.removeAll(list2);
    }

    public static void set(List<String> list, String str){
        list.set(0, str);
    }

    public static String print(List<String> list){
        String str = "[";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i) + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }

    public static void main(String[] args) {

        List<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("c");
        arrayList2.add("d");

        ListTest.add(arrayList1);
        System.out.println(arrayList1.toString()); // [a, b]

        ListTest.addAll(arrayList1,arrayList2);
        System.out.println(ListTest.print(arrayList1)); // [a, b, c, d]

        ListTest.remove(arrayList1);
        System.out.println(arrayList1.toString()); // [b, c, d]

        ListTest.removeAll(arrayList1, arrayList2);
        System.out.println(arrayList1.toString()); // [b]

        ListTest.set(arrayList1, "a");
        System.out.println(arrayList1.toString()); // [a]

        /** LinkedList 的用法与 ArrayList 大致相同 */
        /*
        List<String> linkedList1 = new LinkedList<>();
        List<String> linkedList2 = new LinkedList<>();
        linkedList2.add("c");
        linkedList2.add("d");

        ListTest.add(linkedList1);
        System.out.println(linkedList1); // [a, b]

        ListTest.addAll(linkedList1, linkedList2);
        System.out.println(linkedList1); // [a, b, c, d]

        ListTest.remove(linkedList1);
        System.out.println(linkedList1); // [b, c, d]

        ListTest.removeAll(linkedList1, linkedList2);
        System.out.println(linkedList1); // [b]

        ListTest.set(linkedList1, "a");
        System.out.println(linkedList1); // [a]
        */

    }
}
