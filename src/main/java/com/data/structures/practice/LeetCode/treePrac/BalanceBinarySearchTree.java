package com.data.structures.practice.LeetCode.treePrac;

import com.data.structures.practice.treePrac.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BalanceBinarySearchTree {
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        Integer[] root = {1,null,2,null,3,null,4,null,null};
        for(Integer n: root){
            bst.insertBST(n);
        }
        List<Integer> bstTree=bst.inorderTraversal();
        TreeNode ans=balanceBST(bst.root);
        System.out.println(ans);
    }
    /*Final
    Time: O(n)

    Space: O(n) (list + recursion stack)*/

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> bstTree = inorderTraversal(root);
        return buildBalanceBST( bstTree, 0, bstTree.size()-1);
    }


    public static TreeNode buildBalanceBST( List<Integer> bstTree, int start, int end) {
        if(start>end)return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(bstTree.get(mid));
        node.left = buildBalanceBST( bstTree, start, mid-1);
        node.right = buildBalanceBST( bstTree, mid+1, end);
        return node;
    }
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public static void dfs(TreeNode node, List<Integer> res){
        if(node == null)return;
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }


}
