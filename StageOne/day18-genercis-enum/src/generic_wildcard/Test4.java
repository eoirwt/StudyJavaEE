package generic_wildcard;

import homework1.Super;
import homework1.superArray.SuperArray;

/**
 * 类型通配符: 下界
 */
public class Test4 {
    /*
    当泛型的类型参数为: ? super Xxx 时，此时能接收类型为 Xxx 或 它的超类
     */
    public static void print(Super<? super Dog> super1){}

    public static void main(String[] args) {
        SuperArray<Animal> animalSuperArray = new SuperArray<>();
        SuperArray<Dog> dogSuperArray = new SuperArray<>();
        SuperArray<Teddy> teddySuperArray = new SuperArray<>();
        Test4.print(animalSuperArray);
        Test4.print(dogSuperArray);

        // Test4.print(teddySuperArray);
        // 编译报错-> 不兼容的类型: SuperArray<Teddy>无法转换为Super<? super Dog>
    }
}
