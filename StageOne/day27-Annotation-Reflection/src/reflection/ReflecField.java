package reflection;

import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;

/**
 * 反射操成员变量
 * 通过 类对象 对 成员变量 进行一些操作
 */
public class ReflecField {
    Class<Dog> clazz = null;
    @Before
    public void before(){
        clazz = Dog.class;
    }
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        // 获取类的 public 成员变量, private 成员变法无法获取
        Field[] fields = clazz.getFields();
        // 获取类的所有成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        // 获取类的指定成员变量
        Field name = clazz.getDeclaredField("name"); // NoSuchFieldException
        Dog dog = new Dog(); // 目标对象
        /* 访问成员变量，需要传入目标对象
           set：设置值；
           get：获取值，
           注意：无法直接访问私有的成员变量，需要先开通权限，再访问，否者会 "IllegalAccessException" */
        name.setAccessible(true); // 获取权限
        name.set(dog,"dog");
        String nameStr = (String)name.get(dog);
        System.out.println(nameStr); // dog
    }
}
