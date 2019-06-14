责任链模式:就是将一个对象的代理对象（增强对象）作为另一个类的真实类对象。

        Hello proxy = (Hello) InterceptorProxy.bind(real,
                "com.itheima.MyInterface.MyInterceptorImpl");

        Hello proxy2 = (Hello) InterceptorProxy.bind(proxy,
                "com.itheima.MyInterface.MyInterceptorImpl2");

        Hello proxy3 = (Hello) InterceptorProxy.bind(proxy2,
                "com.itheima.MyInterface.MyInterceptorImpl3");

        proxy3.sayHello();


        解析一下:就是 代理对象proxy3调用sayHello方法，
        反射3
        反射2
        反射1
        hello
        反射1
        反射2
        反射3
        ============================================================================
        if(instance.before(proxy,target,method,args)){
                        result = method.invoke(target,args);
                   } else{
                       instance.around(proxy,target,method,args);
                   }

                   instance.after(proxy,target,method,args);
        ============================================================================
        proxy3调用sayHello方法，就会去调用InvactionHandler的invoke方法，就是执行上面的代码，
        首先就会执行MyInterceptorImpl3的before方法，判断该方法的返回值时候为true。如果是true,
        就执行 method.invoke(target,args);(ps:这里的target是形参，而proxy2是实参)。proxy2
        就会调用invoke方法，就会执行MyInterceptorImpl2的before方法，如果为false，就会调用around
        方法，就会调用afterr方法，proxy2的invoke方法执行完，就会回到proxy3的invoke方法。继续调用
        MyInterceptorImpl3的after方法。


