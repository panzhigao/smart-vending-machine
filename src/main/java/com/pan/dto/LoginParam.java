package com.pan.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by panzhigao on 2022/5/10.
 */
@Data
@Accessors(chain = true)
@ApiModel(value="登陆对象")
public class LoginParam {
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码",required = true)
    private String password;

}
