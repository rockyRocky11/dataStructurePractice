package com.data.structures.practice.LeetCode.treePrac;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CommonAncestor {
    public static void main(String[] args) {
        //Integer[] root = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] root = {3,5,1,6,2,0,8,null,null,7,4};
       // Integer[] root = {1,2,3,null,4};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        //System.out.println(lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(4), new TreeNode(5), new TreeNode(4)).val);
        System.out.println(lowestCommonAncestorInOrderRecursion(tree, new TreeNodeImpl(5), new TreeNodeImpl(4)).val);
        //System.out.println(lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(1), new TreeNode(4), new TreeNode(1)).val);
    }

    public static TreeNodeImpl lowestCommonAncestorInOrder(TreeNodeImpl root, TreeNodeImpl p, TreeNodeImpl q) {

        Stack<TreeNodeImpl> stack = new Stack<>();
        TreeNodeImpl ancestor = root;
        boolean l=false;
        boolean r=false;

        while (root != null || !stack.isEmpty()) {
            ancestor= root;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val == p.val)l=true;
            if(root.val == q.val)r=true;
            if(l&&r)return root;
            //System.out.println(root.val);
            root = root.right;

        }
        return null;
    }

    public static TreeNodeImpl lowestCommonAncestorInOrderRecursion(TreeNodeImpl root, TreeNodeImpl p, TreeNodeImpl q) {

        if(root == null){
            return root;
        }
        if(root.val == p.val){

            System.out.println(root.val);
            return root;
        }
        if(root.val == q.val){
            System.out.println(root.val);
            return root;
        }
         TreeNodeImpl l = lowestCommonAncestorInOrderRecursion( root.left,  p,  q);
        TreeNodeImpl r = lowestCommonAncestorInOrderRecursion( root.right,  p,  q);
        if(l != null && r !=null){
            return root;
        }
        return l != null?l:r;
    }

    public static TreeNodeImpl lowestCommonAncestor(TreeNodeImpl root, TreeNodeImpl p, TreeNodeImpl q, TreeNodeImpl op, TreeNodeImpl oq) {
        TreeNodeImpl pAncestor = findAncestor(root, p);
        TreeNodeImpl qAncestor = findAncestor(root, q);
        if(pAncestor.val == qAncestor.val){
            return pAncestor;
        }
        else if(qAncestor.val == op.val || pAncestor.val==op.val ){
            return op;
        }
        else if(pAncestor.val == oq.val || qAncestor.val==oq.val ){
            return oq;
        }
        else{
            return lowestCommonAncestor(root, pAncestor, qAncestor, op, oq);
        }
    }

    public static TreeNodeImpl findAncestor(TreeNodeImpl root, TreeNodeImpl a) {

        TreeNodeImpl ancestor = root;
        if (ancestor.val == a.val) {
            return ancestor;
        }
        Deque<TreeNodeImpl> deque = new ArrayDeque<>();
        deque.offer(ancestor);
        while (!deque.isEmpty()) {
            TreeNodeImpl tempNode = deque.poll();
            ancestor = tempNode;
            if (tempNode.left != null) {
                if (a.val == tempNode.left.val) {
                    return ancestor;
                }
                deque.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                if (a.val == tempNode.right.val) {
                    return ancestor;
                }
                deque.offer(tempNode.right);
            }
        }
        return null;

    }

}
