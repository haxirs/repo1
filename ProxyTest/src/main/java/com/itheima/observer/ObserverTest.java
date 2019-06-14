package com.itheima.observer;

public class ObserverTest {
    public static void main(String[] args) {
        MyObserver user1 = new User("张三");
        MyObserver user2 = new User("李四");
        MyObserver user3 = new User("王五");


        WeChatServer weChatServer = new WeChatServer();
        weChatServer.addMyObserver(user1);
        weChatServer.addMyObserver(user2);
        weChatServer.addMyObserver(user3);

        weChatServer.SetMessage("PHP是世界上最好用的语言");
        System.out.println("-------------------------------");
        weChatServer.removeObserver(user2);

        weChatServer.SetMessage("JAVA是世界上最好用的语言");
    }
}
