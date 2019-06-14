package com.itheima.ProxyTest;

public class RealClass implements Hello{

    public void sayHello(){
        System.out.println("hello, proxy");
    }

    public void sayHello(String msg){
        System.out.println(msg);
    }
}
