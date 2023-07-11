package com.zy.usercenteradmin.技术默写.纯默写;

import sun.awt.Mutex;

import java.util.concurrent.locks.ReentrantLock;

public class 锁 {
    /**
     * synchronized 悲观锁 非公平锁 互斥锁
     * 锁的升级
     * 无锁、匿名偏向锁-》偏向锁-》轻量级锁（自旋锁）-》重量级锁
     *
     * ReentrantLock 乐观锁、可以实现公平锁和非公平锁、互斥锁
     * ReentrantReadWriteLock 有互斥锁和共享锁，读共享，写独锁
     * 乐观锁 cas比较并交换
     */
    private Object obj = new Object();

    /**
     * 锁膨胀
     */
    public void method() {
        for (int i = 0; i < 999; i++) {
            synchronized (obj) {

            }
        }

        synchronized (obj) {
            for (int i = 0; i < 999; i++) {
            }
        }
    }

    /**
     * 锁消除
     */
    public synchronized void pz() {

    }



    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        new Thread(() -> {
            while (true) {
                mutex.lock();
                System.out.println("111");
                mutex.lock();
            }
        }).start();
    }


}
