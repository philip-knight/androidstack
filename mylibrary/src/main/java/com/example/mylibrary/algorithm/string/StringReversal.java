package com.example.mylibrary.algorithm.string;

import java.util.Arrays;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 17:42
 * Desc:
 * Version:
 */
public class StringReversal {
    public static void swap(char[] cArr, int front, int end) {
        while (front < end) {
            char tmp = cArr[end];
            cArr[end] = cArr[front];
            cArr[front] = tmp;
            front++;
            end--;
        }
    }

    public static String swapString(String s) {
        char[] cArr = s.toCharArray();
        swap(cArr, 0, cArr.length - 1);
        System.out.println(Arrays.toString(cArr));
        int beginIndex = 0;
        for (int i = 1; i < cArr.length; i++) {
            if (cArr[i] == ' '){
                swap(cArr,beginIndex,i-1);
                beginIndex = i + 1;
            }
        }
        swap(cArr,beginIndex,cArr.length-1);
        return new String(cArr);
    }

    public static void main(String[] args){
        String str = "how are  you good i am, fun";
        System.out.println(swapString(str));
    }
}
