package tarverse_collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 集合在遍历中删除元素的几种方式
 */
public class Iterator_Del {

    public static void del1(ArrayList<String> arrayList ){
        arrayList.remove("lucy");
        System.out.println(arrayList); // [tom, lucy, lucy, jerry, lucy]
        /** 集合本身的 remove() 只能删除首个元素, 这种方式不可用 */
    }

    public static void del2(ArrayList<String> arrayList ){
        for (int i = 0; i < arrayList.size(); i++) {
            if("lucy".equals(arrayList.get(i))){
                arrayList.remove(i);
                /**
                 必须要 “回调指针”，
                 因为当该元素被删除时，集合中所有的元素都会向前移动一位，补上空缺，
                 如果不这样做，最终的结果将会是: [tom, lucy, jerry],
                 而期望的结果是： [tom, lucy]
                 */
                i--;
            }
        }
        System.out.println(arrayList);
    }

    public static void del3(ArrayList<String> arrayList ){
        for (int i = arrayList.size() - 1; i >= 0 ; i--) {
            if("lucy".equals(arrayList.get(i))){
                arrayList.remove(i);
            }
        }
        System.out.println(arrayList); // [tom, jerry]
    }

    public static void del4( ){
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(31);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);

        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next > 4 ){
                iterator.remove();
                /** 迭代器里不能使用集合原生的remove()，否者运行一定报错 java.util.ConcurrentModificationException*/
//                hashSet.remove(next);
            }
        }

        /**
         尝试：使用增强 for 循环来遍历集合删除元素,
         它本质还是使用里迭代器，迭代器中用原生的remove()就会报错
         */
        /*
        for(Integer integer : hashSet){
            // 发现只能调用集合原生的 remove()
            if(integer > 4){
                hashSet.remove(integer);
            }
        }
        */

        System.out.println(hashSet); // [1, 2, 4]


    }
    public static void main(String[] args) {
        /** 删除集合 arrayList 中重复的 "lucy" ，有多种方式*/
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("tom");
        arrayList.add("lucy");
        arrayList.add("lucy");
        arrayList.add("lucy");
        arrayList.add("jerry");
        arrayList.add("lucy");

        /** 方式1：使用 集合本身的 remove() 来删除 （不合适）*/
//        del1(arrayList);

        /**
         方式2：使用 for 循环 来删除
         (只有 List 才可以用 for 循环来遍历删除指定的元素，Set 和 Map 不可以，
         因为它们无法通过索引下标来获取元素，也没法通过索引下标来删除元素)

         需要注意的是，List 在删除一个元素后会自动 ”回填“, 这可能导致再遍历时引发指针问题,
         以下又两种解决方案：
        */
        /** 方案一 ： 指针回调 */
//        del2(arrayList);
        /** 方案二： 逆序遍历 */
//        del3(arrayList);

        /**
         方式3：使用迭代器来删除元素
         list、HashSet、hashMap都能用迭代器来删除元素
         */
        del4();
    }
}
