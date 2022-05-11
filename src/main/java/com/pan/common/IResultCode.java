package com.pan.common;

/**
 * Created by panzhigao on 2022/5/10.
 */
public interface IResultCode {
    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();
}
