package other_collections;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap的使用
 */
public class TreeMapTest {
    public static void test1(){
        Map<String, String> treeMap1 = new TreeMap<>();
        treeMap1.put("m","abc");
        treeMap1.put("a","abc");
        treeMap1.put("g","bcd");
        treeMap1.put("s","cde");
        treeMap1.put("z","def");
        for(Map.Entry<String, String> entry : treeMap1.entrySet()){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]" );
            /**
             [key:a, value:abc]
             [key:g, value:bcd]
             [key:m, value:abc]
             [key:s, value:cde]
             [key:z, value:def]
             */
        }

        System.out.println("-------------");

        Map<Integer, String> treeMap2 = new TreeMap<>();
        treeMap2.put(2,"abc");
        treeMap2.put(1,"abc");
        treeMap2.put(5,"bcd");
        treeMap2.put(4,"cde");
        treeMap2.put(3,"def");
        for(Map.Entry<Integer, String> entry : treeMap2.entrySet()){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]" );
            /**
             [key:1, value:abc]
             [key:2, value:abc]
             [key:3, value:def]
             [key:4, value:cde]
             [key:5, value:bcd]
             */
        }
        /**
         从结果上来看，TreeMap集合的元素是有序的
         */
    }
    public static void test2(){
        Map<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 正序
                // return o1 - o2;

                // 倒序
                return o2 - o1;
            }
        });
        treeMap.put(2,"abc");
        treeMap.put(1,"abc");
        treeMap.put(5,"bcd");
        treeMap.put(4,"cde");
        treeMap.put(3,"def");
        for(Map.Entry<Integer, String> entry : treeMap.entrySet()){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]" );
            /**
             * [key:5, value:bcd]
             * [key:4, value:cde]
             * [key:3, value:def]
             * [key:2, value:abc]
             * [key:1, value:abc]
             */
        }
    }
    public static void test3(){
//        Map<User, String> treeMap = new TreeMap<>();
        /**
         此时如果自定义类型 User 没有实现 Comparable 接口，那么在插入数据的时候就会报错:
         (Exception in thread "main" java.lang.ClassCastException:
         other_collections.TreeMapTest$User cannot be cast to java.lang.Comparable)

         有两种解决办法
         ① 实例化 TreeMap 时传入一个 Compartor
         ② User implement Comparable
         */
        Map<User, String> treeMap = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge() - o1.getAge();
//                return o1.getAge() - o2.getAge();

            }
        });

        treeMap.put(new User("ZS", 22),"abc");
        treeMap.put(new User("LS", 19),"abc");
        treeMap.put(new User("WW", 24),"bcd");
        treeMap.put(new User("ZL", 32),"cde");
        treeMap.put(new User("GQ", 17),"def");

        for(Map.Entry<User, String> entry : treeMap.entrySet()){
            System.out.println("[key:" + entry.getKey() + ", value:" + entry.getValue() + "]" );
            /**
             正序：
             [key:User{name='GQ', age=17}, value:def]
             [key:User{name='LS', age=19}, value:abc]
             [key:User{name='ZS', age=22}, value:abc]
             [key:User{name='WW', age=24}, value:bcd]
             [key:User{name='ZL', age=32}, value:cde]

             倒序：
             [key:User{name='ZL', age=32}, value:cde]
             [key:User{name='WW', age=24}, value:bcd]
             [key:User{name='ZS', age=22}, value:abc]
             [key:User{name='LS', age=19}, value:abc]
             [key:User{name='GQ', age=17}, value:def]
             */
        }

    }
    public static void main(String[] args) {
        /**
         TreeMap 的基本使用：
         TreeMap 空参构造，如果插入元素 key 的类型实现了 Comparable 接口，就默认使用它的比较器
         */
//        test1();
        /**
         使用自定义比较器来排序
         */
//        test2();

        /**
         当元素的 key 为自定义类型时的排序情况
         */
//        test3();
    }


//    static class User implements Comparable<User>{
    static class User {
        private String name;
        private int age;
        public User() {
        }
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public int getAge() {
            return age;
        }
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        /*
        @Override
        public int compareTo(User o) {
            // 按年龄正序排列
//            return this.getAge() - o.getAge();
            // 按年龄倒序排列
            return o.getAge() - this.getAge();
        }
        */
    }


}
