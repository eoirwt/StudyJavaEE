package enum_introduce;

/**
 * 定义枚举， 了解枚举的机制，枚举的常用方法，枚举类中添加新的方法
 */

// 字节码中有： public final class enum_introduce.SeasonEnum extends java.lang.Enum<enum_introduce.SeasonEnum>
public enum SeasonEnum {
    /*
    这里定义的是枚举类的 静态常量，并以通过 Enum 类的构造器实例化，具体看字节码

    在定义静态常量时还可以通过后加 “()”, 通过括号里的参数来决定调用枚举类的重载构造器，

    当 "()" 里没有指定参数，或者没有 "()", 那就调用无参构造

    也就是说，它们都可以有自己的实例成员，那么就可以在枚举类中定义实例变量或方法供 静态常量使用
     */
    SPRING,
    SUMMER,
    AUTUMN(),
    WINTER("winter is cold!");

    private String detail; // 添加实例变量

    SeasonEnum(){
        detail = "Nothing!";
    }

    SeasonEnum(String del){
        detail = del;
    }

    public String getDetail(){ // 添加新的实例方法
        return this.detail;
    }

    public static void main(String[] args) {
        //------------------------- 枚举类的常用方法 ---------------------
        // 其中， values() 在 Enum 类里面找不到，说明它是 在编译时由jdk自动生成
        SeasonEnum[] seasons = SeasonEnum.values();
        for (int i = 0; i < seasons.length; i++) {
            String str = "";
            // ordinal()
            str += seasons[i].ordinal() + " | ";
            // name()
            str += seasons[i].name() + " | ";
            // getDeclaringClass()
            str += seasons[i].getDeclaringClass();
            System.out.println(str);
        }
        // valueOf()
        SeasonEnum spring = SeasonEnum.valueOf("SPRING");
        System.out.println("------------------------------------------------");

        // 枚举类不能直接通过构造器实例化
        //  SeasonEnum seasonEnum = new SeasonEnum();

        System.out.println("spring detail: " + SeasonEnum.SPRING.getDetail());
        System.out.println("autumn detail: " + SeasonEnum.AUTUMN.getDetail());
        System.out.println("winter detail: " + SeasonEnum.WINTER.getDetail());
    }
}
