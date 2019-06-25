package com.tie.algo.sort;

/**
 * �鲢�����㷨
 */
public class MergeSort {

    //�鲢�����㷨, a �����飬 n��ʶ�����С
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    //�ݹ���ú���
    public static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;

        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        //A[p,q]��A[q+1,r]�ϲ�ΪA[p...r]
        merge(a, p, q, r);
    }

    //�ϲ�
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r-p + 1];
        while (i <= q && j <= r) {
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        //�ж��ĸ�������ʣ������
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = a[start++];
        }

        for(i = 0; i <= r-p; i++) {
            a[p + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,54,23,42,2,34,53,2,22,3,432,424,24,353,22,66,76,84,25,345,35,35,225,15,23,45};
        mergeSort(a,a.length);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
