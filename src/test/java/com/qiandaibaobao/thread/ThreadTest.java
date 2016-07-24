package com.qiandaibaobao.thread;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class ThreadTest {
    public static void main(String[] args){
        ThreadLocal local = new ThreadLocal();
        local.set("fuck");
        local.set("shit");
        System.out.println(local.get());
    }
}
