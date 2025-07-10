package com.data.structures.practice.LeetCode.treePrac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hasPathSumThree {
    private static int count = 0;

    public static void main(String[] args) {
        //Integer[] root = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}; // Expected output: true
        Integer[] root = {10,5,-3,3,2,null,11,3,-2,null,1}; // Expected output: true
        TreeNode tree = new TreeNode();
        tree = tree.inertBulkLevelOrder(root);
       // dfs(tree, 0);
        System.out.println(pathSumOptimized(tree, 8));
    }

    //Time Complexity = n^2 -> DFS for each node
    // Space also same
    public static void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        pathSum1(root, targetSum);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }

    public static void pathSum1(TreeNode root, long targetSum) {

        if (root == null ) {
            return;
        }
        if (targetSum == root.val) {
            count = count + 1;
        }
        pathSum1(root.left, (long)targetSum - root.val);
        pathSum1(root.right, (long)targetSum - root.val);
    }


    /*      | Operation | Complexity                                     |
            | --------- | ---------------------------------------------- |
            | Time      | **O(n)**                                       |
            | Space     | **O(n)** (for the HashMap and recursion stack) |
    */
    public static int pathSumOptimized(TreeNode root, long targetSum) {

        HashMap<Long, Integer> store = new HashMap<>();
        store.put(0L,0);
        return dfsOptimized(root, 0L, targetSum, store);

    }

    public static int dfsOptimized(TreeNode root, long currSum, long targetSum, HashMap<Long, Integer> store) {

        if(root == null){
            return 0;
        }
        currSum+=root.val;

        int pathSum = store.getOrDefault((currSum-targetSum),0);

        store.put((currSum), store.getOrDefault((currSum), 0)+1);
        int left= dfsOptimized(root.left, currSum, targetSum, store);
        int right = dfsOptimized(root.right, currSum, targetSum, store);

        store.put(currSum, store.getOrDefault(currSum, 0)-1);

        return pathSum+left+right;

    }

}
