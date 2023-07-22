package annotation;

import java.lang.annotation.*;

/**
 * 列举一些 Java 中常用的内置注解
 */

/* @Target 的使用

   被 @Target 修饰的注解可以指定作用在特定的类结构中，
   可以特定指定一种结构，也可以同时指定多种结构

   具体是那种结构，由 @Target 内部方法 value() 的返回值 ElementType[] 来决定
   ElementType 是一个枚举类，它内部有多个枚举项，分别表示注解能支持的多种结构 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
/* @Retention 的使用
   被 @Retention 修饰的注解可以指定该注解的作用范围

   具体是那种范围，由 @Retention 内部方法 value() 的返回值 RetentionPolicy 来决定
   RetentionPolicy 是一个枚举类，它内部有多个枚举项，分别表示注解能作用到的具体范围(默认范围是：RetentionPolicy.CLASS)*/
@Retention(RetentionPolicy.RUNTIME)

/* @Document 的使用
   被 @Document 修饰的注解能出现在 JavaDoc 中 */
@Documented
/* @Inherited 的使用
   被 @Inherited 修饰的注解能被子类继承 */
@Inherited
/* @Deprecated 的使用
   @Deprecated 可以修饰很多中结构；比如被，方法被他修饰过后，该方法就会被标记为过时的，不建议再使用*/
@Deprecated
/* @SuppressWarnings 的使用
   @SuppressWarnings 可以修饰很多中结构；它的作用是来抑制警告, 可以指定多种特特定类型的警告*/
@SuppressWarnings({"deprecation"})
public @interface CommonAnnotation {
}
