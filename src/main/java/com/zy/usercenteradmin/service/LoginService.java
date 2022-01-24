package com.zy.usercenteradmin.service;

import com.zy.usercenteradmin.dto.LoginDTO;
import com.zy.usercenteradmin.dto.UserPermissionDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
public interface LoginService {
    void captcha(HttpServletRequest request, HttpServletResponse response);

    String login(LoginDTO loginDTO, String randomId);

    void logout(String token);

    UserPermissionDTO userInfo();
}
