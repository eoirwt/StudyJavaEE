package performances_contrast;

import org.junit.Test;

import java.util.*;

/**
 * ArrayList 与 LinkedList 的性能对比
 *
 * 分别对元素的增、删、查来对比两种集合的性能
 */
public class ArrayList_VS_LinkedList {
    /**添加数据-尾插
     * 分别对 ArrayList、LinkedList添加一千万条数据
     */
    @Test
    public void testArrayListAdd(){
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            list.add((int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时243毫秒。
         */
    }
    @Test
    public void testLinkedListAdd(){
        List<Integer> list = new LinkedList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时2524毫秒。
         */
    }

    /**添加数据-头插
     * 分别对 ArrayList、LinkedList添加一千万条数据
     */
    @Test
    public void testArrayListAddHeader(){
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            无法算出，太慢!!!
         */
    }
    @Test
    public void testLinkedListAddHeader(){
        List<Integer> list = new LinkedList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时2487毫秒。
         */
    }

    /**查询数据-for循环
     * 分别对 ArrayList、LinkedList使用 for 循环遍历查询它们的元素
     */
    @Test
    public void testArrayListFor(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时2毫秒。
         */
    }
    @Test
    public void testLinkedListFor(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            无法计算时间。

        思考：
            为什么会这么慢？本质还是 LinkedList.get(i) 这个方法太慢，
            终究还是链表的特殊结构造成的！

            虽然源码做了优化，它会判断 i，这个 i 是处于链表的前半段部分，还是后半段部分
            如果是前者，那么就从表头开始找；后者，就从表尾开始找，但还是要一个一个遍历找下去，性能还是很差

            它不像数组，可以通过下标直接找到目标值
         */

    }

    /**查询数据-迭代器
     * 分别对 ArrayList、LinkedList 使用“迭代器”遍历查询它们的元素
     */
    @Test
    public void testArrayListIterator(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
         结果：
         开始------
         用时4毫秒。
         */
    }
    public void testLinkedListIterator(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println("开始------");
        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
        开始------
	    用时42毫秒。

	    思考：
	    LinkedList 在用迭代器遍历时，每次遍历迭代器都会保存指针，通过这个保存的指针来查询数据，
	    不再需要从链表头或尾一个一个查询下去
         */
    }
    /**随机删除
     * 分别对 ArrayList、LinkedList 使用“迭代器”遍历, 并随机删除符合条件的元素
     */
    @Test
    public void testArrayListDel(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*10000000));
        }
        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() > 5000000){
                iterator.remove();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            太慢，时间没出来

        思考：
            当删除数组中的一个元素后，为了保证结构的连续性，肯定要挪动其他元素，这个资源消耗很大！
            但是删除的元素是数组的最后一个元素，ArrayList的性能又会很好
         */
    }
    @Test
    public void testLinkedListDel(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int)(Math.random()*10000000));
        }
        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() > 5000000){
                iterator.remove();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时45毫秒。
         */
    }

    /**自带的排序方法
     * 分别使用 ArrayList、LinkedList 自带的排序方法来排序
     */
    @Test
    public void testArrayListSort(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long start = System.currentTimeMillis();
        // 不用管为啥，这就是排序，复制过来用就行，写个冒泡也行
        list.sort(Comparator.comparingInt(num -> num));
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时49毫秒。
         */
    }

    @Test
    public void testLinkedListSort(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0,(int)(Math.random()*100));
        }
        Long start = System.currentTimeMillis();
        // 不用管为啥，这就是排序，复制过来用就行，写个冒泡也行
        list.sort(Comparator.comparingInt(num -> num));
        Long end = System.currentTimeMillis();
        System.out.printf("用时%d毫秒。",end-start);
        /*
        结果：
            用时53毫秒。
         */
    }


    /** 总结：
     仅仅只是遍历集合，无论是使用 for 循环 还是 迭代器 遍历，优先考虑 ArrayList；
     如果再遍历集合时要对元素进行修改（简称：过滤数据）,优先考虑 LinkedList, 并且要保证使用”迭代器“遍历
     */
}
