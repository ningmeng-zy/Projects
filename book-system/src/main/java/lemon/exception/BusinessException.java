package lemon.exception;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:13
 * @Version 2020.1
 **/
public class BusinessException extends BaseException {
    public BusinessException(String code, String message) {
        super("BUS"+code, "业务异常: "+message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("BUS"+code, "业务异常:  "+message, cause);
    }
}
