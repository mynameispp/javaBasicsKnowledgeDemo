package com.ffzxnet.testjava.algorithm.quick_sort;

/**
 * 快速排序算法
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class QuickSort {
    private static QuickSort quickSort;

    //单例模式构建
    public static QuickSort getInstance() {
        if (null == quickSort) {
            quickSort = new QuickSort();
        }
        return quickSort;
    }

    public void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }

    //取中间值
    private int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    private void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list 数组进行一分
            _quickSort(list, low, middle - 1);       //对低字表进行递归排
            _quickSort(list, middle + 1, high);       //对高字表进行递归排
        }
    }


}
