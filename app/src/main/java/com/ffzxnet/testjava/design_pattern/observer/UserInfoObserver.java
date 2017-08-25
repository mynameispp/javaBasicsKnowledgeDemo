package com.ffzxnet.testjava.design_pattern.observer;

import android.util.Log;

import java.util.*;
import java.util.Observable;

/**
 * 观察用户数据改变的观察者
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class UserInfoObserver implements java.util.Observer {

    @Override
    public void update(Observable o, Object arg) {
        //数据监听，arg=数据，o=被观察的类
        System.out.print("UserInfoObserver====" + arg + "===" + o + "\n");
    }
}
