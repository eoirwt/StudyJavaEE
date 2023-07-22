package generic_wildcard;

import generic_extend.Comparator;
import generic_supper_array.Student;

/**
 * 当方法参数是一个带参数类型的泛型的时候，对应的一些情况
 */
public class Test1 {
    /*
    print方法 的参数类型是一个带类型参数的泛型
     */
    public static void print(Comparator<Object> comparator){}

    public static void main(String[] args) {
        // 实例化一个 实现 Comparator 泛型接口的匿名内部类 , 并明确泛型为 Student 类型
        Comparator<Student> studentComparator = new Comparator<Student>(){
            @Override
            public Integer compare(Student t1, Student t2) {
                return null;
            }
        };

        // Test1.print(studentComparator);
        /*
        方法报错:
        不兼容的类型: Comparator<Student>无法转换为Comparator<Object>

        原因:
        虽然 Student类型是继承Object类型的, 但整体上 Comparator<Object>类型 与 Comparator<Student>类型并无关系

        总结:
        当方法参数需要传入一个指定泛型的类型时, 类型上可以体现多态, 但是泛型指定了什么类型就必须是什么类型

        疑问:
        有没有什么办法能让指定的泛型更灵活, 让它的不是具体类型, 而是一个区间?

        答案:
        泛型通配符
        */
    }
}
