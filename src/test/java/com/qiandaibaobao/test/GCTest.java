package com.qiandaibaobao.test;

/**
 * Created by chris.zhang on 16-8-8.
 */
public class GCTest {
    public static void main(String[] args){
        GCTest t = new GCTest();
        int i = 0;
        for(;;) {
            t = new GCTest();
            i++;
            if (i > 1000000) {
                break;
            }
        }
    }
}
