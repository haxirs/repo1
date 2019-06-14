package com.itheima.observer;

/*
* 实现观察者接口的实现类
* */
public class User implements MyObserver {
    private String name;

    public User(String name){
        this.name = name;
    }
    /*
    * 推送
    * */
    public void update(String message) {
        read(message);
    }

    public void read(String message){

        System.out.println( name + "收到推送消息: " + message);
    }
}
