package com.itheima.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
* 被观察的对象
* */
public class WeChatServer {

    private List<MyObserver> list;

    private String message;

    public WeChatServer(){
        list = new ArrayList<MyObserver>();
    }

    /*
    * 添加观察者
    * */

    public void addMyObserver(MyObserver observer){
        this.list.add(observer);
    }

    /*
    * 移除观察者
    * */
    public void removeObserver(MyObserver observer){
        if(list!= null && list.size() > 0){
            list.remove(observer);
        }
    }

    /*

    * */
    public void notifyMessge(){
        for (MyObserver myObserver : list) {
            myObserver.update(message);
        }
    }

    public void SetMessage(String message){
        System.out.println("微信服务端推送：" + message);
        this.message = message;
        notifyMessge();
    }
}
