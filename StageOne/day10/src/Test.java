import java.security.NoSuchAlgorithmException;

public class Test {

    public static void main(String[] args) throws NoSuchAlgorithmException, CloneNotSupportedException {
        Teacher t1 = new Teacher(12,"lucy",23);
        Student student = new Student("zhangsan");
        t1.setStudent(student);

        Teacher clone = (Teacher)t1.clone();
        clone.getStudent().setName("wangwu");

        System.out.println(clone.getStudent().getName());
        System.out.println(t1.getStudent().getName());

    }

}
