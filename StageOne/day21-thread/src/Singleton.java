/**
 * 解决 单例设计模式 的 懒汉模式 的 "线程不安全" 问题
 */
public class Singleton {
    /**
     valatile 解决了 instance 的可见性
     也解决了 由于指令重排 而产出半实例化对象的问题
     */
    private static volatile Singleton instance;

    private Singleton(){}

    public Singleton getInstance(){
        /**
         双重检查 instance
         第 1 次检查是为了增强性能，使得线程不会造成多余的等待，直接获取结果;
         第 2 次检查是为了线程安全，确保只生成一次实例对象
         */
        if( instance == null ){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
