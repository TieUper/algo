package com.tie.algo.sort;

/**
 * 快速排序
 */
public class QuickSort {

    //快速排序 a是数组 n表示数组大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j<r; j++) {
            if(a[j] < pivot) {
                if(i == j){
                    ++i;
                }else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] a = {1,4,54,23,42,2,34,53,2,22,3,432,424,24,353,22,66,76,84,25,345,35,35,225,15,23,45};
        quickSort(a,a.length);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
