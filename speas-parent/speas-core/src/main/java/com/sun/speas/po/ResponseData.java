package com.sun.speas.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.speas.enums.HttpStatus;

import java.io.Serializable;

/**
 * http 返回结果
 * @author sunxiang
 * @date 2020-11-18 11:07
 **/
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 4921465205835519272L;

    /**
     * 返回结果
     */
    private boolean success;
    /**
     * 结果码
     */
    private int code;
    /**
     * 结果信息
     */
    private String message;
    /**
     * 返回的结果对象
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 构造器方法
     * @param <T>
     */
    public static class Builder<T> {
        private boolean success;
        private int code;
        private String message;
        private T data;

        public Builder<T> setSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public Builder<T> setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public ResponseData<T> builder() {
            return new ResponseData<>(this);
        }
    }

    public ResponseData(Builder<T> builder) {
        this.success = builder.success;
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    /**
     * 通用响应
     * @param success
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> buildResponseData(boolean success,int code,String message,T data){
        return new Builder<T>()
                .setSuccess(success)
                .setCode(code)
                .setMessage(message)
                .withData(data)
                .builder();
    }

    /**
     * 成功不带结果响应
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> buildSuccessResponseDataNoWithData(String message){
        return new Builder<T>()
                .setSuccess(Boolean.TRUE)
                .setMessage(message)
                .builder();
    }

    /**
     * 成功带结果响应
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> buildSuccessResponseDataWithData(String message,T data){
        return new Builder<T>()
                .setSuccess(Boolean.TRUE)
                .setMessage(message)
                .withData(data)
                .builder();
    }

    /**
     * 失败响应
     * @param message
     * @param code
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> buildFaildResponseData(String message,int code){
        return new Builder<T>()
                .setSuccess(Boolean.FALSE)
                .setMessage(message)
                .setCode(code)
                .builder();
    }

    /**
     * 枚举失败响应
     * @param httpstatus
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> buildFaildResponseData(HttpStatus httpstatus){
        return new Builder<T>()
                .setSuccess(Boolean.FALSE)
                .setMessage(httpstatus.getMessage())
                .setCode(httpstatus.getCode())
                .builder();
    }
}
