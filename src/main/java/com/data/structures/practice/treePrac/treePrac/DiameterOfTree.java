package com.data.structures.practice.treePrac.treePrac;

public class DiameterOfTree {

    public static void main(String[] args) {
        Integer[] root = {1,2,3,4,5};// ans =3
       // Integer[] root = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};// ans =8
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        System.out.println(diameterOfBinaryTree(tree));
    }

   static int max = 0;

    public static int diameterOfBinaryTree(TreeNodeImpl root) {
        max = 0; // reset for safety
        //int l = root.left != null ? rec(root.left) + 1 : 0;
       // int r = root.right != null ? rec(root.right) + 1 : 0;
        //int subRootSum = l + r;

       // max = Math.max(max, subRootSum);
        rec(root);
        return max;
    }

    public static int rec(TreeNodeImpl root) {
        if (root == null) {
            return 0;
        }
        int l = root.left != null ? rec(root.left) + 1 : 0;
        int r = root.right != null ? rec(root.right) + 1 : 0;

        // update diameter: deepest path through current node
        int subRootSum = l + r;

        max = Math.max(max, subRootSum);

        // return height to parent
        return Math.max(l, r);
    }
}
