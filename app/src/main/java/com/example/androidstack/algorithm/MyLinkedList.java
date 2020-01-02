package com.example.androidstack.algorithm;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-23
 * Time: 21:38
 * Desc:
 * Version:
 */
public class MyLinkedList {
    Node head = null;

    /**
     * 向链表中插入数据
     *
     * @param d： 插入数据的内容
     */
    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        // add node to end
        tmp.next = newNode;
    }

    /**
     * 删除指定节点的元素
     *
     * @param index：删除第 index 个结点
     * @return 成功返回 true, 失败返回 false
     */
    public Boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }

        if (index == 1) {
            head = head.next;
            return true;
        }

        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 返回结点的长度
     *
     * @return
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public Node orderList() {
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public void printList() {
        Node tmp = head;
        while (tmp!=null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    static class Node {
        private Node next = null;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
