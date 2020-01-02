package com.example.mylibrary.algorithm.string;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 19:55
 * Desc:
 * Version:
 */
public class StringCombination {
    public static void combinationResult(char[] c, int begin, int len, StringBuffer sb){
        if (len == 0){
            System.out.println(sb + " ");
            return;
        }

        if (begin == c.length){
            return;
        }
        sb.append(c[begin]);
        combinationResult(c,begin+1,len -1,sb);
        sb.deleteCharAt(sb.length() -1);
        combinationResult(c,begin+1,len -1,sb);
    }

    public static void main(String[] args){
        String s = "abcd";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer("");
        for (int i = 1; i <= c.length;i++){
            combinationResult(c,0,i,sb);
        }
    }
}
