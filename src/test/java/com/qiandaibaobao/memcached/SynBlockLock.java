package com.qiandaibaobao.memcached;

/**
 * Created by chris.zhang on 16-7-8.
 */
public class SynBlockLock {
    private String mutex = "fuck me";
    private int monitor;

    public synchronized int getMonitorValue() {
        return monitor;
    }

    public synchronized void increaseOne() {
        this.monitor+=1;
    }

    public synchronized void resetMonitor() {
        this.monitor = 0;
    }

    void lock() {
        synchronized (mutex) {
            for (;;) {
                if (checkLock()) {
                    break;
                }
            }
        }
    }

    boolean checkLock() {
        if (monitor == 0) {
            increaseOne();
            if (monitor == 1) {
                return true;
            }
        }
        return false;
    }

    void unlock() {
        this.resetMonitor();
    }


}
