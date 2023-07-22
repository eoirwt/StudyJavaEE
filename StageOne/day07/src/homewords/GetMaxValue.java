package homewords;

/**
 * @Description: 方法重载练习， 重载两个获取最大值的方法
 */
public class GetMaxValue {
    public int getMaxValue(int a, int b){
        if( a > b) {
            return a;
        }else {
            return b;
        }
    }
    public int getMaxValue(int a, int b, int c){
        if(a > b) {
            if(a > c) {
                return a;
            }else {
                return c;
            }
        }else {
            if (b > c) {
                return b;
            }else {
                return c;
            }
        }
    }
    public static void main(String[] args) {
        GetMaxValue getMaxValue = new GetMaxValue();
        int maxValue = getMaxValue.getMaxValue(33, 24);
        System.out.println(maxValue);
        maxValue = getMaxValue.getMaxValue(48, 1, 987);
        System.out.println(maxValue);

    }

}
