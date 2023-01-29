package com.zy.usercenteradmin.技术默写.纯默写;

public class Outer {
    void outerMethod() {
        final int[] a = {10};
        class Inner {
            void innerMethod() {
                a[0] = 11;
                System.out.println(a[0]);
            }
        }
        new Inner().innerMethod();
    }

    public static void main(String[] args) {
        new Outer().outerMethod();
    }

}
