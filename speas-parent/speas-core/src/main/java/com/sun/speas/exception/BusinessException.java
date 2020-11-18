package com.sun.speas.exception;

import com.sun.speas.enums.HttpStatusEnum;

/**
 * 业务异常
 * @author sunxiang
 * @date 2020-11-18 10:35
 **/
public class BusinessException extends RuntimeException {

    /**
     * 通过构造方法来传递 业务异常信息
     * @param httpStatus
     */
    public BusinessException(HttpStatusEnum httpStatus){
        this.code = httpStatus.getCode();
        this.message =httpStatus.getMessage();
    }

    public BusinessException(int code,String message){
        this.code=code;
        this.message=message;
    }

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
