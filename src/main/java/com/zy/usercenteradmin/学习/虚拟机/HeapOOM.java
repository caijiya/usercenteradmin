package com.zy.usercenteradmin.学习.虚拟机;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class HeapObject {
        final void test() {
//            被final修饰的方法不能被重写
        }

        void test1() {

        }
    }

    static abstract class abstractObject {
        abstract void test();
    }

    static class ChildObject extends HeapObject {
        @Override
        void test1() {
            super.test1();
        }
    }

    public static void main(String[] args) {
        abstractObject abstractObject = new abstractObject() {
            @Override
            void test() {

            }
        };
        List<HeapObject> list = new ArrayList<>();

        while (true) {
            list.add(new HeapObject());
        }
    }
}
