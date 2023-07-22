package chat.util;

import java.util.Scanner;

/**
 * @ClassName: ScannerUtil
 * @Package: chat.util
 * @Description:
 */
public class ScannerUtil {
    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * 该方法能让你在控制台输入内容，并那内容字符串返回出去
     * @return 你在控制台输入的字符内容
     */
    public static String input(){
        return SCANNER.next();
    }
}
