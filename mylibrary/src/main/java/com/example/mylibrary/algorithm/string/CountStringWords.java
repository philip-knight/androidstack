package com.example.mylibrary.algorithm.string;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 19:37
 * Desc:
 * Version:
 */
public class CountStringWords {
    public static int wordCount(String s) {
        int word = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                word = 0;
            } else if (word == 0){
                word = 1;
                count ++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String s = "i am hehao";
        System.out.println(wordCount(s));

    }
}
