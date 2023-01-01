package com.zy.usercenteradmin.study.代理.动态代理;

public class CalculatorImpl implements Calculator {
    @Override
    public Integer add(int a, int b) {
        return a + b;
    }

    @Override
    public Integer subtraction(int a, int b) {
        return a - b;
    }
}
