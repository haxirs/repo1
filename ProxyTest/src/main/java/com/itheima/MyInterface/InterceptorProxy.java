package com.itheima.MyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorProxy implements InvocationHandler {
    // 真实类
    private Object target;
    private String interceptorClass;

    public InterceptorProxy(Object target, String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }
    /*
    *
    * */
    public static Object bind(Object target, String interceptorClass){
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InterceptorProxy(target, interceptorClass));

        return o;
}

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        /*
        * 在动态代理中添加拦截器，实现对方法的增强
        *
        * */
        // 1.创建拦截器接口的实现类对象
        if(interceptorClass != null){
            // 判断 interceptorClass的全限定名是否为null，如果不为空
            // 表示创建拦截器对象
            MyInterceptor instance = (MyInterceptor) Class.forName(interceptorClass).newInstance();

            // 调用前置方法
           if(instance.before(proxy,target,method,args)){
                result = method.invoke(target,args);
           } else{
               instance.around(proxy,target,method,args);
           }

           instance.after(proxy,target,method,args);

        } else {
            // 如果没有拦截器，就直接增强方法
            result = method.invoke(target, args);
        }
        return result;
    }
}
