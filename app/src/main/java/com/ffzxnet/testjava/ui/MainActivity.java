package com.ffzxnet.testjava.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ffzxnet.testjava.R;
import com.ffzxnet.testjava.algorithm.quick_sort.QuickSort;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static TextView textView;
    private MyHandle myHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试handle的内存泄漏
        textView = (TextView) findViewById(R.id.testView);
        myHandle = new MyHandle(this);
        MyRunnnble myRunnnble = new MyRunnnble(myHandle);
        //延迟10秒执行线程
        myHandle.postDelayed(myRunnnble, 10 * 1000);
        //快速排序算法
        setTes();
    }

    private void setTes() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        //快速排序算法
        QuickSort.getInstance().quick(a);
        List<Integer> old=new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i]+",");
            old.add(a[i]);
        }
        List<Integer> quchongfu=new ArrayList<>();
        //集合去重
        HashSet<Integer> set=new HashSet<>(old);
        quchongfu.addAll(set);
        //集合排序
        Collections.sort(quchongfu);
        Log.e("aaaa", stringBuilder.toString());
        Log.e("aaaa", old.toString());
        Log.e("aaaa", quchongfu.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //activity销毁是断开myHandle的通信占有，避免oom
        myHandle.removeCallbacksAndMessages(null);
        myHandle = null;
    }

    static class MyHandle extends Handler {
        //弱应用
        WeakReference<Activity> activityWeakReference;

        public MyHandle(Activity activity) {
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //防止内存泄漏
            if (null != activityWeakReference.get()) {
                textView.setText(msg.obj.toString());
            }
        }
    }

}
