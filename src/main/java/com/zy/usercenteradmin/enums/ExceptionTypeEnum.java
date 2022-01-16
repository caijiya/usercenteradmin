package com.zy.usercenteradmin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Getter
@AllArgsConstructor
public enum ExceptionTypeEnum {
    RUNTIME_EXCEPTION(0, "系统未知错误"),
    USERNAME_PASSWORD_ERROR(10001, "用户名或密码错误"),
    CAPTCHA_ERROR(10002, "验证码错误"),
    LOGIN_EXPIRATION(10003, "登录过期"),
    PARAMETER_VERIFICATION(10004, "参数校验错误");

    private int code;
    private String message;
}
