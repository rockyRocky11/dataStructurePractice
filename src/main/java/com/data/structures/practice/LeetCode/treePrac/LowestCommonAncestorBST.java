package com.data.structures.practice.LeetCode.treePrac;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        //Integer[] root = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] root = {6,2,8,0,4,7,9,null,null,3,5};
        // Integer[] root = {1,2,3,null,4};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        System.out.println(lowestCommonAncestor(tree, new TreeNodeImpl(2), new TreeNodeImpl(8)).val);
        //System.out.println(lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(1), new TreeNode(4), new TreeNode(1)).val);
    }

    public static TreeNodeImpl lowestCommonAncestor(TreeNodeImpl root, TreeNodeImpl p, TreeNodeImpl q) {

        TreeNodeImpl lca = root;
        while(root != null){
            if(p.val < root.val && q.val <root.val){
                root = root.left;
                lca = root;
            }else if(p.val > root.val && q.val >root.val){
                root = root.right;
                lca = root;
            }else{
                return lca;
            }
        }
        return lca;
    }
}
