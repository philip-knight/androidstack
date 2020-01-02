package com.example.mylibrary.algorithm.list;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-12-11
 * Time: 16:56
 * Desc:
 * Version:
 */


/*
public class LoopList {
    public static boolean isLoop(DataNode h) {
        DataNode p1 = h;
        DataNode p2 = h;
        while (p2.getNext() != null && p2.getNext().getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (p1 == p2) {
                break;
            }
        }
        return !(p1 == null || p2 == null);
    }

    // 判断两个链表相交
    public static boolean isJoinNoLoop(DataNode h1, DataNode h2) {
        DataNode p1 = h1;
        DataNode p2 = h2;
        while (p1.getNext() != null) {
            p1 = p1.getNext();
        }
        while (p2.getNext() != null) {
            p2 = p2.getNext();
        }
        return p1 == p2;
    }


    public static DataNode getFirstJoinNode(DataNode h1, DataNode h2) {
        int length1 = 0;
        int length2 = 0;
        while (h1.getNext() != null) {
            length1++;
            h1 = h1.getNext();
        }
        while (h2.getNext() != null) {
            length2++;
            h2 = h2.getNext();
        }
        return length1 >= length2 ? getNode(h1, length1, h2, length2) : getNode(h2, length2, h1, length1);
    }
}

 */
