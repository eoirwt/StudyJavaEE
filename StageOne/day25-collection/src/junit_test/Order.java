package junit_test;

/**
 * 这是一个需要通过 JUnit 测试的类
 * 项目中一般这样做：
 * 1. 创建一个名为 test 的包
 * 2. 在 test 包下创建 具体对应的测试类
 * 注意点：
 * 测试类的命名有规范, 比如 Order -> OrderTest
 * 测试类的命名最好避免 ”Test“，否者注解将会编译报错，需要换成全类名的注解
 */
public class Order {
    public void func1(){}
    public void func2(){}
}
