package com.qiandaibaobao.test;

/**
 * Created by chris.zhang on 16-7-5.
 */
public class Visibility {
    int sharedVariable;

    int getSharedVariable() {
        return this.sharedVariable;
    }

    void increaseOne() {
        this.sharedVariable += 1;
    }

    public static void main(String[] args){
        int a = 2;
        a = 3;
        a = 4;
        System.out.println("a = " + a);
    }

}
