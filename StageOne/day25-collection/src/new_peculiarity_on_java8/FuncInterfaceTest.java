package new_peculiarity_on_java8;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口的使用
 *
 * 都以Lamdba表达式来实现，
 * 如果不理解它的原理，要翻看 day13 相关内容
 */
public class FuncInterfaceTest {
    /** Consumer接口（消费者）的使用 */
    @Test
    public void consumerTest(){
//        Consumer<String> consumer = t -> System.out.println(t);
        /**说明：
         * 这是一个极简的写法
         * 前提条件：
         * 当方法体内调用某个类的 "静态方法"，并且仅传入箭头函数传入的参数，就能这样写
         * 比如：
         * t -> ClassName.staticFuncName(t)
         * ⬇ 简写成 ⬇
         * ClassName::staticFuncName
         */
        Consumer<String> consumer = System.out::println;
        consumer.accept("abc");
    }

    /** Supplier接口（供应商）的使用 */
    @Test
    public void supplierTest(){
        Supplier<String> supplier = () -> "abc";
        System.out.println(supplier.get());
    }

    /** Predicate接口（断言）的使用 */
    @Test
    public void predicateTest(){
        Predicate<Integer> predicate = t -> t > 5;
        System.out.println(predicate.test((int) Math.ceil(Math.random() * 10)));
    }

    /** Function接口（函数）的使用 */
    @Test
    public void functionTest(){
//        Function<String, Integer> function = t -> Integer.parseInt(t);
        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("123");
        System.out.println(apply);
    }
}
