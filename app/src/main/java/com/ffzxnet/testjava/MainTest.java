package com.ffzxnet.testjava;


import com.ffzxnet.testjava.algorithm.tree.Solution;
import com.ffzxnet.testjava.algorithm.tree.TreeNode;
import com.ffzxnet.testjava.design_pattern.bridge.BMW;
import com.ffzxnet.testjava.design_pattern.bridge.Benz;
import com.ffzxnet.testjava.design_pattern.bridge.CarBrandBridge;
import com.ffzxnet.testjava.design_pattern.bridge.MPVCar;
import com.ffzxnet.testjava.design_pattern.bridge.SUVCar;
import com.ffzxnet.testjava.design_pattern.observer.UserInfoObserver;
import com.ffzxnet.testjava.design_pattern.observer.UserInfo;
import com.ffzxnet.testjava.polymorphic.Anima;
import com.ffzxnet.testjava.polymorphic.Dog;

import java.util.List;

import javax.xml.transform.Source;

/**
 * 创建者： feifan.pi 在 2017/8/21.
 */

public class MainTest {
    public static void main(String[] args) {
//        //多线程保证数据安全性
//        MyRunnnble myRunnnble = new MyRunnnble();
//        Thread mythread1 = new Thread(myRunnnble);
//        Thread mythread2 = new Thread(myRunnnble);
//        Thread mythread3 = new Thread(myRunnnble);
//        Thread mythread4 = new Thread(myRunnnble);
//        Thread mythread5 = new Thread(myRunnnble);
//        mythread1.setName("S1");
//        mythread2.setName("S2");
//        mythread3.setName("S3");
//        mythread4.setName("S4");
//        mythread5.setName("S5");
//
//        mythread1.start();
//        mythread2.start();
//        mythread3.start();
//        mythread4.start();
//        mythread5.start();
//
//        //多态
//        Anima anima=new Anima();
//        Dog dog=new Dog();
//        Anima anima1=new Dog();
//        anima.jiao();
//        dog.jiao();
//        anima1.jiao();
//
//        //观察者模式
//        UserInfo userInfo=new UserInfo("忘了",10);
//        //添加观察者
//        userInfo.addObserver(new UserInfoObserver());
//        userInfo.setName("王二");
//        userInfo.setAge(13);
//
//        //桥连接模式
//        CarBrandBridge carBrandBridge=new SUVCar(new BMW());
//        CarBrandBridge carBrandBridge1=new MPVCar(new Benz());
//        carBrandBridge.car();
//        carBrandBridge1.car();

        //二叉树前序遍历
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        //           1
        //      2         3
        //   4                5
        //按照上面的顺序设置数据
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;
        List<Integer> integers=new Solution().preorderTraversal(treeNode1);
        for (Integer integer : integers) {
            System.out.print("=="+integer);
        }
    }

    public static class MyRunnnble implements Runnable {
        int tick = 10;
        String oldThredName = "";

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (tick > 0 && !oldThredName.equals(Thread.currentThread().getName())) {
                        try {
                            tick--;
                            oldThredName = Thread.currentThread().getName();
                            System.out.print(oldThredName + "购买了一张票\n");
                            System.out.print("剩余" + tick + "张票\n");
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (tick == 0) {
                        System.out.print("已售完\n");
                        break;
                    }
                }
            }
        }
    }


}
