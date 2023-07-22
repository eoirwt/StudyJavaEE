/**
 * 使用 getter and setter
 */
public class Girl {
    public int age;
    private String name;
    public Girl(){

    }


    // setter和getter
    public void setAge(int age){

        if(age > 18){
            this.age = 18;
        }
    }

    public int getAge(){
        if(this.age > 18){
            return 18;
        }
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
