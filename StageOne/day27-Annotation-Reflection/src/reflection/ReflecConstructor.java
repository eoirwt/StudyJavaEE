package reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射操作构造器
 */
public class ReflecConstructor {
    Class<Dog> clazz = null;
    @Before
    public void before(){
        clazz = Dog.class;
    }
    @Test
    public void test() throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        // 获取非私有构造器
//        Constructor<?>[] constructors = clazz.getConstructors();
        // 获取所有构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors){
            System.out.println(constructor);
            /* getConstructors():
            public reflection.Dog(java.lang.String,int)
            public reflection.Dog()
             */

            /* getDeclaredConstructors():
            private reflection.Dog(java.lang.String,int,int)
            public reflection.Dog(java.lang.String,int)
            public reflection.Dog()
             */
        }

        // 获取指定构造器, 构建实例
        // 无参
        Constructor<Dog> constructor1 = clazz.getDeclaredConstructor(); // NoSuchMethodException
        Dog dog1 = constructor1.newInstance();
        // 有参
        Constructor<Dog> constructor2 = clazz.getDeclaredConstructor(String.class, int.class);
        Dog dog2 = constructor2.newInstance("lucy", 3);
        // 私有，有参
        Constructor<Dog> constructor3 = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        /*
        注意：通过类对象获取的私有构造器不能直接构建实例，
        需要先获取权限
         */
        constructor3.setAccessible(true);
        Dog dog3 = constructor3.newInstance("lily", 2, 1);
    }
}
