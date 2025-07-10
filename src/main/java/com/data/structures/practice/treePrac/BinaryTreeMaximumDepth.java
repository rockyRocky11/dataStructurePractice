package com.data.structures.practice.treePrac;

public class BinaryTreeMaximumDepth {
    public static void main(String[] args) {

        Tree tree = new Tree();
        Integer[] inputArray ={3,9,20,null,null,15,7};
        //Integer[] inputArray ={1,null,2};
        tree.buildTree(inputArray);
        System.out.println(maxDepth(tree.getData()));

    }

    public static int maxDepth(TreeNode root) {
        if(root== null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.getLeftChild()), maxDepth(root.getRightChild()));

    }
}
