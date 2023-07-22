package customException;

/**
 * 自定义一个 密码错误 异常
 */
public class PasswordErrorException extends RuntimeException{
    //错误码
    private Integer errorCode;

    public PasswordErrorException() {}

    public PasswordErrorException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode(){
        return this.errorCode;
    }
}
