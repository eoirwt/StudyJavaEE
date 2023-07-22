package annotation;

import annotation.MyAnnotation;

import java.lang.annotation.ElementType;

/**
 如何使用自定义注解
 */
/*
使用注解时，需要通过固定格式，给方法指定返回值
 */
@MyAnnotation(name = "XiaoMing", value = 6)
public class MyAnnotationTest {
    public static void main(String[] args) {
    }
}
