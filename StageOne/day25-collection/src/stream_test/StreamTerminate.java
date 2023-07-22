package stream_test;

import org.junit.Before;
import org.junit.Test;
import stream_test.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 终止操作
 */
public class StreamTerminate {
    List<Person> personList = new ArrayList<Person>();
    List<Integer> simpleList = Arrays.asList(15, 22, 9, 11, 33, 52, 14);

    @Before
    public void initDate(){
        personList.add(new Person("张三",3000,23,"男","太原"));
        personList.add(new Person("李四",7000,34,"男","西安"));
        personList.add(new Person("王五",5200,22,"女","太原"));
        personList.add(new Person("小黑",1500,33,"女","上海"));
        personList.add(new Person("狗子",8000,44,"女","北京"));
        personList.add(new Person("铁蛋",6200,36,"女","南京"));
    }

/** (1) 遍历/匹配(forEach/find/match) */
    @Test
    // forEach(): 遍历数据流并消费数据
    public void forEachTest(){
//        personList.stream().forEach( p -> System.out.println(p));
//        personList.stream().forEach( System.out::println);
        // 进一步简写
        personList.forEach(System.out::println);
        /*
        Person{name='张三', salary=3000, age=23, sex='男', area='太原'}
        Person{name='李四', salary=7000, age=34, sex='男', area='西安'}
        Person{name='王五', salary=5200, age=22, sex='女', area='太原'}
        Person{name='小黑', salary=1500, age=33, sex='女', area='上海'}
        Person{name='狗子', salary=8000, age=44, sex='女', area='北京'}
        Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}
         */
    }
    @Test
    // findFirst() / findAny() : 寻找数据流中的某一个
    public void findTest(){
        /** 单线程下 */
        // findFirst(): 查早数据流的第一个
        Optional<Integer> first = simpleList.stream().findFirst();
        first.ifPresent(System.out::println); // 15
        // findAny(): 查找数据流的任意一个
        Optional<Integer> any = simpleList.stream().findAny();
        any.ifPresent(System.out::println); // 15

        /** 多线程下, 多个线程会把数据流结成多段，然后并行找任意一个*/
        Optional<Integer> anyP = simpleList.parallelStream().findAny();
        anyP.ifPresent(System.out::println); // 随机不确定

    }
    @Test
    // allMatch() / anyMatch(): 遍历集合并匹配断言
    public void matchTest(){
        // 是不是 "所有人" 的工资都大于 5000
        boolean flag = personList.stream().allMatch(t -> t.getSalary() > 5000);
        System.out.println(flag); // false
        // 是不是 ”有人“ 的工资都大于 5000
        boolean anyFlag = personList.stream().anyMatch(t -> t.getSalary() > 5000);
        System.out.println(anyFlag); // true
    }

/** (2) 统计(count/average/sum/max/min） */
    @Test
    // count(): 遍历数据流并统计元素 ”总数量“
    public void countTest(){
        long count = personList.stream().count();
        System.out.println(count); // 6
    }
    @Test
    /**
     average()/sum()/max()/min(),它们的具体作用都不同，但它们有共性，如下：
     1. 它们都是 IntStream 实例方法，IntStream 实例都可以直接调用，
        也就说明了它们可以操作的流的类型都是能直接计算的，所以还有其他可计算的类型的流，比如 LongStream ...,
        这又进一步说明了其他引用类型的流 (Stream<? extends Object>) 都不能用它们直接计算操作
     2. 当其他类型的流无法调用这些方法时，可以把其他类型的流转化为 IntStream 后就能使用
     */
    /*
    average(): 遍历数据流并通过每一个元素计算 ”平均值“
    注意！average() 要求的数据流类型是可计算的，比如 IntStream
     */
    public void averageTest(){
        /*
        simpleList 是 Stream<Integer> 类型的
        需要先通过 mapToInt() 转成 IntStream 类型，
        才能通过 average() 计算平均值
         */
        IntStream intStream = simpleList.stream().mapToInt(v -> v);
        OptionalDouble average = intStream.average();
        average.ifPresent(System.out::println); // 22.285714285714285
    }
    @Test
    /*
    sum(): 遍历数据流并累计有所元素的 ”总值“
     */
    public void sumTest(){
        IntStream intStream = simpleList.stream().mapToInt(v -> v);
        int sum = intStream.sum();
        System.out.println(sum); // 156

        // 通过 IntStream.of() 可以创建 IntStream 实例
        IntStream intStream1 = IntStream.of(2, 22, 333, 56, 66);
        int sum1 = intStream1.sum();
        System.out.println(sum1); // 479
    }
    @Test
    // max(): 遍历数据流并计算所元素的 ”最大值“
    public void maxTest(){
        IntStream intStream = simpleList.stream().mapToInt(v -> v);
        OptionalInt max = intStream.max();
        max.ifPresent( System.out::println); // 52

        // new Random().ints() 可以创建 IntStream 实例
        IntStream ints = new Random().ints(10);
        OptionalInt max1 = ints.max();
        max1.ifPresent( System.out::println);
    }
    @Test
    // min(): 遍历数据流并计算所元素的 ”最小值“
    public void minTest(){
        IntStream intStream = simpleList.stream().mapToInt(v -> v);
        OptionalInt min = intStream.min();
        min.ifPresent( System.out::println); // 9
    }
    @Test
    /*
    如何使用 average()/sum()/max()/min() 统计 引用类型的流呢？
    这里以 Stream<Person> 用 max() 计算员工最高工资为例：
     */
    public void maxSalary(){
        /** 引用类型流再使用 max() 时，传入一个 Comparator，才能比较 */

        //原始写法
        // Optional<Person> maxSalary = personList.stream().max((p1, p2) -> p1.getSalary() - p2.getSalary());

        /**
         comparingInt(): Comparator内部专门用来比较 int 值的静态方法，它返回的也是一个 Comparator 实例。
         它和原始写法的作用效果一样，但它的内部原理复杂，而且被更加推荐...
         */
        // Optional<Person> maxSalary = personList.stream().max(Comparator.comparingInt(p -> p.getSalary()));
        // 还可以进一步简写 ↓
        Optional<Person> maxSalary = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        maxSalary.ifPresent(
            p -> {
                System.out.println("最大工资是: " + p);
                // 最大工资是: Person{name='狗子', salary=8000, age=44, sex='女', area='北京'}
            }
        );
    }

/** (3) 归约(reduce) */
    @Test
    public void reduceTest(){
        // reduce(): 遍历数据流，每次遍历都会执行计算操作并保留结果，最总整合成一个结果
        IntStream intStream = IntStream.of(2, 1, 3, 4);
        // 计算乘积
        /** 参数说明：
         identity: 初始结果
         n1: 每次遍历的计算结果
         n2: 每次遍历的元素

         遍历过程大致如下：
         identity    n1    n2
         1           2     2  第1次(遍历)↓
         2     1  第2次↓
         6     3  第3次↓
         24    4  第4次 → over，结果 24
         */
        int reduce1 = intStream.reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduce1); // 24
        // 计算和 (原理和计算乘积一样)
        /*
        发现问题：
        尝试：
        int reduce2 = intStream.reduce(0, (n1, n2) -> n1 + n2);
        抛出异常：
        java.lang.IllegalStateException: stream has already been operated upon or closed
        说明：
        同一个流不能做多次 reduce() 操作
         */
        int reduce2 = IntStream.of(2, 1, 3, 4).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(reduce2); // 10
    }

/** (4) 接合(joining) */
    @Test
    public void joinTest(){
        List<String> stringList = Arrays.asList("A", "B", "C", "D");
        Stream<String> stringStream = stringList.stream();
        // collect(Collectors.joining()): 将数据流中的元素按指定连接符链接起来,
        String collect2 = stringStream.collect(Collectors.joining("-"));
        System.out.println(collect2); // A-B-C-D

        /*
        // 同样不支持连续的 collect() 操作, 否者报错
        // 链接符可不指定
        String collect1 = stringStream.collect(Collectors.joining());
        System.out.println(collect1); // ABCD
         */
    }

/** （5）分组(partitioningBy/groupingBy) */
    @Test
    public void groupTest(){
        // 把数据流转换成 Map ，根据 Map key 来进行分组
        // 分区(partitioningBy): 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(p -> p.getSalary() > 5000));
        System.out.println(part);
        /*
        {
            false=[
                Person{name='张三', salary=3000, age=23, sex='男', area='太原'},
                Person{name='小黑', salary=1500, age=33, sex='女', area='上海'}],
            true=[
                Person{name='李四', salary=7000, age=34, sex='男', area='西安'},
                Person{name='王五', salary=5200, age=22, sex='女', area='太原'},
                Person{name='狗子', salary=8000, age=44, sex='女', area='北京'},
                Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}]
        }
         */

        // 分组(groupingBy): 将员工按性别分组
        // Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(p -> p.getSex()));
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(group);
        /*
        {
            女=[
                Person{name='王五', salary=5200, age=22, sex='女', area='太原'},
                Person{name='小黑', salary=1500, age=33, sex='女', area='上海'},
                Person{name='狗子', salary=8000, age=44, sex='女', area='北京'},
                Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}
               ],
            男=[
                Person{name='张三', salary=3000, age=23, sex='男', area='太原'},
                Person{name='李四', salary=7000, age=34, sex='男', area='西安'}
               ]
        }
         */

        // 连续分组：先将员工按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println(group2);
        /*
        {
            女={
                上海=[Person{name='小黑', salary=1500, age=33, sex='女', area='上海'}],
                太原=[Person{name='王五', salary=5200, age=22, sex='女', area='太原'}],
                南京=[Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}],
                北京=[Person{name='狗子', salary=8000, age=44, sex='女', area='北京'}]
               },
            男={
                西安=[Person{name='李四', salary=7000, age=34, sex='男', area='西安'}],
                太原=[Person{name='张三', salary=3000, age=23, sex='男', area='太原'}]
               }
         }
         */
    }

/** (6)归集(toList/toSet/toMap) */
    @Test
    // 把数据流转化成集合，称为归集操作
    public void StreamToCollectionTest(){
        //Stream to List
        List<Integer> list = simpleList.stream().collect(Collectors.toList());
        //Stream to Set
        Set<Integer> set = simpleList.stream().collect(Collectors.toSet());
        //Stream to Map
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p));
    }




}
