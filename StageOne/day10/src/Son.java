public class Son extends Father {

    public Son() {
    }

    public void work(){
        super.eat();
        System.out.println("son is working!");;
    }

    @Override
    public void eat(){
        System.out.println("son is eating");
    }

}
