package com.itheima.MyCglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {


    public Object getProxy(Class cls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return o;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用真实对象之前");
        Object invoke = methodProxy.invoke(o, objects);
        System.out.println("调用真实方法之后");

        return invoke;
    }
}
