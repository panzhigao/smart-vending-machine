package com.pan.config;

import cn.hutool.core.exceptions.ValidateException;
import com.pan.common.Response;
import com.pan.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by panzhigao on 2022/5/11.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})    //申明捕获那个异常类
    public Response<String> exception(Exception e) {
        log.error(e.getMessage(), e);
        return Response.fail();
    }

    @ExceptionHandler({ValidateException.class})    //申明捕获那个异常类
    public Response<String> validateException(Exception e) {
        log.error("参数有误:{}", e.getMessage());
        return Response.fail(ResultCode.CLIENT_FAILURE,e.getMessage());
    }
}
