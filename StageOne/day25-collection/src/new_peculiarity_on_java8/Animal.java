package new_peculiarity_on_java8;

/**
 * 接口新增加的默认方法
 */
public interface Animal {
    // 静态常量、变量
    int age = 0; // public static int age = 0
    final String name = ""; // public static final String name = ""
    // 静态方法
    static void shleep(){ // public static void shleep(){

    }
    // 抽象方法
    void eat(); // public void eat()

    // 默认方法
    default void play(){

    }

    class Dog implements Animal { // public static class Dog{
        @Override
        public void eat() {

        }

        @Override
        public void play() {
            Animal.super.play();
        }

    }

    public static void main(String[] args) {
        int age = Animal.age;
        String name = Animal.name;
        Animal.shleep();
        Animal animal = new Dog();
        animal.eat();
        animal.play();
    }
}
