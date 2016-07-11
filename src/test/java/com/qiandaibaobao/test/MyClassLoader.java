package com.qiandaibaobao.test;

/**
 * Created by chris.zhang on 16-7-11.
 */
public class MyClassLoader  extends ClassLoader{


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //自己的逻辑，找到class，读取，变成字节数组
        byte[] fuck = getClassBytes(name);
        return super.defineClass("com.qiandaibaobao.com.Fuck",fuck, 0, 10);
    }


    private byte[] getClassBytes(String name) {
        return null;
    }
}
