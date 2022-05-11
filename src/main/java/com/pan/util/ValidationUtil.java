package com.pan.util;


import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by panzhigao on 2022/5/11.
 */
public class ValidationUtil {

    /**
     * 校验对象
     *
     * @param bean   bean
     * @param groups 校验组
     * @return {@link java.util.Set}
     */
    public static void validate(Object bean, Class<?>... groups) {
        Set<ConstraintViolation<Object>> set = cn.hutool.extra.validation.ValidationUtil.validate(bean, groups);
        String errorMsg = set.stream().map(item -> item.getMessage()).collect(Collectors.joining(","));
        if (StrUtil.isNotBlank(errorMsg)) {
            throw new ValidateException(errorMsg);
        }
    }

}
