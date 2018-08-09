package com.abc.enums;

/**
 * Created by liujinwen on 2018-08-02
 */
public enum CodeEnum {
    UNKNOW_ERROR(999999, "未知系统异常"),
    METHOD_ERROR(999998, "运行方法异常"),
    SUCCESS(1, "成功");

    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CodeEnum get(Integer code) {
        if (code == null) {
            return null;
        }
        for (CodeEnum r : CodeEnum.values()) {
            if (r.equals(code)) {
                return r;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
