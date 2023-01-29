package com.zy.usercenteradmin.学习.代理.动态代理;

import java.lang.reflect.Proxy;

public class JdkProxy {

    public static Object getObjProxy(Object calculator) {
        return Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{Calculator.class}, (proxy, method, args) -> {
            System.out.println("before");
            return method.invoke(calculator, args);
        });
    }

    public static void main(String[] args) {
        Object objProxy = JdkProxy.getObjProxy(new CalculatorImpl());
        Calculator calculator = (Calculator) objProxy;
        System.out.println(calculator.add(1, 2));
        System.out.println("after");

    }
}
