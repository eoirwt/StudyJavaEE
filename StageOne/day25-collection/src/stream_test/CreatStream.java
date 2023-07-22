package stream_test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建流的几种方式
 */
public class CreatStream {
    public static void main(String[] args) {
        /** 方式①：通过 java.util.Collection.stream()/parallelStream() 创建流
         注意:
            1. stream() 创建的是 “串行流”
            2. parallelStream() 创建的是 ”并行流“
            3. Map 无法使用这些方法转化成流，它没有继承 Collection !
         */
        ArrayList<String> arrayList = new ArrayList<>();
        Stream<String> stream = arrayList.stream();
        Stream<String> parallelStream = arrayList.parallelStream();

        /** 方式②：通过 java.util.Arrays.stream(T[] array) 创建流
        注意：基础类型数组与引用类型数组有些区别！
            1. 基础类型数组转化成流有专门对应的类型，比如 int -> IntStream
            2. 引用类型的数组化成流的类型为 Stream<T>, 比如 User -> Stream<User>
         */
        int[] intArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);

        String[] strArray = {"a","b","c","d"};
        Stream<String> strStream1 = Arrays.stream(strArray);


        /** 方式③：通过 Stream 类的静态方法转化成流
         1. java.util.stream.Stream<T>.of()
         2. java.util.stream.Stream<T>.concat()
         3. java.util.stream.Stream<T>.iterate() ???
         4. java.util.stream.Stream<T>.generate() ???
         */
        Stream<? extends Serializable> t = Stream.of(1, "2", true, 't');
        Stream<String> strStream2 = Stream.of("1", "2", "3", "4");
        // 合并流
        Stream<String> concat = Stream.concat(strStream1, strStream2);


        /** 方式④：通过 Random 实例方法转化成流 */
        // 100 个随机数流
        IntStream intStream1 = new Random().ints(100);

    }
}
