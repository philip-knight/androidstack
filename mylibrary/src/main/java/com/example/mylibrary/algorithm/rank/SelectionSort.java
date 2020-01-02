package com.example.mylibrary.algorithm.rank;

import java.util.Arrays;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 16:57
 * Desc:
 * Version:
 */
public class SelectionSort {

    private static void sortFromFrontIndex(int[] arr) {
        System.out.println("当前的数组为 ： " + Arrays.toString(arr));
        int tmp = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++ ){
                if (arr[minIndex] > arr[j]){
                    tmp = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i ){
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
            System.out.println("第 " + (i+1) + " 次排序结果" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        sortFromFrontIndex(arr);
    }
}
