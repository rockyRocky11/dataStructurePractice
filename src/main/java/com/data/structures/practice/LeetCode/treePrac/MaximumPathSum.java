package com.data.structures.practice.LeetCode.treePrac;

public class MaximumPathSum {
    public static void main(String[] args) {
       // Integer[] root = {1,2,3};// ans =6
         //Integer[] root = {9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6};// ans =16
        //Integer[] root = {1,-2,3};// ans =4
         Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,null,1};// ans =48
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        System.out.println(maxPathSum(tree));
    }

    static int max = Integer.MIN_VALUE;
    // Time O(n)
    // Space O(h)
    public static int maxPathSum(TreeNodeImpl root) {
        max = Integer.MIN_VALUE;
        rec(root);
        return max;
    }

    public static int rec(TreeNodeImpl root) {
        if (root == null) {
            return 0;
        }
        int l =  Math.max(0,rec(root.left)) ;
        int r = Math.max(0, rec(root.right)) ;

        int subRootSumMax = l + r + root.val;

        max = Math.max(max, subRootSumMax);

        return root.val+Math.max(l, r);
    }
}
