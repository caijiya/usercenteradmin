package com.zy.usercenteradmin.service;

import com.zy.usercenteradmin.dto.LoginDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
public interface LoginService {
    void captcha(HttpServletResponse response);

    String login(LoginDTO loginDTO, String randomId);

    void logout(String token);
}
