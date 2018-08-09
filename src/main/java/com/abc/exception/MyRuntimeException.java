package com.abc.exception;

import com.abc.enums.CodeEnum;
import lombok.Data;

/**
 * Created by liujinwen on 2018-08-02
 */
@Data
public class MyRuntimeException extends RuntimeException {
    private Integer code;
    private String msg;

    MyRuntimeException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    MyRuntimeException(Integer code, String msg, Throwable e) {
        super(e);
        this.code = code;
        this.msg = msg;
    }

    public static MyRuntimeException unknowError(Throwable e) {
        return new MyRuntimeException(CodeEnum.UNKNOW_ERROR.getCode(), CodeEnum.UNKNOW_ERROR.getMsg(), e);
    }

    public static MyRuntimeException methodError(Throwable e) {
        return new MyRuntimeException(CodeEnum.METHOD_ERROR.getCode(), CodeEnum.METHOD_ERROR.getMsg(), e);
    }

    public static MyRuntimeException error(Integer code, String msg) {
        return new MyRuntimeException(code, msg);
    }
}
