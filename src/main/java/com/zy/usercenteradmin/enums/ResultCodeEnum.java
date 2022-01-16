package com.zy.usercenteradmin.enums;

import lombok.Getter;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */

@Getter
public enum ResultCodeEnum {
    SUCCESS(true, 0, "成功"),
    UNKNOWN_ERROR(false, 10001, "未知错误"),
    PARAM_ERROR(false, 10002, "参数错误"),
    USERNAME_PASSWORD_ERROR(false, 10003, "用户名或密码错误"),
    CAPTCHA_ERROR(false, 10004, "验证码错误"),
    LOGIN_EXPIRATION(false, 10005, "登录过期"),
    NULL_POINTER_EXCEPTION(false, 10006, "空指针异常");

    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
