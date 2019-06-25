package com.tie.algo.sort;

/**
 * 插入排序
 */
public class InsertSort {

    //a 数组  n 长度
    public void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for(; j >=0; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j]; //数据移动
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
