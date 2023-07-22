/**
 * 用枚举实现单例设计模式
 */
public class EnumSingleton {
    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return SingletonHolder.INSTANCE.getInstance();
    }
    private enum SingletonHolder {
        INSTANCE;
        private final EnumSingleton instance;
        private SingletonHolder(){
            instance = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return this.instance;
        }
    }

    public static void main(String[] args) {
        /*
        用枚举实现单例有什么优点?
        其实这也是一种 懒汉式，只要不调用 EnumSingleton.getInstance(),
        就不会加载它内部的枚举类，也就不会实例化内部的枚举项，
        只有调用了方法才会加载。

        性能不错，也比较安全
        */
        System.out.println(EnumSingleton.getInstance() == EnumSingleton.getInstance());
    }
}
