package com.data.structures.practice.treePrac.treePrac;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl {

    TreeNode root;


    public void insertBST(Integer val){
        root = insertBST(val, root);
    }

    public TreeNode insertBST(Integer val, TreeNode node){
        if(node ==null) return new TreeNode(val);
        if(val != null && val < node.val){
            node.left = insertBST(val, node.left);
        }else if(val != null && val > node.val){
            node.right = insertBST(val, node.right);
        }else{
            return node;
        }
        return node;
    }

    public List<Integer> inorderTraversal(){
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res){
        if(node == null)return;
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
}
