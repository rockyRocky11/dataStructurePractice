package com.data.structures.practice.treePrac.treePrac;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubTreeOfAnother {
    public static void main(String[] args) {
        //Integer[] root = {3,4,5,1,2}, subRoot = {4,1,2};
        Integer[] root = {4,-9,5,null,-1,null,8,-6,0,7,null,null,-2,null,null,null,null,-3}, subRoot = {5};
        //Integer[] root = {1, 1}, subRoot = {1};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        TreeNodeImpl subTree = new TreeNodeImpl();
        subTree = tree.inertBulkLevelOrder(subRoot);
        System.out.println(isSubtree(tree, subTree));
    }

    public static boolean isSubtree1(TreeNodeImpl root, TreeNodeImpl subRoot) {

        return findMatchingRoot(root, subRoot);
      /*  if(matchingRoot == null){
            return false;
        }

        return findMatch( matchingRoot ,  subRoot);*/

    }

    public static boolean findMatchingRoot(TreeNodeImpl root, TreeNodeImpl subRoot) {

        TreeNodeImpl matchingRoot = root;
        if (matchingRoot.val == subRoot.val) {
            if (isSame(matchingRoot, subRoot)) {
                return true;
            }
        }
        Deque<TreeNodeImpl> deque = new ArrayDeque<>();
        deque.offer(matchingRoot);
        while (!deque.isEmpty()) {
            TreeNodeImpl tempNode = deque.poll();
            matchingRoot = tempNode;
            if (tempNode.left != null) {
                if (subRoot.val == tempNode.left.val) {
                    if (isSame(tempNode.left, subRoot)) {
                        return true;
                    }
                }
                deque.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                if (subRoot.val == tempNode.right.val) {
                    if (isSame(tempNode.right, subRoot)) {
                        return true;
                    }
                }
                deque.offer(tempNode.right);
            }
        }
        return false;

    }

    public static boolean isSame(TreeNodeImpl p, TreeNodeImpl q) {

        if(p == null && q == null){
            return true;
        }
        if((p != null && q == null) || (p == null && q != null)){
            return false;
        }

        if(p.val != q.val ){
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static boolean isSubtree(TreeNodeImpl root, TreeNodeImpl subRoot) {

        if(root == null){
            return false;
        }

        if(isSame(root, subRoot)){
            return true;
        }
        return  isSubtree( root.left,  subRoot) || isSubtree( root.right,  subRoot);

    }

    public static boolean findMatch(TreeNodeImpl root, TreeNodeImpl subRoot) {


        Deque<TreeNodeImpl> deque = new ArrayDeque<>();
        Deque<TreeNodeImpl> subDeque = new ArrayDeque<>();
        deque.offer(root);
        subDeque.offer(subRoot);
        while (!deque.isEmpty() && !subDeque.isEmpty()) {
            TreeNodeImpl tempNode = deque.poll();
            TreeNodeImpl subTempNode = subDeque.poll();

            if (tempNode.left == null && subTempNode.left == null) {
                System.out.println("Both NUll");

            } else if (tempNode.left != null && subTempNode.left != null && tempNode.left.val == subTempNode.left.val) {
                deque.offer(tempNode.left);
                subDeque.offer(subTempNode.left);
            } else {
                return false;

            }
            if (tempNode.right == null && subTempNode.right == null) {
                System.out.println("Both NUll");

            } else if (tempNode.right != null && subTempNode.right != null && tempNode.right.val == subTempNode.right.val) {
                deque.offer(tempNode.right);
                subDeque.offer(subTempNode.right);
            } else {
                return false;

            }
        }
        return true;

    }
}
