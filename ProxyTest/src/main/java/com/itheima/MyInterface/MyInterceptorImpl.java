package com.itheima.MyInterface;

import java.lang.reflect.Method;

public class MyInterceptorImpl implements MyInterceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法逻辑前......");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("取代real方法");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法逻辑后");
    }
}
