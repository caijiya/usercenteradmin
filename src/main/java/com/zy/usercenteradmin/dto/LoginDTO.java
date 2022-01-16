package com.zy.usercenteradmin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Data
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码不能为空")
    private String captchaCode;
}
