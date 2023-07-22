package junit_test;

import org.junit.Test;

/**
 * JUnit 单元测试的基本使用
 */
public class JunitBasic {
    @Test
    public void test1(){
        System.out.println("test");
    }
    @Test
    public void test2(){
        System.out.println("expretion:");
        int i = 1/0;
    }
}
