/**
 * ClassName: User
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/3 14:23
 * @Version 1.0
 */
public class User {
    static {
        System.out.println("I am a static code  block!");
    }

    {
        System.out.println("I am a instance code block!");
    }
    public User() {
        System.out.println("I am a constructor!");
    }
    public static void main(String[] args) {
        new User();
        new User();
    }
}
