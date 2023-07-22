package customException;

import java.util.Scanner;

/**
 *  配合 PasswordErrorException 和 UserNameErrorException 来完成一个简单的登录功能
 */
public class LoginTest {
    public static void login(String username, String password){
        if(!"guohong".equals(username)) {
            throw new UserNameErrorException("用户名错误", 104);
        }
        if(!"123".equals(password)) {
            throw new PasswordErrorException("密码错误", 204);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String userName = scanner.next();
        System.out.print("请输入密码: ");
        String password = scanner.next();
        boolean isLogin = true;
        try {
            login(userName, password);
        }catch (UserNameErrorException e){
            isLogin = false;
            System.out.println(e.getErrorCode() + ", " + e.getMessage() +"!");
//            e.printStackTrace();
        }catch (PasswordErrorException e){
            isLogin = false;
            System.out.println(e.getErrorCode() + ", "+ e.getMessage() + "!");
//            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(isLogin){
            System.out.println("登录成功!");
        }else {
            System.out.println("登录失败!");
        }
    }
}
