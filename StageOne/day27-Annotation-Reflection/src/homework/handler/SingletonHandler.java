package homework.handler;

import homework.annotation.Singleton;
import homework.context.ApplicationContext;

import java.util.List;

/**
 反射处理类，将单例实例存储到容器中
 */
public class SingletonHandler {
    /**
     * 通过遍历一个 全限定类名 的集合，每次遍历是通过全限定类名创建 class 对象,
     * 并判断该 class 对象是否能生成 Singleton 注解实例，
     * 如果能，就通过当前 class 对象实例化单例类的对象，
     * 并把这个对象存储到 ApplicationContent.CONTEXT 容器中
     * @param classNames
     *          一个 全限定类名 的集合
     */
    public static void handler(List<String> classNames){
        for (String className : classNames){
            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Singleton annotation = clazz.getAnnotation(Singleton.class);
            if(annotation != null){
                Object instance = null;
                try {
                    instance = clazz.newInstance();
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                ApplicationContext.addSingleton(clazz, instance);
            }
        }
    }
}
