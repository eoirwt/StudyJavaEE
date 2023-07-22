package reflection;

import annotation.MyAnnotation;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射操作注解
 * 如何通过类对象去获取注解实例并去操作
 */
public class ReflecAnnotation {
    Class<Dog> clazz = null;
    @Before
    public void before(){
        clazz = Dog.class;
    }

    /**
     * 通过 类对象获取 类的注解实例
     */
    @Test
    public void test1() {
        // 获取类上所有的类型的注解实例
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
            /*
            @annotation.MyAnnotation(name=lily, age=18, value=2)
            @reflection.MyAnnotation1(value=Class Annotation)
             */
        }
        // 获取指定类型的注解
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        MyAnnotation1 annotation1 = clazz.getAnnotation(MyAnnotation1.class);
        /*
        注解的实例是由 jvm 构建的，我们可以直接获取，
        就可看作 一个匿名内部类继承了注解(本质上是一个函数式接口)实例化出一个对象，
        那么该对象就能调用被实现的注解里的抽象方法
         */
        String name = annotation.name();
        System.out.println(name); // lily
    }

    /**
     * 通过 类对象获取 属性的注解实例
     */
    @Test
    public void test2() throws NoSuchFieldException {
        // 获取 属性上 所有类型的注解实例
        Field ageField = clazz.getDeclaredField("age");
        Annotation[] annotations2 = ageField.getAnnotations();
        for (Annotation annotation : annotations2){
            System.out.println(annotation);
            /*
            @annotation.MyAnnotation(name=diedan, age=1, value=2)
            @reflection.MyAnnotation1(value=Field Annotation)
             */
        }
        // 获取指定类型注解
        MyAnnotation annotation = ageField.getAnnotation(MyAnnotation.class);
        MyAnnotation1 annotation1 = ageField.getAnnotation(MyAnnotation1.class);
        String value = annotation1.value();
        System.out.println(value); //Field Annotation
    }

    /**
     * 通过 类对象获取 方法的注解实例
     */
    @Test
    public void test3() throws NoSuchMethodException {
        // 获取 方法上 的注解实例
        Method eatMethod = clazz.getDeclaredMethod("eat", String.class);
        Annotation[] annotations = eatMethod.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
            /*
            @annotation.MyAnnotation(name=lucy, age=4, value=1)
            @reflection.MyAnnotation1(value=Method Annotation)
             */
        }
        // 获取指定类型的注解实例
        MyAnnotation annotation = eatMethod.getAnnotation(MyAnnotation.class);

    }
}
