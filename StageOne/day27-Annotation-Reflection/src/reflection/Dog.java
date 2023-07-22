package reflection;

import annotation.MyAnnotation;

/**
 * 测试类
 */
@MyAnnotation(2)
@MyAnnotation1("Class Annotation")
public class Dog {
    private String name;
    @MyAnnotation(name = "diedan", age = 1, value = 2)
    @MyAnnotation1("Field Annotation")
    private int age;
    public int sex;

    public Dog() {
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Dog(String name, int age, int sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    private void eat(){
        System.out.println("dog eat some food");
    }
    @MyAnnotation(name = "lucy", age = 4, value = 1)
    @MyAnnotation1("Method Annotation")
    public void eat(String foodName){
        System.out.println("dog eat " + foodName);
    }
}
