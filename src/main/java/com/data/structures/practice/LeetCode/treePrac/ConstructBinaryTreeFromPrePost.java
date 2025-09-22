package com.data.structures.practice.LeetCode.treePrac;

public class ConstructBinaryTreeFromPrePost {
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
    int preIdx;

    int postIdx;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIdx = preorder.length - 1;
        postIdx = postorder.length - 1;
        return dfs(preorder, postorder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int[] postorder, int rightEnd) {
        System.out.println("pre check" + preorder[preIdx]);
        if (postIdx < 0)
            return null;
        if (preorder[preIdx] == rightEnd) {
            //preIdx++;
            preIdx--;
            System.out.println("right ended");
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIdx--]);
        System.out.println(root.val);
        // System.out.println("right end "+preorder[preIdx]);
        root.right = dfs(preorder, postorder, root.val);
        root.left = dfs(preorder, postorder, rightEnd);
        return root;
    }
}