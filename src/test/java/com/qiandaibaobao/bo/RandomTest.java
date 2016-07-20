package com.qiandaibaobao.bo;


import java.util.Random;

/**
 * Created by chris.zhang on 16-7-19.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random(47);
        int fuck = r.nextInt(10);
        int shit = r.nextInt(100);
        System.out.println("fuck = " + fuck);
        System.out.println("shit = " + shit);
    }


}
