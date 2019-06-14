package com.itheima.MyInterface;

import java.lang.reflect.Method;

/*
* 拦截器，对方法进行增强
* */
public interface MyInterceptor {

    /**
     * 拦截器，在real对象调用方法之前执行
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法对象
     * @param args 参数
     * @return
     */
     boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * 环绕方法
     * @param proxy
     * @param target
     * @param method
     * @param args
     */
     void around(Object proxy,Object target, Method method, Object[] args);

    /**
     * 后置方法
     * @param proxy
     * @param target
     * @param method
     * @param args
     */
     void after(Object proxy,Object target, Method method, Object[] args);

}
