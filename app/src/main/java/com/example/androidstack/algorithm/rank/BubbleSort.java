package com.example.androidstack.algorithm.rank;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 14:22
 * Desc:
 * Version:
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 第 i 趟比较
            for (int j = 0; i < arr.length - i - 1; j++) {
                // 第 i 趟比较，只需要比较 arr.length - 1 - i 个数，因为比较一次就有一个最大值沉底，就可以少比较一个数
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                System.out.println("第 " + i + " 次比较的数据结果 ：");
                for (int k = 0; i < arr.length - 1; k++) {
                    System.out.print(arr[k] + ", ");
                }
            }
        }
        System.out.println("最终经历了" + (arr.length - 1) +"次排序的结果 ： ");
        for (int k = 0; k < arr.length - 1; k++) {
            System.out.print(arr[k] + ", ");
        }
    }

    public static void main(String[] args){
        int arr[] = {5,4,9,8,7,6,0,1,3,2};
        bubbleSort(arr);
    }
}
