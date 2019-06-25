package com.tie.algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {

    //冒泡排序， a表示数组，n标识数组大小
    public static void bubbleSort(int[] a, int n) {
        if(n <= 1) return;

        for(int i = 0; i < n; i++) {
            //提前退出冒泡循环标志位
            boolean flag = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j + 1]){
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    //标识有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                break;  //提前退出
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {6,3,2,5,7,5,1};
        bubbleSort(a, a.length);

        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
