package com.zy.usercenteradmin.技术默写.纯默写;

final class 访问修饰符 {
    private static class 父类 {

        protected String name;

        public 父类() {

        }
    }

    private static class 子类 extends 父类 {
        public 子类() {
            super.name = "1";
        }
    }
}
