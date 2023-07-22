/**
 * ClassName: Singleton3
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/5 15:06
 * @Version 1.0
 */
public class Singleton3 {
    private Singleton3() {

    }
    public Singleton3 getInstance(){
        return SingletonHolder.SINGLETON_3;
    }
    private static class SingletonHolder{
        public static final Singleton3 SINGLETON_3 = new Singleton3();

    }
}
