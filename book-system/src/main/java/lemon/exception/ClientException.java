package lemon.exception;

/**
 * @ClassName ClientException
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:11
 * @Version 2020.1
 **/
public class ClientException extends BaseException {
    public ClientException(String code, String message) {
        super("CLI"+code, "客户端错误: "+message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI"+code, "客户端错误: "+message, cause);
    }
}

