package homework1.superLink;

import generic_extend.User;
import generic_supper_array.Student;
/**
 *
 */
public class SuperLinkTest {
    public static void main(String[] args) {
        SuperLink<Student> studentSuperLink = new SuperLink<>();
        studentSuperLink.addToHead(new Student("aa", 18));
        studentSuperLink.addToHead(new Student("bb", 19));
        studentSuperLink.addToTail(new Student("cc", 20));
        studentSuperLink.add(1, new Student("dd", 21));
        System.out.println(studentSuperLink.linkToString());

        SuperLink<User> userSuperLink = new SuperLink<>();
        userSuperLink.addToHead(new User("ZS", 22, 45));
        userSuperLink.addToHead(new User("LS", 20, 35));
        userSuperLink.addToTail(new User("WW", 24, 55));
        userSuperLink.add(1, new User("ZL", 21, 52));
        System.out.println(userSuperLink.linkToString());

    }
}
