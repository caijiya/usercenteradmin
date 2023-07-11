
package com.zy.usercenteradmin.技术默写.纯默写;


import java.util.Base64;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印 {
    public static void main(String[] args) {

        byte[] by = Base64.getDecoder().decode("ZWxrY2xvdWQudG9w");
        java.lang.String s = new java.lang.String(by);
        System.out.println(s);
        int[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"a", "b", "c", "d", "e"};
        ReentrantLock lock = new ReentrantLock();
        Condition intCondition = lock.newCondition();
        Condition strCondition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                for (int i : intArr) {
                    System.out.println(i);
                    strCondition.signal();
                    try {
                        intCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                strCondition.signal();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                for (String i : strArr) {
                    System.out.println(i);
                    intCondition.signal();
                    try {
                        strCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                intCondition.signal();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}