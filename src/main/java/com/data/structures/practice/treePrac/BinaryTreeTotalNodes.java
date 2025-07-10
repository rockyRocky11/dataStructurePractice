package com.data.structures.practice.treePrac;

public class BinaryTreeTotalNodes {
    public static void main(String[] args) {

        Tree tree = new Tree();
        //Integer[] inputArray ={3,9,20,null,null,15,7};
        //Integer[] inputArray ={1,2,3,4,5,6};
        Integer[] inputArray ={};
        //Integer[] inputArray ={1,null,2};
        tree.buildTree(inputArray);
        System.out.println(maxDepth(tree.getData()));

    }

    public static int maxDepth(TreeNode root) {
        if(root== null){
            return 0;
        }
        return 1+maxDepth(root.getLeftChild())+ maxDepth(root.getRightChild());

    }
}
