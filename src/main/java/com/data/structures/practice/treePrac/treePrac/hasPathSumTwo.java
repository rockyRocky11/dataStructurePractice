package com.data.structures.practice.treePrac.treePrac;

import java.util.ArrayList;
import java.util.List;

public class hasPathSumTwo {
    public static void main(String[] args) {
        Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,5,1}; // Expected output: true
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        System.out.println(pathSum(tree, 22));
    }

    public static List<List<Integer>> pathSum(TreeNodeImpl root, int targetSum) {

        List<List<Integer>> resList = new ArrayList();
        List<Integer> sol = new ArrayList();

        findPathSum(resList, sol, root, targetSum);
        return resList;
    }

    public static void findPathSum(List<List<Integer>> resList, List<Integer> sol, TreeNodeImpl root, int targetSum){
        if(root == null){
            return;
        }
        if(root.val == targetSum && root.left == null && root.right == null){
            sol.add(root.val);
            resList.add(new ArrayList(sol));
            sol.remove(sol.size()-1);
            return;
        }
        sol.add(root.val);
        findPathSum(resList, sol, root.left, targetSum-root.val);
        findPathSum(resList, sol, root.right, targetSum-root.val);
        sol.remove(sol.size()-1);
    }
}
