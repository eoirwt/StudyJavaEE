package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 如何自定义注解，了解注解的基本格式
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) // 注解也能够被注解修饰
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
     // 注解里可以定义多个方法，格式类似抽象方法
     String name() default "lily";
     int age() default 18; // 可以通过 default 指定方法默认返回值
     /* 如果注解只有一个方法，且方法名为 value, 则在使用注解时就不需要关注方法名，
        比如：MyAnnotation(6) */
     int value();
}
