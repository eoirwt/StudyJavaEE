package stream_test;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Stream 中间操作
 */
public class StreamMiddle {
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

/** （1）筛选（filter）*/
    @Test
    public void filteTest(){
        // 筛选工资高于 5000 的员工，并形成新的集合
        List<Person> collect = personList.stream()
                /*
                filter 过滤器需要传入一个
                 */
                .filter(p -> p.getSalary() > 5000)
                .collect(Collectors.toList());
        System.out.println(collect);
        /*
        [
            Person{name='李四', salary=7000, age=34, sex='男', area='西安'},
            Person{name='王五', salary=5200, age=22, sex='女', area='太原'},
            Person{name='狗子', salary=8000, age=44, sex='女', area='北京'},
            Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}
        ]
         */
    }

/**（2）映射(map/flatMap) */
    @Test
    public void mapTest(){
        // 获取每个员工的工资，并形成一个集合
        List<Integer> integerList = personList.stream()
                .map(p -> p.getSalary()).
                collect(Collectors.toList());
        System.out.println(integerList); // [3000, 7000, 5200, 1500, 8000, 6200]
        // 给每个员工工资涨 1000
        personList.stream()
                .map(p -> {
                    p.setSalary(p.getSalary() + 1000);
                    return p;
                })
                .forEach(p -> System.out.println(p));
        /*
        Person{name='张三', salary=4000, age=23, sex='男', area='太原'}
        Person{name='李四', salary=8000, age=34, sex='男', area='西安'}
        Person{name='王五', salary=6200, age=22, sex='女', area='太原'}
        Person{name='小黑', salary=2500, age=33, sex='女', area='上海'}
        Person{name='狗子', salary=9000, age=44, sex='女', area='北京'}
        Person{name='铁蛋', salary=7200, age=36, sex='女', area='南京'}
         */
    }

/** （3）排序(sorted) */
    @Test
    public void sortTest(){
        // 按工资升序排序
        personList.stream()
//                .sorted((p1, p2) -> p1.getSalary()-p2.getSalary())
                .sorted(Comparator.comparingInt(Person::getSalary))
//                .forEach(p -> System.out.println(p));
                .forEach(System.out::println);
        /*
        Person{name='小黑', salary=1500, age=33, sex='女', area='上海'}
        Person{name='张三', salary=3000, age=23, sex='男', area='太原'}
        Person{name='王五', salary=5200, age=22, sex='女', area='太原'}
        Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}
        Person{name='李四', salary=7000, age=34, sex='男', area='西安'}
        Person{name='狗子', salary=8000, age=44, sex='女', area='北京'}
         */


    }

/** （4）peek操作 */
    @Test
    public void peekTest(){
        // 1. 操作流的过程中打印查看数据流（数据流无法直接通过debug工具查看）
        List<Person> collect = personList.stream()
                .filter(p -> p.getSalary() > 5000)
                .peek(p -> System.out.println(p))
                /*
                    Person{name='李四', salary=7000, age=34, sex='男', area='西安'}
                    Person{name='王五', salary=5200, age=22, sex='女', area='太原'}
                    Person{name='狗子', salary=8000, age=44, sex='女', area='北京'}
                    Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}
                 */
                .collect(Collectors.toList());
        // 2. 参与操作数据流，修改元素信息
        personList.stream()
                .peek(p -> p.setSalary(p.getSalary() + 1000))
                .forEach(p -> System.out.println(p));
        /*
        Person{name='张三', salary=4000, age=23, sex='男', area='太原'}
        Person{name='李四', salary=8000, age=34, sex='男', area='西安'}
        Person{name='王五', salary=6200, age=22, sex='女', area='太原'}
        Person{name='小黑', salary=2500, age=33, sex='女', area='上海'}
        Person{name='狗子', salary=9000, age=44, sex='女', area='北京'}
        Person{name='铁蛋', salary=7200, age=36, sex='女', area='南京'}
         */
    }

/** (5) limit 限制 */
    @Test
    public void limitTest(){
        personList.stream()
                .sorted((p1, p2) -> p2.getSalary() - p1.getSalary())
                .limit(3)
                .forEach(p -> System.out.println(p));
        /*
        Person{name='狗子', salary=8000, age=44, sex='女', area='北京'}
        Person{name='李四', salary=7000, age=34, sex='男', area='西安'}
        Person{name='铁蛋', salary=6200, age=36, sex='女', area='南京'}
         */
    }

/** (6) distinct 去重 */
    @Test
    public void distinctTest(){
        IntStream.of(1, 1, 2, 2, 3, 3, 4, 4)
                .distinct()
                .forEach(p -> System.out.println(p));
        /*
        1
        2
        3
        4
         */

    }

/** (7) skip 跳过 */
    @Test
    public void skipTest(){
        simpleList.stream().skip(2).forEach(p -> System.out.println(p));
        /*
        9
        11
        33
        52
        14
         */
    }

/** 练习案例： 分别找出男员工、女员工的最高工资*/
    @Test
    public void findMaxSalary(){
        Map<String,Integer> map = new HashMap<>(2);
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        for (Map.Entry<String, List<Person>> entry : collect.entrySet()){
            String key = entry.getKey();
            Integer salary = entry.getValue().stream().mapToInt(Person::getSalary)
                    .max().orElse(0);
            map.put(key,salary);
        }
        System.out.println(map);
    }
}
