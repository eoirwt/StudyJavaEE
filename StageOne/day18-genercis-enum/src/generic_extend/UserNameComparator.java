package generic_extend;

import generic_supper_array.Student;

/**
 * 列举了 UserNameComparator实现类 实现了 Comparator 泛型接口，并且不明确泛型的类型，等后续创建实例时再确定类型
 *
 * 主要也讲了 StudentComparator类 里那个观点，
 * 实现类它虽然没有明确类型，但它也需要明确泛型，不同的是，它时在实例化的时候才确定类型
 */
public class UserNameComparator<T> implements Comparator<T>{
    @Override
    public Integer compare(T t1, T t2) {
        // T 在编译时的类型是 Object  具体运时的类型在创建实例时的指定的泛型来决定
        return t1.equals(t2)? 1 : 0;
    }

    public static void main(String[] args) {
        // 实例化时明确类型为 User
        UserNameComparator<User> userUserNameComparator = new UserNameComparator<>();
        Integer compare = userUserNameComparator.compare(
                new User("ZS", 19, 45),
                new User("LS", 15, 35)
        );
        System.out.println(compare);// 0

        // 实例化时明确类型为 Student
        UserNameComparator<Student> studentUserNameComparator = new UserNameComparator<>();
        Integer compare1 = studentUserNameComparator.compare(
                new Student("ZS", 19),
                new Student("ZS", 29)
        );
        System.out.println(compare1);// 1
    }
}
