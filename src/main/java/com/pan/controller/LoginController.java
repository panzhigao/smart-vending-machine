package com.pan.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.pan.common.Response;
import com.pan.dto.LoginParam;
import com.pan.util.ValidationUtil;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by panzhigao on 2022/5/10.
 */
@Api(value = "/category", tags = "登陆接口")
@RestController
public class LoginController {

    @Value("${signKey:s6xj}")
    private String signKey;

    @Value("${expireDays:7}")
    private Integer expireDays;

    @PostMapping("login")
    @ApiOperation(value = "登陆", notes = "登陆")
    public Response<String> login(@RequestBody LoginParam loginParam){
        ValidationUtil.validate(loginParam);
        Map<String,Object> map=new HashMap<>();
        map.put("username",loginParam.getUsername());
        JwtBuilder jwtBuilder = Jwts.builder();
        String token = jwtBuilder.setSubject(loginParam.getUsername()) //设置用户数据
                .setIssuedAt(new Date()) //设置jwt生成时间
                .setClaims(map)
                .setId(UUID.fastUUID().toString()) //设置id为token id
                .setExpiration(new Date(DateUtil.current()+ DateUnit.DAY.getMillis()*expireDays)) //设置token有效期
                .signWith(SignatureAlgorithm.HS256, signKey) //设置token加密方式和密码
                .compact(); //生成token字符串
        return Response.success(token,"登陆成功");
    }

}
