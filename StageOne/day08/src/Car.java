// 全限定名称  com.ydlclass.entity.Car
public class Car {
    String type;
    String color;
    long length;

    // 构造器
    public Car(){
        // this当做构造器只能放在第一行
        this("benchi","blue",4545);
    }

    public Car(String type, String color, long length){
        this.type = type;
        this.color = color;
        this.length = length;
        System.out.println("我被构造了！");
    }
    public void run(){
        this.addGasoline();
        System.out.println("汽车启动啦！");
    }
    public void addGasoline(){
        System.out.println("加油啦！");
    }

    public static void main(String[] args) {
        

    }


}
