package com.zy.usercenteradmin.common;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
public class Constants {
    public static final String REDIS_KEY_ONLINE_USERS = "online_users";
    public static final String REDIS_KEY_USER_PREFIX = "userinfo:";
    public static final String REDIS_KEY_CAPTCHA = "captcha:";
    public static final String TOKEN_HEADER = "X-Token";
    public static final String TOKEN_PREFIX = TOKEN_HEADER + ":";
    public static final String DEFAULT_PASSWORD = "123456";
}
