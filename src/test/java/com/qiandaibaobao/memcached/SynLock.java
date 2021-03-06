package com.qiandaibaobao.memcached;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chris.zhang on 16-7-8.
 */
public class SynLock {
    //锁监视器，初始化为0
    private AtomicInteger monitor = new AtomicInteger();

    /**
     * 加锁，如果成功，锁监视器+1，如果失败，自旋
     */
    void lock() {
        for (; ; ) {
            if (checkLock()) {
                break;
            }
        }
    }

    /**
     * @return true 获得锁成功 false 获得锁失败
     */
    boolean checkLock() {
        return monitor.get() == 0 && monitor.incrementAndGet() == 1;
    }

    /**
     * 解锁 设置锁监视器为0
     */
    void unlock() {
        monitor.set(0);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        SynLock lock = new SynLock();
        System.out.println(System.currentTimeMillis());//方法开始时间
        Runnable r = () -> {
            lock.lock();//加锁
            System.out.println(Thread.currentThread().getName() + "-开始-" + System.currentTimeMillis());
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-结束-" + System.currentTimeMillis());
            lock.unlock();//解锁
        };
        for (int i = 0; i < 20; i++) {
            Thread th = new Thread(r);
            th.setName("线程" + String.valueOf(i));
            th.start();
        }

    }
}
