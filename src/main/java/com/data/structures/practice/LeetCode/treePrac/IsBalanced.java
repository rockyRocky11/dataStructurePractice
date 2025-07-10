package com.data.structures.practice.LeetCode.treePrac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class IsBalanced {
    public static void main(String[] args) {
        //Integer[] input = {3,9,20,null,null,15,7};
        //Integer[] input = {1,2,2,3,3,null,null,4,4};
        Integer[] input = {1, 2, null, 3, null, 4, null, 5};
        TreeNode treeNode = new TreeNode();
        treeNode = treeNode.inertBulkLevelOrder(input);
        System.out.println(isBalanced(treeNode));

    }
    /*
    This is bottom up approach(DFS) Recursion - I come up with

    I visit every node only once, because im setting the flag at every sub tree root

    Idea is do a DFS, from left - root - right
    Recursion will lead to the last left node and we will backtrack from there
    Keep track of the depth, when ever left and right height dont match update the failed array 0th index with 1

    O(n) --> searching all the node
    0(n)/ O(h)  – recursion stack depth = tree height (worst-case O(n), best-case O(log n))*/


    public static boolean isBalanced(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int[] failed = new int[1];
        maxDepth(root, failed);
        return failed[0] == 0;
    }

    public static int maxDepth(TreeNode root, int[] failed) {

        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        leftHeight = 1 + maxDepth(root.left, failed);
        rightHeight = 1 + maxDepth(root.right, failed);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            failed[0] = 1;
        }
        return Math.max(leftHeight, rightHeight);

    }

    /*
        This is bottom up approach(DFS) Iterative - */
    public boolean isBalancedUsingIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, last = null;
        Map<TreeNode, Integer> depths = new HashMap<>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    stack.pop();
                    int left = depths.getOrDefault(node.left, 0);
                    int right = depths.getOrDefault(node.right, 0);
                    if (Math.abs(left - right) > 1) return false;
                    depths.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return true;
    }
}
