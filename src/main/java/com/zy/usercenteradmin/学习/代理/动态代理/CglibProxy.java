package com.zy.usercenteradmin.学习.代理.动态代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class CglibProxy {
    private static Object getProxy(Object subject) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CustomizeStrUtil.class);
        enhancer.setCallback((MethodInterceptor) (proxy, method, args, methodProxy) -> {
            System.out.println("before");
            Object result = methodProxy.invoke(subject, args);
            System.out.println("after");
            return result;
        });
        return enhancer.create();
    }

    public static void main(String[] args) {
        Object proxy = CglibProxy.getProxy(new CustomizeStrUtil());
        CustomizeStrUtil customizeStrUtil = (CustomizeStrUtil) proxy;
        System.out.println(customizeStrUtil.isBlank("cglib动态代理"));
    }

}
