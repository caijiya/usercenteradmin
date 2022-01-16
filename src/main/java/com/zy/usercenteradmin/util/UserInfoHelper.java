package com.zy.usercenteradmin.util;

import com.zy.usercenteradmin.entity.User;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
public class UserInfoHelper {
    private static ThreadLocal<User> userInfo = new ThreadLocal<>();

    private UserInfoHelper() {

    }

    public static void add(User user) {
        userInfo.set(user);
    }

    public static void remove() {
        userInfo.remove();
    }

    public static User get() {
        return userInfo.get();
    }
}
