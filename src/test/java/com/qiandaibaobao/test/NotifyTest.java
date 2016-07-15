package com.qiandaibaobao.test;

import com.sun.deploy.util.ArrayUtil;

/**
 * Created by chris.zhang on 16-7-5.
 */
public class NotifyTest {

    int sharedVariable;//可以保证可见性，但是不能保证原子性


    void testWait() throws InterruptedException {
        synchronized (this) {
            this.wait();
        }
    }

    void testNotify() {
        synchronized (this) {
            this.notify();
//            this.notifyAll();
        }
    }

    public static void main(String[] args){
        NotifyTest t = new NotifyTest();
        Runnable r = ()->{
            Thread my = Thread.currentThread();
            try {
                my.join(1000);
                System.out.println("线程"+my.getName()+"开始等待");
                t.testWait();
                System.out.println("线程"+my.getName()+"等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r3 = ()->{
            Thread my = Thread.currentThread();
            System.out.println("线程"+my.getName()+"开始等待");
            try {
                t.testWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+my.getName()+"等待结束");
        };

        Runnable r2 = ()->{
            Thread my = Thread.currentThread();
            try {
                my.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+my.getName()+"开始通知");
            t.testNotify();
            t.testNotify();
        };


        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r2);
        Thread th3 = new Thread(r3);
        th1.setName("线程1");
        th2.setName("线程2");
        th3.setName("线程3");
        th1.start();
        th2.start();
        th3.start();
    }
}
