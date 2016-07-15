package com.qiandaibaobao.test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chris.zhang on 16-7-13.
 */
public class FourThreadTest {
    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(3);

        Runnable r1 = ()->{
            System.out.println("线程1");
            try {
                Thread.currentThread().join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        };

        Runnable r2 = ()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2");
        };
        Runnable r3 = ()->{
            try {
                Thread.currentThread().join(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3");
            latch.countDown();
        };
        Runnable r4 = ()->{
            System.out.println("线程4");
            latch.countDown();
        };
        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r2);
        Thread th3 = new Thread(r3);
        Thread th4 = new Thread(r4);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th4.getId();


    }
}
