package com.example.mylibrary.algorithm.others;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-24
 * Time: 19:04
 * Desc:
 * Version:
 */
public class DeleteBracket {
    public static String changeStr(String s) {
        String result = "(";
        char[] ch = s.toCharArray();
        int bracketNum = 0;
        int i = 0;
        while (i < ch.length) {
            if (ch[i] == '(') {
                bracketNum++;
            } else if (ch[i] == ')') {
                if (bracketNum > 0) {
                    bracketNum--;
                } else {
                    System.out.println("Illegal Input, Left Bracket Wrong");
                    return null;
                }
            } else if (ch[i] == ',') {
                result += ch[i];
            } else if (ch[i] >= '0' && ch[i] <= '9') {
                result += ch[i];
            } else {
                System.out.println("Illegal Input, Unknown");
                return null;
            }
            i++;
        }
        if (bracketNum > 0) {
            System.out.println("Illegal Input, Bracket Wrong");
            return null;
        }
        result += ')';
        return result;
    }

    public static void main(String[] args) {
        String s1 = "(1,(2,3),(4,(5,6),7))";
        String result = changeStr(s1);
        if (result != null) {
            System.out.println(result);
        }

        String s2 = "(1,(2,3),((4,(5,6),7))";
        result = changeStr(s2);
        if (result != null) ;{
            System.out.println(result);
        }

    }
}
