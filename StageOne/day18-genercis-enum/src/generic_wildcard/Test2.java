package generic_wildcard;

import generic_extend.Comparator;
import generic_extend.User;
import generic_supper_array.Student;

/**
 * 类型通配符: 无界
 */
public class Test2 {
    /** 当泛型的类型参数为: ? 时, 此时能接收任意类型 */
    public static void print(Comparator<?> comparator){}

    /**
     上述的效果等同于 不带类型参数的泛型，
     虽然能够实现同样的效果，但是有警告: Raw use of parameterized class 'Comparator' ( 警告 没有类型参数的泛型 )
     */
//    public static void print(Comparator comparator){}

    public static void main(String[] args) {
        Comparator<Student> studentComparator = new Comparator<Student>(){
            @Override
            public Integer compare(Student t1, Student t2) {
                return null;
            }
        };

        Comparator<User> userComparator = new Comparator<User>(){
            @Override
            public Integer compare(User t1, User t2) {
                return null;
            }
        };

        Test2.print(studentComparator);
        Test2.print(userComparator);
    }
}
