package new_peculiarity_on_java8;

import java.util.Optional;
import java.util.Scanner;

/**
 * Optional 类的基本使用
 *
 * 场景：
 */
public class OptionalTest {
    static class User {
        String name;
        int id;
        public User() {
        }
        public User(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        User user;
        if(i == 0){
            user = null;
        }else {
            user = new User("zhangsan", 1);
        }

        /** ① 通过判断 user 来防止 空指针异常(简称 NPE) */
        if(user != null){
            String name = user.name;
        }

        /** ②通过 Optional 包装 user 来防止 NPE */
        // 创建 Optional 对象，应为 user 可能为空，选择使用 ofNullable()
        Optional<OptionalTest.User> optional = Optional.ofNullable(user);

        // optional 可以通过 get() 获取 user, 但如果 user 为 null，则抛出异常 NoSuchElementException
        User user1 = optional.get();

        /*
        optional.isPresent(): 判断被包装对象值是否为空，
        可以用来做 null 的防御性检查来防止 NPE，但这是糟糕的做法!
        这样和方式①没区别，反而还增加了包装操作
        */
        if(optional.isPresent()){
            User user2 = optional.get();
            String name = user2.name;
        }

        /**
        Optional主要是通过 ifPresent()、orElse()、orElseGet()、通过对 null值 的防御性检查来解决 NPE。

        方式1：
         在 isPresent() 内部
         如果 optional 包装的值为 null，则会把值传递给 consumer 的 accept()，
         */
        optional.ifPresent(t -> System.out.println("user is null！"));

        /**
         方式2：
         orElse(): 如果 optional 包装的值为 null，则返回 orElse() 传入的值，否则返回被包装值本身
         */
        User userOrOtherUser1 = optional.orElse(new User("default uesr", 0));

        /**
         方式3：
         orElseGet(): 如果 optional 包装的值为 null，则返回 Supplier 所返回的值，否则返回被包装值本身
         */
        User userOrOtherUser2 = optional.orElseGet(() -> new User("default user", 0));

        /**
         方式4：
         orElseThrow(): 如果 optional 包装的值为 null，则返回 Supplier 所返回的异常并被抛出，否则返回被包装值本身
         */
        User user2 = optional.orElseThrow(() -> new RuntimeException("value is null"));

    }
}
