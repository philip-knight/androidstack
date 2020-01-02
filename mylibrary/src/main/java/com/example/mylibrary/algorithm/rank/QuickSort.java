package com.example.mylibrary.algorithm.rank;

import java.util.Arrays;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 16:05
 * Desc:
 * Version:
 */
public class QuickSort {
    private static int partitionCount = 0;

    public static void main(String[] args) {
        int[] arr = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    /**
     * 对 arr[left right] 部分进行区分 partition 操作
     *
     * @param arr   待区分的数组
     * @param left  数组的起始索引
     * @param right 数组的结束索引
     * @return 返回值为 p, 使得 arr[left, p-1] < arr[p] < arr[p+1, right]
     */
    private static int partition(int[] arr, int left, int right) {
        partitionCount++;
        int pivot = arr[left];
        int j = left;
        //选取任意一个数作为关键性数据【也是就是数据标杆值】，一般选取左边第一个数据，所有比关键性数据小的数据放在数据的左边，比关键性数据大的数据在右边。
        //arr[left + 1, j] < pivot, 初始状态时 j = left, 那么 arr[left + 1, left] 是不存在的，保证了边界有效性
        //arr[j+1, i) > pivot， 初始状态时，i = left + 1, 那么 arr[left + 1, left + 1) 是不存在的，也保证了边界有效性
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, left, j);
        System.out.println("第 " + partitionCount + " 次分区的结果: " + Arrays.toString(arr));
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
