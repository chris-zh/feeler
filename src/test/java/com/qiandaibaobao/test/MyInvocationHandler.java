package com.qiandaibaobao.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chris.zhang on 16-8-3.
 */
public class MyInvocationHandler implements InvocationHandler{
    private Object target;
    MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }
}
