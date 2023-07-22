import generic_supper_array.Student;
/**
 * 学习 泛型方法
 */
public class GenericFuncTest {
    // 这是一个泛型方法, 在被调用时才明确类型
    public <T> T func(T t){
        System.out.println("inner, t: " + t);
        return t;
    }

    /*
    泛型方法 再没有指定参数的情况下， 泛型就是 Object类型，相当于:
    public Object func1(){return} */
    public <T> T func1(){
        // 虽然向上转型是自动提升的，但这里还是要强转
        return (T)new Student();
    }
    /*
    可以有多种泛型，下面方法虽然指定了参数，但参数与返回的泛型无关, 所以 T 还是相当于 Object */
    public <T,V> T func2(V v){
        System.out.println(v);
        return (T)new Student();
    }
    public static void main(String[] args) {
        GenericFuncTest genericFuncTest = new GenericFuncTest();

        String abc = genericFuncTest.func("abc");
        System.out.println(abc);

        Object o = genericFuncTest.func1();

        Object o1 = genericFuncTest.func2("abc");
    }
}
