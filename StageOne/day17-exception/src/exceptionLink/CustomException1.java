package exceptionLink;

/**
 *
 */
public class CustomException1 extends RuntimeException{
    //错误码
    private Integer errorCode;

    public CustomException1() {}

    public CustomException1(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode(){
        return this.errorCode;
    }
}
