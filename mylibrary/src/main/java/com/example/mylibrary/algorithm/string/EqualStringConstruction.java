package com.example.mylibrary.algorithm.string;

import java.util.Arrays;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 18:24
 * Desc:
 * Version:
 */
public class EqualStringConstruction {
    public static void compare(String s1, String s2){
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        s1 = new String(b1);
        s2 = new String(b2);
        if (s1.equals(s2)){
            System.out.println("Two String Construction Equal");
        }else {
            System.out.println("Two String Construction Not Equal");
        }
    }


    public static void compare2(String s1, String s2){
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        int[] bCount = new int[256];
        for(int i = 0 ; i< 256; i++){
            bCount[i] = 0;
        }
        for (int i = 0 ; i <b1.length;i++){
            bCount[b1[i] - '0']++;
        }
        for (int i = 0 ; i <b2.length;i++){
            bCount[b2[i] - '0']--;
        }
        for (int i = 0; i<256; i++){
            if (bCount[i] != 0){
                System.out.println("Method2 Two String Construction Not Equal");
                return;
            }
        }
        System.out.println("Method2 Two String Construction Equal");
    }


    public static void main(String[] args){
        String s1 = "aaaabbc";
        String s2 = "abcbaaa";
        compare(s1,s2);
        compare2(s1,s2);

        s1 = "aaaabbc";
        s2 = "abcbaab";
        compare(s1,s2);
        compare(s1,s2);
    }
}
