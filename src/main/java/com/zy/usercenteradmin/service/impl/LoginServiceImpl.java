package com.zy.usercenteradmin.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.usercenteradmin.common.BaseException;
import com.zy.usercenteradmin.common.Constants;
import com.zy.usercenteradmin.dto.LoginDTO;
import com.zy.usercenteradmin.dto.UserPermissionDTO;
import com.zy.usercenteradmin.entity.Role;
import com.zy.usercenteradmin.entity.User;
import com.zy.usercenteradmin.enums.ResultCodeEnum;
import com.zy.usercenteradmin.repository.DeptMapper;
import com.zy.usercenteradmin.repository.RoleMapper;
import com.zy.usercenteradmin.repository.UserMapper;
import com.zy.usercenteradmin.service.LoginService;
import com.zy.usercenteradmin.service.MenuService;
import com.zy.usercenteradmin.util.UserInfoHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    RedisTemplate<String, String> stringRedisTemplate;
    @Resource
    RedisTemplate<String, Object> redisTemplate;
    @Resource
    UserMapper userMapper;
    @Resource
    DeptMapper deptMapper;
    @Resource
    MenuService menuService;
    @Resource
    RoleMapper roleMapper;

    @Override
    public String login(LoginDTO loginDTO, String captchaKey) {
        String captchaCode = stringRedisTemplate.opsForValue().get(Constants.REDIS_KEY_CAPTCHA + captchaKey);
        if (StrUtil.isBlank(captchaCode) || !loginDTO.getCaptchaCode().equals(captchaCode)) {
            log.warn("?????????????????????");
            throw new BaseException(ResultCodeEnum.CAPTCHA_ERROR);
        }
        String username = loginDTO.getUsername();
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if (user == null) {
            throw new BaseException(ResultCodeEnum.USERNAME_PASSWORD_ERROR);
        }
        String salt = user.getSalt();
        if (!DigestUtil.md5Hex(salt + loginDTO.getPassword()).equals(user.getPassword())) {
            throw new BaseException(ResultCodeEnum.USERNAME_PASSWORD_ERROR);
        }
        //???????????????????????????????????????redis todo ????????????????????????
        String ticket = UUID.randomUUID().toString();
        //??????token???id?????????
        redisTemplate.opsForValue().set(Constants.TOKEN_PREFIX + ticket, user.getId(), 30, TimeUnit.MINUTES);
        //??????????????????
        redisTemplate.opsForValue().set(Constants.REDIS_KEY_USER_PREFIX + user.getId(), user, 30, TimeUnit.MINUTES);
        return ticket;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(Constants.TOKEN_PREFIX + token);
    }

    @Override
    public UserPermissionDTO userInfo() {
        UserPermissionDTO userPermissionDTO = new UserPermissionDTO();
        User user = UserInfoHelper.get();
        userPermissionDTO.setUser(user);
        Integer deptId = user.getDeptId();
        if (deptId != null) {
            userPermissionDTO.setDept(deptMapper.selectById(deptId));
        }
        userPermissionDTO.setMenus(menuService.menuTree());
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>().inSql("id", String.format("select role_id from role_user_rel where user_id = %s", user.getId()));
        List<Role> roles = roleMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(roles)) {
            userPermissionDTO.setRoleList(roles);
        }
        return userPermissionDTO;
    }

    @Override
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        // ???????????? 4 ????????????
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        // ???????????????????????????
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(130, 40);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            // ??????????????? setGenerator() ?????????????????????????????????
            lineCaptcha.setGenerator(randomGenerator);
            // ???????????????
            lineCaptcha.write(response.getOutputStream());
            // ????????????
            String code = lineCaptcha.getCode();
            log.info("??????????????????:{}", code);
            String captchaKey = UUID.randomUUID().toString();
            // redis???????????????
            stringRedisTemplate.opsForValue().set(Constants.REDIS_KEY_CAPTCHA + captchaKey, code, 30, TimeUnit.MINUTES);
            Cookie cookie = new Cookie("captchaKey", captchaKey);
            cookie.setMaxAge(-1);
            cookie.setHttpOnly(Boolean.TRUE);
            response.addCookie(cookie);
            // ?????????
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
