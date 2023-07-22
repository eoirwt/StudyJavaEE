package error;

import error.Dog;

/**
 * 该案例简单展示了 NoClassDefFoundError (找不到class定义的错误)
 */
public class ErrorTest3 {


    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
    }
}
