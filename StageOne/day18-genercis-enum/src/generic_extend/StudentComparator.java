package generic_extend;
import generic_supper_array.Student;
/**
 * 列举了 StudentComparator类 实现 Compatator泛型接口, 实现类没有明确泛型的类型
 *
 * 主要说明一个观点：
 * 泛型类(接口)在被继承(实现)时，子类(实现类)可以明确 泛型父类(泛型接口) 的参数类型， 也可以不明确
 */
public class StudentComparator implements Comparator{
    @Override
    public Integer compare(Object t1, Object t2) { // 没有明确类型, T就是Object, 这样传入的值没有被限制，泛型显得无意义
        if(t1 instanceof Student && t2 instanceof Student){
            return ((Student) t1).getAge() - ((Student) t2).getAge();
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        StudentComparator studentComparator = new StudentComparator();
        Integer compare = studentComparator.compare(new Student("ZS", 19), new Student("LS", 29));
        System.out.println(compare);
    }
}
