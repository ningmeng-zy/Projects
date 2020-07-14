package lemon.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:09
 * @Version 2020.1
 **/

@Getter
@Setter
public class BaseException extends RuntimeException {
    protected String code;
    public BaseException(String code,String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
