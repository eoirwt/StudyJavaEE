package homework.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 该类用来存储每个单例的实例对象，并开放出 获取 以及 添加 单例实例的公共方法
 */
public class ApplicationContext {
    private static final Map<Class<?>, Object> CONTEXT = new ConcurrentHashMap<>(8); // 存储单例实例的集合

    /**
     * 向集合中添加一个单例实例
     * @param key
     *          单例类的 class 对象
     * @param value
     *          单例类的实例对象
     */
    public static void addSingleton(Class<?> key, Object value){
        CONTEXT.put(key, value);
    }

    /**
     * 从集合中获取单例实例
     * @param key
     *          单例实例所属类的 class 对象
     * @return 返回一个目标单例实例
     */
    public static <T> T getSingleton(Class<T> key){
        return (T)CONTEXT.get(key);
    }
}
