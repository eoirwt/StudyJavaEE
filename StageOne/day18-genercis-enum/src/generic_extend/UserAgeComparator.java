package generic_extend;

/**
 * 列举了 UserAgeCompatator 实现类 实现了 Comparator 泛型接口, 并且明确了泛型的类型为 User
 *
 * 主要说明了 StudentComparator类 里说明的观点, 主要是当子类明确泛型时的情况
 */
public class UserAgeComparator implements Comparator<User>{
    @Override
    public Integer compare(User t1, User t2) { // 对比 StudentComparator类 的 compare(), 这里明确了泛型，代码方便严谨许多, 也现实出了泛型的作用
        return t1.getAge() - t2.getAge();
    }

    public static void main(String[] args) {
        // UserAgeComparator 在声明时已经明确了泛型为 User, 这里去 new 实例时的泛型永远只能时 User
        UserAgeComparator userAgeComparator = new UserAgeComparator();
        Integer compare = userAgeComparator.compare(new User("ZS", 19, 45), new User("LS", 15, 35));
        System.out.println(compare);

        // 此时我想比较 Student类型对象 的 age 时, 编译会报错“类型不兼容”, 类型早就确定了
//        userAgeComparator.compare(new Student("ZS", 19), new Student("LS", 29));
    }
}
