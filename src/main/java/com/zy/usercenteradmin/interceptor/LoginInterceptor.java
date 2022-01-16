package com.zy.usercenteradmin.interceptor;

import cn.hutool.core.util.StrUtil;
import com.zy.usercenteradmin.annotations.NotNeedLogin;
import com.zy.usercenteradmin.common.BaseException;
import com.zy.usercenteradmin.common.Constants;
import com.zy.usercenteradmin.entity.User;
import com.zy.usercenteradmin.enums.ResultCodeEnum;
import com.zy.usercenteradmin.util.UserInfoHelper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler != null) {
            return true;
        }
        if (handler.getClass().getAnnotation(NotNeedLogin.class) != null) {
            return true;
        }
        String tokenHeader = request.getHeader(Constants.TOKEN_HEADER);
        if (StrUtil.isBlank(tokenHeader)) {
            throw new BaseException(ResultCodeEnum.LOGIN_EXPIRATION);
        }
        String userId = stringRedisTemplate.opsForValue().get(Constants.REDIS_KEY_TICKET_PREFIX + tokenHeader);
        if (StrUtil.isBlank(userId)) {
            throw new BaseException(ResultCodeEnum.LOGIN_EXPIRATION);
        }
        User user = (User) redisTemplate.opsForValue().get(Constants.REDIS_KEY_USER_PREFIX + userId);
        if (user == null) {
            throw new BaseException(ResultCodeEnum.LOGIN_EXPIRATION);
        }
        UserInfoHelper.add(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        UserInfoHelper.remove();
    }

}
