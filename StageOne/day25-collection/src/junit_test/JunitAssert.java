package junit_test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Junit 断言机制的应用
 */
public class JunitAssert {
    @Test
    public void fun1(){
        int i = 6;
        i++;
//        Assert.assertEquals(6, i);
        Assert.assertEquals(7, i);
    }
}
