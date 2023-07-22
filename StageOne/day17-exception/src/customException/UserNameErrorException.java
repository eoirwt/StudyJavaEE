package customException;

/**
 * 自定义一个 用户名错误异常
 */
public class UserNameErrorException extends RuntimeException{
    //错误码
    private Integer errorCode;

    public UserNameErrorException() {}

    public UserNameErrorException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode(){
        return this.errorCode;
    }
}
