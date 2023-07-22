package reflection;

import org.junit.Before;
import org.junit.Test;

/**
 * 反射类的基本使用
 * 列举了一些对类对象操作的方法，其他更多方法要查阅 API 文档
 */
public class ReflecClass {
    Class<Dog> clazz = null;
    @Before
    public void before(){
        clazz = Dog.class;
    }
    @Test
    public void test(){
        // 获取类名
        String clazzName = clazz.getName();
        // 获取类加载器
        ClassLoader classLoader = clazz.getClassLoader();
        // 获取父类
        Class<? super Dog> superclass = clazz.getSuperclass();
        // 判断类是否是接口
        boolean anInterface = clazz.isInterface();
        // 判断类是否是数组
        boolean array = clazz.isArray();
        // 通过类的 Class 对象的实例方法实例化一个对象
        try {
            Dog dog = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
