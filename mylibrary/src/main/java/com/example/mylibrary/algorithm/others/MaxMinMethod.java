package com.example.mylibrary.algorithm.others;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 19:26
 * Desc:
 * Version:
 */
public class MaxMinMethod {
    public static int max(int a, int b) {
        return (int) (((long) a + (long) b + Math.abs((long) a - (long) b)) / 2);
    }

    public static int min(int a, int b) {
        return (int) (((long) a + (long) b - Math.abs((long) a - (long) b)) / 2);
    }

    public static void main(String[] args){
        System.out.println("max(3,5)" + max(3,5));
        System.out.println("min(3,5)" + min(3,5));
    }
}
