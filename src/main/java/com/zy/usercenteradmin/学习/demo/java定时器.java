package com.zy.usercenteradmin.学习.demo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class java定时器 {


    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        timer.schedule(task, 1000);
        timer.schedule(task1, 5000);
    }
}
