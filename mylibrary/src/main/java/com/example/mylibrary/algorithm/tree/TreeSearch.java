package com.example.mylibrary.algorithm.tree;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-12-11
 * Time: 15:08
 * Desc:
 * Version:
 */
/*
public class TreeSearch {
    // 前序遍历

    public void preOrderTraversal(TreeNode root) {
        if (root != null){
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.rigth);
        }
    }

    public void preOrderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node != null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            } else{
                TreeNode tmp = stack.pop();
                node = tmp.right;
            }
        }
    }

    // 中序遍历
    public void inOrderTraversal(TreeNode root){
        if (root!=null){
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null) {
                stack.push(node);
                node = node.left;
            } else{
                TreeNode tmp = stack.pop();
                System.out.println(tmp.val);
                node = tmp.right;
            }
        }
    }


    public void postOrderTraversal(TreeNode root){
        if (root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public void levelOrderTraversal(TreeNode root){
        if (root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left!=null){
                queue.add(node.left);
            }

            if (node.right!=null){
                queue.add(node.right);
            }
        }
    }




}

 */


//class PostOrder {
//
//
//
//    public void postOrderTraverse(TreeNode root) {
//        TreeNode cur, pre = null;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            if((cur.left==null&&cur.right==null)||(pre!=null&&(pre==cur.left||pre==cur.right))){
//                System.out.println(cur.val+"->");
//                stack.pop();
//                pre = cure;
//            }
//
//        }
//    }
//}



