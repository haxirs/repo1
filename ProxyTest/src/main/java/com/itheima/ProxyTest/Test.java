package com.itheima.ProxyTest;

import com.itheima.MyCglib.MyCglibProxy;
import com.itheima.MyInterface.InterceptorProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
   /*
   * 可以发现，如果 RealClass 和 Proxy 不是继承同一个接口的话
   * 动态代理是无法实现的。
   *
   * */
    public static void main(String[] args) throws Throwable {
         RealClass real = new RealClass();
        /*DemoTest demoTest = new DemoTest();
        Hello proxy = (Hello) demoTest.bind(real);
        proxy.sayHello();

        proxy.sayHello("你好");*/


        /*
        *
        * 基于子类的动态代理
        *
        * 子类动态代理 就是增强类的方法，就是通过该类的字节码文件，可以创建出继承同一个父类的
        * 代理对象，再通过实现MethodInterceptor接口的intercept方法对真实类调用的方法进行增强。
        *
        * */
       /* Enhancer enhancer = new Enhancer(); // 代表这是一个增强类
        Hello proxy2 = (Hello)Enhancer.create(real.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法前");

                Object invoke = methodProxy.invoke(real, objects);


                System.out.println("方法后");

                return invoke;
            }
        });

        proxy2.sayHello();*/


       /* MyCglibProxy myCglibProxy = new MyCglibProxy();
        RealClass real_proxy = (RealClass) myCglibProxy.getProxy(real.getClass());
        real_proxy.sayHello();
        real_proxy.sayHello("你好");*/

       /*
       * 拦截器
       * */

        /*Hello proxy = (Hello) InterceptorProxy.bind(real,
                "com.itheima.MyInterface.MyInterceptorImpl");

        Hello proxy2 = (Hello) InterceptorProxy.bind(proxy,
                "com.itheima.MyInterface.MyInterceptorImpl2");

        Hello proxy3 = (Hello) InterceptorProxy.bind(proxy2,
                "com.itheima.MyInterface.MyInterceptorImpl3");

        proxy3.sayHello();*/

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.remove("3");



    }



}
