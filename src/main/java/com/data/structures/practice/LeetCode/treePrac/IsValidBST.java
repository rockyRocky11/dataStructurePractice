package com.data.structures.practice.LeetCode.treePrac;

public class IsValidBST {
    private static boolean isValid = true;

    public static void main(String[] args) {
        // Integer[] root = {0,-1};
        //Integer[] root = {5,4,6,null,null,3,7};
        //Integer[] root = {2,2,2};
        // Integer[] root = {2,1,3};
        Integer[] root = {5, 1, 4, null, null, 3, 6};
        // Integer[] root = {25, 20, 27, 15, 22, 26, 30,null, null,null, null, null, null, 29, 32};
        // Integer[] root = {98,-57,null,null,58,31};
        //Integer[] root = {45,42,null,null,44,43,null,41};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);

        System.out.println(isValidBST(tree));
    }
   /*
    Here, the idea is instead of comparing left and right with root at each subtree,
    we take each node and compare what the range it can be to not break BST creteria.*/

    /*Time COmplexity: O(N)
    Space COmplexity: O(N)*/

    public static boolean isValidBST(TreeNodeImpl root) {

        if (root.left == null && root.right == null) {
            return true;
        }


        return inOrderTraversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean inOrderTraversal(TreeNodeImpl root, Long min, Long max) {

        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return inOrderTraversal(root.left, min, (long) root.val) && inOrderTraversal(root.right, (long) root.val, max);
    }

}
