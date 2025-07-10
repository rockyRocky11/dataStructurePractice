package com.data.structures.practice.treePrac;

import java.util.HashMap;

public class BinaryTreeBalanced {
    public static void main(String[] args) {

        Tree tree = new Tree();
        //Integer[] inputArray ={3,9,20,null,null,15,7};
        //Integer[] inputArray ={1,2,2,3,3,null,null,4,4};
        Integer[] inputArray ={1,2,2,3,null,null,3,4,null,null,4};
        tree.buildTree(inputArray);
        System.out.println(isBalanced(tree.getData()));

    }

    public static boolean isBalanced(TreeNode root) {
        HashMap<Integer, Boolean> nodeUnbalanced = new HashMap<>();
        nodeUnbalanced.put(0, false);
        System.out.println(maxDepth(root.getLeftChild(), nodeUnbalanced));
        System.out.println(maxDepth(root.getRightChild(), nodeUnbalanced));
        int leftDepth = maxDepth(root.getLeftChild(), nodeUnbalanced);
        int rightDepth = maxDepth(root.getRightChild(), nodeUnbalanced);
        System.out.println("nodeUnbalanced "+nodeUnbalanced);
        return !nodeUnbalanced.get(0) && (leftDepth-rightDepth ==0 || leftDepth-rightDepth ==-1|| leftDepth-rightDepth ==1) ;

    }

    public static int maxDepth(TreeNode root,  HashMap<Integer, Boolean> nodeUnbalanced) {
        if(root== null){
            return 0;
        }

        int leftDepth = maxDepth(root.getLeftChild(), nodeUnbalanced);
        int rightDepth = maxDepth(root.getRightChild(), nodeUnbalanced);

        int total =1+Math.max(leftDepth, rightDepth);

        if( Math.abs(leftDepth-rightDepth) >1){
            nodeUnbalanced.put(0, true);
        }
        return total;

    }
}
