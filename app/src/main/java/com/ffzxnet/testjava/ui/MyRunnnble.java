package com.ffzxnet.testjava.ui;

import android.os.Handler;

/**
 * 创建者： feifan.pi 在 2017/8/22.
 */

public class MyRunnnble implements Runnable {
    private Handler myHandle;

    public MyRunnnble(Handler handler) {
        this.myHandle = handler;
    }

    @Override
    public void run() {
        System.out.print("已售完\n");
        //myHandle.obtainMessage避免重复使用new Message()浪费资源
        myHandle.sendMessage(myHandle.obtainMessage(0, "已售完\n"));
    }
}
