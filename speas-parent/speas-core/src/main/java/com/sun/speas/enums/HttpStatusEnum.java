package com.sun.speas.enums;

/**
 * http状态码 枚举
 * @author sunxiang
 * @date 2020-11-18 10:36
 **/
public enum HttpStatusEnum {
    AUTHOS_DENIED(10000, "权限不足"),
    TOKEN_INVIALID(10005, "token失效"),
    RUNTIME_EXCEPTION(20002, "运行时异常"),
    SYSTEM_EXCEPTION(99999, "系统异常");


    HttpStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 描述字段
     */
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
