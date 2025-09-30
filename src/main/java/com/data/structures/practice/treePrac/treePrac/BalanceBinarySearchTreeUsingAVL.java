package com.data.structures.practice.treePrac.treePrac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceBinarySearchTreeUsingAVL {

    static Map<TreeNode, Integer> heightMap = new HashMap<>();
    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        Integer[] root = {1,null,2,null,3,null,4,null,null};
        for(Integer n: root){
            bst.insertBST(n);
        }
        System.out.println(balaanceBST(bst.root));
    }

    public static TreeNode balaanceBST(TreeNode root) {
        heightMap = new HashMap<>();
        List<Integer> bstTree = inorderTraversal(root);
        TreeNode ans= null;
        for(Integer n: bstTree){
            ans=insert1(n, ans);
        }
        return ans;
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

    static int getHeight(TreeNode node){
        return node == null?0:heightMap.getOrDefault(node,0);
    }

    static int getBalance(TreeNode node){
        return node==null?0:getHeight(node.left)-getHeight(node.right);
    }

    static TreeNode rotateRight(TreeNode y){// LL case

        TreeNode x = y.left;
        TreeNode t2 = x.right;

        //Rotate
        x.right = y;
        y.left = t2;

        heightMap.put(y, Math.max(getHeight(y.left), getHeight(y.right))+1);
        heightMap.put(x, Math.max(getHeight(x.left), getHeight(x.right))+1);
        return x;
    }

    static TreeNode rotateLeft(TreeNode x){// RR case

        TreeNode y = x.right;
        TreeNode t2 = x.left;

        //Rotate
        y.left = x;
        x.right = t2;

        heightMap.put(x, Math.max(getHeight(x.left), getHeight(x.right))+1);
        heightMap.put(y, Math.max(getHeight(y.left), getHeight(y.right))+1);
        return y;
    }

    public static TreeNode insert1(Integer val, TreeNode node){
        if(node ==null){
            TreeNode t =new TreeNode(val);
                    heightMap.put(t, 1);
            return t;
        }
        if(val != null && val < node.val){
            node.left = insert1(val, node.left);
        }else if(val != null && val > node.val){
            node.right = insert1(val, node.right);
        }else{
            return node;
        }
        heightMap.put(node, Math.max(getHeight(node.left), getHeight(node.right))+1);

        int h = getBalance(node);

        if(h>1 && val<node.left.val){//right
            return rotateRight(node);
        }

        if(h<-1 && val>node.right.val){//left rotate
            return rotateLeft(node);
        }

        if(h>1 && val>node.left.val){// LR Case
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if(h<-1 && val<node.right.val){// RL Case
           node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }


}
