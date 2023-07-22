/**
 * ClassName: Chinese
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/12 9:57
 * @Version 1.0
 */
public class Chinese {
    //实例变量
    String name;
    int age;
    //类变量
    static String nation;//国籍

    public Chinese() {
    }

    public Chinese(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }
}
