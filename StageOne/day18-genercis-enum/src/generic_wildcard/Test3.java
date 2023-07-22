package generic_wildcard;

import homework1.superArray.SuperArray;
import homework1.Super;

/**
 * 类型通配符: 上界
 */
public class Test3 {
    /*
    当泛型的类型参数为: ? extends Xxx 时，此时能接收类型为 Xxx 或 它的子类
     */
    public static void print(Super<? extends Dog> super1){
        for (int i = 0; i < super1.getSize(); i++) {
            super1.seek(i).say();
        }
    }

    public static void main(String[] args) {
        SuperArray<Dog> dogSuperArray = new SuperArray<>();
        dogSuperArray.addToTail(new Dog());
        dogSuperArray.addToTail(new Teddy());
        dogSuperArray.addToTail(new Teddy());

        Test3.print(dogSuperArray);

        SuperArray<Teddy> teddySuperArray = new SuperArray<>();
        Test3.print(teddySuperArray);
//
//        SuperArray<Animal> animalSuperArray = new SuperArray<>();
//        Test3.print(animalSuperArray);
    }
}
