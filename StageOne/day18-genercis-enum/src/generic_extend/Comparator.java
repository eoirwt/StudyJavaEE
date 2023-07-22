package generic_extend;

/**
 * 定义一个用 来比较数据 的 泛型接口
 */
public interface Comparator<T> {
//    Integer compare(User u1, User u2); 它被重写后也只能对比两个 User类型的数据, 现在需要它能对比任意类型的数据，怎么做？

//    方式一: 直接修改传入参数类型, 能实现效果, 但会有不确定性
//    Integer compare(Object o1, Object o2);

//    方式二: 通过泛型来解决, 这样就可以灵活使用了。可以传入任意类型的数据，而不在单单是 User
    Integer compare(T t1, T t2);
}
