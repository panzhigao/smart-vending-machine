package com.pan.controller;

import com.pan.common.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by panzhigao on 2022/5/10.
 */
@RestController
public class TestController {


    @GetMapping("hello")
    public Response<String> hello(){
        return Response.success("hello","项目启动成功");
    }

}
