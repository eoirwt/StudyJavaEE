package reflection;

import org.junit.Test;

/**
 获取类对象的几种方式
 */
public class CreatClassObj {
    @Test
    public void test(){
        // 方式一: 通过 类名.class 获取
        Class<Dog> dogClassObj1 = Dog.class;
        // 方式二：通过类实例对象的实例方法 getClass() 获取
        Dog dog = new Dog();
        Class<? extends Dog> dogClassObj2 = dog.getClass();
        // 方式三: 通过 Class.forName("对象的全类名") 获取
        Class<?> dogClassObj3 = null;
        try {
            dogClassObj3 = Class.forName("reflection.Dog");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 测试类的 Class 对象是否唯一
        System.out.println(dogClassObj1 == dogClassObj2); // true
        System.out.println(dogClassObj2 == dogClassObj3); // true
        System.out.println(dogClassObj1 == dogClassObj3); // true
    }
}
