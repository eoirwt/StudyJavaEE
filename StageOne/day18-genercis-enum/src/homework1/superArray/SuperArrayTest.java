package homework1.superArray;

import generic_extend.User;
import generic_supper_array.Student;

/**
 * 通过该案例学习 泛型
 *
 */
public class SuperArrayTest {
    public static void main(String[] args) {
        SuperArray<Student> studentSupperArray = new SuperArray<>();
        studentSupperArray.addToTail(new Student("LS", 19));
        studentSupperArray.addToTail(new Student("ZS", 18));
        studentSupperArray.addToTail(new Student("WW", 20));
        studentSupperArray.delete(1);
        studentSupperArray.modification(0, new Student("ZL", 39));
        studentSupperArray.seek(1);

        SuperArray<User> userSupperArray = new SuperArray<>();
        userSupperArray.addToTail(new User("ZS", 19, 45));
        userSupperArray.addToTail(new User("LS", 19, 45));
        userSupperArray.addToTail(new User("ZL", 39, 105));
        userSupperArray.delete(0);
        userSupperArray.modification(0,new User("WW", 29, 75));
        userSupperArray.seek(0);


    }
}
