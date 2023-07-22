public class Car {

    // 汽车品牌
    String type;
    // 汽车的颜色
    String color;
    // 汽车的长度
    long length;


    // 发动的方法
    public void run(){
        // 跑之前先加油
        this.addGasoline();
        System.out.println("汽车启动啦！");
    }
    // 加油的方法
    public void addGasoline(){
        System.out.println("加油啦！");
    }



    public static void main(String[] args) {
        

    }


}
