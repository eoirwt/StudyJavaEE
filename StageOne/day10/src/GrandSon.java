public class GrandSon extends Son {


    public GrandSon() {
    }

    public void play(){
        System.out.println("-----------------------------");
        this.eat();
        System.out.println(super.name + " is playing!");
    }

    // 注释   注解
    @Override
    public void eat(){
        System.out.println("grandson is eating!");
    }
}
