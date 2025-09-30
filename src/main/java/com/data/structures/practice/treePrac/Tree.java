package com.data.structures.practice.treePrac;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void insertlevel(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else{
            root.insertlevel(root, value);
        }

    }
    public  TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        root= new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode node = q.poll();
            if (arr[i] != null) {
                node.setLeftChild(new TreeNode(arr[i]));
                q.add(node.getLeftChild());
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.setRightChild(new TreeNode(arr[i]));
                q.add(node.getRightChild());
            }
            i++;
        }

        return root;
    }



    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {

        if (subTreeRoot == null) {
            return subTreeRoot;
        }
        if ( value < subTreeRoot.getData() ) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if (value > subTreeRoot.getData()  ) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }
            subTreeRoot.setData(subTreeRoot.getRightChild().min());
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }

        return subTreeRoot;
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public List<Integer> inorderTraversal() {
        if (root != null) {
            return root.inorderTraversal(root);
        }
        return null;
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.min();
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return root.max();
    }

    public TreeNode getData(){
        return root;
    }

}
