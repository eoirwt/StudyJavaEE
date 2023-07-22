package enum_switch_statcimport;

// 全部导入
import enum_introduce.SeasonEnum;
import enum_introduce.SeasonSingleton;

// 静态导入
/*
import static enum_introduce.SeasonEnum.SPRING;
import static enum_introduce.SeasonEnum.SUMMER;
import static enum_introduce.SeasonEnum.AUTUMN;
import static enum_introduce.SeasonEnum.WINTER;
*/
import static enum_introduce.SeasonEnum.*;

// 还可以静态导入 普通类的 静态成员
import static enum_introduce.SeasonSingleton.getSeason;

/**
 * Enum的静态导入，Switch语句中的Enum
 */
public class Test {
    public static void seasonChange(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case SPRING:
                System.out.println("spring is coming");
                break;
            case SUMMER:
                System.out.println("summer is coming");
                break;
            case AUTUMN:
                System.out.println("autumn is coming");
                break;
            case WINTER:
                System.out.println("winter is coming");
                break;
            default:
                System.out.println("unknown season");
        }
    }

    public static void main(String[] args) {
        seasonChange(SPRING);
        seasonChange(SUMMER);
        seasonChange(AUTUMN);
        seasonChange(WINTER);

        SeasonSingleton spring = getSeason(1);
    }
}
