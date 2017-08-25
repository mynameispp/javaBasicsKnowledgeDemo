package com.ffzxnet.testjava.design_pattern.observer;

import java.util.*;

/**
 * 被观察者
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class UserInfo extends java.util.Observable {
    private String name;
    private int age;

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //通知观察者，数据变换了
        setChanged();
        notifyObservers(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        //通知观察者，数据变换了
        setChanged();
        notifyObservers(age);
    }
}
