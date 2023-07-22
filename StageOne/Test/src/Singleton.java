/**
 * ClassName: Singleton
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/5 10:58
 * @Version 1.0
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton() {}
    public static Singleton getInstance(){
        if(Singleton.singleton == null){
            singleton = new Singleton();
        }
        return Singleton.singleton;
    }
}
