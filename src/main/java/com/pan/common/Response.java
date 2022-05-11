package com.pan.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by panzhigao on 2022/5/10.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    /**
     * code
     */
    private int code;
    /**
     * 数据
     */
    private T data;
    /**
     * 消息结果
     */
    private String msg;

    private Response(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Response(IResultCode resultCode, T data) {
        this(resultCode.getCode(), data, resultCode.getMessage());
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResultCode.SUCCESS, data);
    }

    public static <T> Response<T> success(T data,String msg) {
        return new Response<>(ResultCode.SUCCESS, data,msg);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>(ResultCode.SUCCESS, null,msg);
    }

    public static <T> Response<T> fail() {
        return new Response<>(ResultCode.INTERNAL_SERVER_ERROR, null,ResultCode.INTERNAL_SERVER_ERROR.message);
    }

    public static <T> Response<T> fail(T data) {
        return new Response<>(ResultCode.INTERNAL_SERVER_ERROR, data);
    }

    public static <T> Response<T> fail(T data,String msg) {
        return new Response<>(ResultCode.INTERNAL_SERVER_ERROR, data,msg);
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<>(ResultCode.INTERNAL_SERVER_ERROR,null,msg);
    }

    public static <T> Response<T> fail(ResultCode resultCode,String msg) {
        return new Response<>(resultCode,null,msg);
    }

}
