package com.data.structures.practice.dynamicProgramming.TreeDP;

import com.data.structures.practice.treePrac.treePrac.TreeNode;

public class MaxPathSumBinaryTree {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionMaxPathSumBinaryTree {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        rec(root);
        return max;
    }

    public int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l =  Math.max(0,rec(root.left)) ;
        int r = Math.max(0, rec(root.right)) ;

        int subRootSumMax = l + r + root.val;// this is the max the current root level

        max = Math.max(max, subRootSumMax);//This is the important trick - store max at each level

        return root.val+Math.max(l, r);/// you can either choose left or right
    }
}
