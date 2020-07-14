package lemon.exception;

/**
 * @ClassName SystemException
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:13
 * @Version 2020.1
 **/
public class SystemException extends BaseException {
    public SystemException(String code, String message) {
        super("SYS"+code, "系统异常： "+message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYS"+code, "系统异常： "+message, cause);
    }
}
