package com.example.mylibrary.algorithm.list;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-12-11
 * Time: 17:08
 * Desc:
 * Version:
 */
public class DataNode {
    private int data;
    private DataNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }

//    public void levelOrderTraversal(TreeNode root){
//        if (root==null) return;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while(root!=null){
//            TreeNode node = queue.poll();
//            System.out.println(node.val);
//
//            if (node.left!=null){
//                queue.add(node.left);
//            }
//
//            if (node.right!=null){
//                queue.add(node.right);
//            }
//        }
//
//    }
}
