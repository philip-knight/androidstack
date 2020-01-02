package com.example.mylibrary.algorithm.rank;

import java.util.Arrays;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 15:11
 * Desc:
 * Version:
 */
public class BubbleSort {

    private static void bubbleSort(int[] arr) throws Exception {
        if (arr == null || arr.length < 2) {
            throw new Exception("Illegal Array");
        }

        System.out.println("未排序的数组为 ：" + Arrays.toString(arr));
        System.out.println("最多需要经过 " + (arr.length - 1) + " 轮排序");
        System.out.println();

        for (int i = 0; i < (arr.length - 1); i++) {
            // 第 i 趟比较
            System.out.println("第" + (i + 1) + "轮排序细节如下");
            boolean outterLoopFlag  = true;
            for (int j = 0; j < (arr.length - i - 1); j++) {
                // 第 i 趟比较，只需要比较 arr.length - 1 - i 个数，因为比较一次就有一个最大值沉底，就可以少比较一个数
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    outterLoopFlag = false;
//                    swap(Collections.singletonList(arr),j,j+1);
                }
                System.out.println("第" +  (j+1) + "次比较的结果: " + Arrays.toString(arr));
            }
            if (outterLoopFlag){
                break;
            }
            System.out.println("第" + (i + 1) + "轮后: " + Arrays.toString(arr));
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int[] originList = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        bubbleSort(originList);
    }
}