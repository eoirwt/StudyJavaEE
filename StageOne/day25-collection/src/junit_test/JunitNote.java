package junit_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 JUnit 注解机制的应用
 */
public class JunitNote {
    @Before
    public void before1(){
        System.out.println("Before");
    }
    @Before
    public void before2(){
        System.out.println("Before");
    }
    @Test
    public void test1(){
        System.out.println("Test");
    }
    @Test
    public void test2(){
        System.out.println("Test");
    }
    @After
    public void after1(){
        System.out.println("After");
    }
    @After
    public void after2(){
        System.out.println("After");
    }
}
