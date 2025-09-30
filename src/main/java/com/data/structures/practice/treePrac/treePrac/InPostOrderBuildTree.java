package com.data.structures.practice.treePrac.treePrac;

public class InPostOrderBuildTree {
    public static void main(String[] args) {
        //int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3}, inorder = {9,3,15,20,7};
        System.out.println(buildTree( inorder, postorder));
    }

    static int i = 0;
    static int j = 0;

    public static TreeNodeImpl buildTree(int[] inorder, int[] postorder) {
        i=inorder.length-1;
        j=postorder.length-1;

        return rec(inorder, postorder, -3001);
    }

    public static TreeNodeImpl rec(int[] inorder, int[] postorder, int stop) {
        System.out.println(i+" "+j);
        if (j < 0) {
            return null;
        }

        if (inorder[i] == stop) {
            i--;
            return null;
        }

        TreeNodeImpl root = new TreeNodeImpl(postorder[j--]);
        root.right = rec(inorder, postorder, root.val);
        root.right = rec(inorder, postorder, stop);
        return root;

    }
}
