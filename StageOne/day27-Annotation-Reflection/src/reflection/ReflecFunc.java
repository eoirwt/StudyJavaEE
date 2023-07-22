package reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射操作方法
 * 通过 类对象 获取方法并对方法进行一些操作
 */
public class ReflecFunc {
    Class<Dog> clazz = null;
    @Before
    public void before(){
        clazz = Dog.class;
    }
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取非私有的方法, 包括一些从父类继承来的方法
        // Method[] methods = clazz.getMethods();

        // 获取所属类自己所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            // System.out.println(method.getName());
            /* getMethods():
            getName
            setName
            getAge
            setAge
            eat
            wait
            wait
            wait
            equals
            toString
            hashCode
            getClass
            notify
            notifyAll
            */

            /* getDeclaredMethods():
            getName
            setName
            eat
            eat
            setAge
            getAge
             */
        }

        // 获取指定方法
        Method eat1 = clazz.getDeclaredMethod("eat"); // NoSuchMethodException
        /*
        当方法有多个形参时，相应的获取方法时，
        不仅需要传入方法名，
        还要依次传入形参类型的 类对象
         */
        Method eat2 = clazz.getDeclaredMethod("eat", String.class);

        // 调用方法
        Dog dog = new Dog(); // 目标对象
        // 无法直接调用私有的方法，需要先获取权限
        eat1.setAccessible(true);
        eat1.invoke(dog); // InvocationTargetException
        /* 当调用方法有形参时，调用时需要传入形参
        invoke(Object obj, Object...args)
        参数说明
        obj: 目标对象
        arg: 传入的形参
         */
        eat2.invoke(dog, "meat");
    }
}
