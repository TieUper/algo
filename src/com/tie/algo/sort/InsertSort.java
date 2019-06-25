package com.tie.algo.sort;

/**
 * ��������
 */
public class InsertSort {

    //a ����  n ����
    public void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for(; j >=0; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j]; //�����ƶ�
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
