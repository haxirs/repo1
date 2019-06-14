package com.itheima.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DemoTest implements InvocationHandler {

    //代表真实对象
    private Object target = null;

    /**
     * 根据真实对象创建代理对象
     * @param target
     * @return proxy 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), this);

        return instance;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("真实方法执行之前");
        Object o = method.invoke(target, args);
        System.out.println("真实方法执行之后");
        return o;
    }
}
