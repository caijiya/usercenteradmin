package com.zy.usercenteradmin.study.代理.动态代理;

import cn.hutool.core.util.StrUtil;

public class CustomizeStrUtil {
    public boolean isBlank(String content) {
        System.out.println("运行了啊");
        return StrUtil.isBlank(content);
    }
}
