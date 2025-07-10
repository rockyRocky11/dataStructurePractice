package com.data.structures.practice.treePrac;

import java.util.*;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data=data;
    }

    public void insert(int value){
        if(value ==data){
            return;
        }

        if(value < data){
            if(leftChild == null){
                leftChild = new TreeNode(value);
            }
            else{
                leftChild.insert(value);
            }
        }
        else{
            if(rightChild == null){
                rightChild = new TreeNode(value);
            }
            else{
                rightChild.insert(value);
            }
        }
    }



    public int insertlevel(TreeNode root, int v) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.getLeftChild() == null) {
                node.setLeftChild(new TreeNode(v));
                return node.getData(); // returns parent’s value
            } else {
                q.add(node.getLeftChild());
            }
            if (node.getRightChild() == null) {
                node.setRightChild(new TreeNode(v));
                return node.getData();
            } else {
                q.add(node.getRightChild());
            }
        }
        return -1; // should not happen
    }

    public TreeNode get(int value){
        if(value ==data){
            return this;
        }

        if(value< data){
            if(leftChild != null){
                return leftChild.get(value);
            }
        }else{
            if(rightChild != null){
                return rightChild.get(value);
            }
        }
        return null;
    }

    public int min(){
        if(leftChild == null){
            return data;
        }else{
            return leftChild.min();
        }
    }

    public int max(){
        if(rightChild == null){
            return data;
        }else{
            return rightChild.max();
        }
    }



    public void traverseInOrder(){
        if (leftChild != null){
            leftChild.traverseInOrder();
        }
        System.out.print(data+", ");
        if (rightChild != null){
            rightChild.traverseInOrder();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.rightChild;
        }
        return res;
    }

    public static boolean IsMirror(TreeNode root1, TreeNode root2) {
        // TODO Auto-generated method stub
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }

        boolean fs = IsMirror(root1.leftChild, root2.rightChild);
        boolean ss = IsMirror(root1.rightChild, root2.leftChild);

        return fs && ss;
    }

    public List<Integer> inorderReverseTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.rightChild;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.leftChild;
        }
        return res;
    }

    public boolean inorderTraversalComp(TreeNode root, TreeNode root1) {
        //List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();

        while ((root != null && root1 != null)|| !stack.isEmpty()) {
            while (root != null && root1 != null) {
                stack.push(root);
                stack1.push(root1);
                root = root.leftChild;
                root1 = root1.leftChild;
            }
            root = stack.pop();
            root1 = stack1.pop();
            if(root.data != root1.data){
                return false;
            }
            root = root.rightChild;
            root1 = root1.rightChild;
        }
        return true;
    }
}
