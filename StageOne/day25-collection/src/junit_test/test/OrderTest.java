package junit_test.test;

import junit_test.Order;
import org.junit.Test;

/**
 * Order类的测试类
 */
//public class Test {
public class OrderTest {
    Order order = new Order();

    @Test
//    @org.junit.Test
    public void test1(){
        order.func1();
    }
    @Test
    public void test2(){
        order.func2();
    }
}
