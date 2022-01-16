package com.zy.usercenteradmin.controller;

import com.zy.usercenteradmin.annotations.NotNeedLogin;
import com.zy.usercenteradmin.dto.LoginDTO;
import com.zy.usercenteradmin.service.LoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("login")
    @NotNeedLogin
    public Map login(@RequestBody @Validated LoginDTO loginDTO, @RequestHeader String captchaKey) {
        return Collections.singletonMap("token", loginService.login(loginDTO, captchaKey));
    }

    @PostMapping("logout")
    public void logout(@RequestHeader String token) {
        loginService.logout(token);
    }

    @NotNeedLogin
    @GetMapping("captcha")
    public void captcha(HttpServletResponse response) {
        loginService.captcha(response);
    }
}
