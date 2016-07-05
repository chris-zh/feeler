package com.qiandaibaobao.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chris.zhang on 16-7-5.
 */
public class Singleton {

    private static Singleton fuck;
    static Lock lock = new ReentrantLock();

    private Singleton() {
        System.out.println("新构造了一个对象:" + this.hashCode() + " by 线程" + Thread.currentThread().getName());
        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Singleton的双重检测锁实现
     *
     * @return
     */
    public static Singleton getFuck() {
        if (fuck == null) {
            synchronized (Singleton.class) {
                if (fuck == null) {
                    fuck = new Singleton();
                }
            }
        }
        return fuck;
    }

    /**
     * Singleton的双重检测的显示锁实现
     *
     * @return
     */
    public static Singleton getInstance() {
        if (fuck == null) {
            lock.lock();
            try {
                if (fuck == null) {
                    fuck = new Singleton();
                }
            } finally {
                lock.unlock();
            }
        }
        return fuck;
    }

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("任务对象: " + Singleton.getInstance().hashCode());

        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(r);
            th.setName(String.valueOf(i));
            th.start();
        }

//        Singleton2 s3 =  Singleton2.INSTANCE;
//        Singleton2 s4 =  Singleton2.INSTANCE;
//        System.out.println("s3 = " + s3.hashCode());
//        System.out.println("s4 = " + s4.hashCode());

    }
}
