package com.zy.usercenteradmin.技术默写.纯默写;

public class 重写重载 {

    public class Parent {
        private void method1() {

        }

        Object method2() {
            return null;
        }
    }

    public class Child extends Parent {
        void method1() {
            super.method1();
        }

        @Override
        String method2() {
            return "super.method2();";
        }
    }
}
