package enum_introduce;

/**
 * 定义一个 单例的季节类
 */
public class SeasonSingleton {
    private int Value;
    private String name;
    private static final SeasonSingleton SPRING;
    private static final SeasonSingleton SUMMER;
    private static final SeasonSingleton AUTUMN;
    private static final SeasonSingleton WINTER;
    static{
        SPRING = new SeasonSingleton(1, "spring");
        SUMMER = new SeasonSingleton(2, "summer");
        AUTUMN = new SeasonSingleton(3, "autumn");
        WINTER = new SeasonSingleton(4,"winter");
    }

    private SeasonSingleton(){}
    private SeasonSingleton(int v, String n){
        this.setName(n);
        this.setValue(v);
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SeasonSingleton getSeason(int v){
        switch (v){
            case 1:
                return SPRING;
            case 2:
                return SUMMER;
            case 3:
                return AUTUMN;
            case 4:
                return WINTER;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(SeasonSingleton.getSeason(4).getName());
    }
}
