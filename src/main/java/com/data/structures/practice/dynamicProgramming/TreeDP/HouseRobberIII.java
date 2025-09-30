package com.data.structures.practice.dynamicProgramming.TreeDP;

import com.data.structures.practice.treePrac.treePrac.TreeNode;

public class HouseRobberIII {
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
class Solution {
    public int rob(TreeNode root) {
        return dfs(root).prev;
    }

    public DetailNode dfs(TreeNode root) {
        if (root == null)
            return null;

        DetailNode left = dfs(root.left);
        DetailNode right = dfs(root.right);

        int leftPrev = left != null ? left.prev : 0;
        int leftPrevPrev = left != null ? left.prevPrev : 0;
        int rightPrev = right != null ? right.prev : 0;
        int rightPrevPrev = right != null ? right.prevPrev : 0;

        int prev = Math.max(leftPrev + rightPrev, rightPrevPrev + leftPrevPrev + root.val);
        int prevPrev = leftPrev + rightPrev;
        return new DetailNode(prev, prevPrev);
    }
}

 class DetailNode {
    int prev;
    int prevPrev;

    public DetailNode(int prev, int prevPrev) {
        this.prev = prev;
        this.prevPrev = prevPrev;
    }
}
