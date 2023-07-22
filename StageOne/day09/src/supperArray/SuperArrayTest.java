package supperArray;

/**
 *
 */
public class SuperArrayTest {
    public static void main(String[] args) {
        SupperArray supperArray = new SupperArray();
        supperArray.add(2);
        supperArray.add(6);
        supperArray.add(10);
        supperArray.add(4);
        supperArray.add(4);
        supperArray.add(22);
        supperArray.add(-1, 1);
        supperArray.add(0, 0);
        supperArray.add(3, 5);
        supperArray.add(7, 9);
        supperArray.add(10, 15);
        supperArray.delete(-1);
        supperArray.delete(9);
        supperArray.delete(0);
        supperArray.delete(7);
        supperArray.modification(-1, 0);
        supperArray.modification(8,1);
        supperArray.modification(3, 16);
        supperArray.seek(-1);
        supperArray.seek(8);
        supperArray.seek(3);
        Integer[] newArray = supperArray.arraySort();
    }
}
