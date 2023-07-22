package thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * 并发修改异常
 */
public class ConcurrentModifyExcTest {
    public static void test1(){
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "tom", "kobe", "jordan", "tracy", "westbook");
        for(String s : arrayList){
            if("jordan".equals(s)){
//                arrayList.remove(s);
                arrayList.add(s);
            }
        }
    }
    public static void test2(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            arrayList.add(new Random().nextInt(100_000_000));
        }
        // 开启多个线程，每个线程都执行迭代器
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                Iterator<Integer> iterator = arrayList.iterator();
                while (iterator.hasNext()){
                    Integer next = iterator.next();
                    if(next > 1_000_000){
                        iterator.remove();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        /**
         情况一：增强 for 循环里遍历集合并修改集合元素，抛出并发修改异常
         */
//        test1();
        /**
         情况而：在多个线程里同时使用迭代器遍历集合并修改集合元素，抛出并发修改异常
         */
//        test2();
    }
}
