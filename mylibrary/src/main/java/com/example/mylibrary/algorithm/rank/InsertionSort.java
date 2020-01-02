package com.example.mylibrary.algorithm.rank;

import java.util.Arrays;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 16:02
 * Desc:
 * Version:
 */
public class InsertionSort {
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            if (arr[j - 1] > tmp) {
                while (j>=1 && arr[j-1] > tmp){
                    arr[j] = arr[j-1];
                    j--;
                }
            }
            arr[j] = tmp;
            System.out.println("第" + i +" 次排序的结果： " + Arrays.toString(arr)) ;
        }
    }

    public static void main(String[] args){
        int[] originList = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        insertionSort(originList);
    }

}
