package exceptionLink;

/**
 *
 */
public class CustomException2 extends RuntimeException{
    //错误码
    private Integer errorCode;

    public CustomException2() {}

    public CustomException2(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException2(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode(){
        return this.errorCode;
    }
}
