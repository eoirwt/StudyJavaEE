package generic_supper_array;

/**
 * 通过该案例学习 泛型
 *
 */
public class SuperArrayTest {
    public static void main(String[] args) {
//        SupperArray<Student> supperArray = new SupperArray<Student>();  // jdk1.7之前 的写法
        SuperArray<Student> supperArray = new SuperArray<>();
        supperArray.addToTail(new Student("ZS", 18));
        supperArray.addToTail(new Student("LS", 19));
        supperArray.addToTail(new Student("WW", 20));
        supperArray.addToTail(new Student("ZL", 21));
        // supperArray.addToTail("abc");
        // 编译错误（java: 不兼容的类型: java.lang.String无法转换为genericSupperArray.Student）
        for (int s = 0; s < supperArray.getSize(); s++) {
            Student student = (Student) supperArray.seek(s);
            student.play();
        }


    }
}
