package com.data.structures.practice.LeetCode.treePrac;

public class ConvertSortedToBalanced {

   /* Idea here is, since the data is sorted we pick the middle as root
    everything left to the middle is left subTree and everything to the right
    is right subTree, I used merge sort method to create a tree using recurssion*/

    /*Time complexity is O(n) - since im visiting elements only once
    Space complexity is also O(n) - since stack is created for n */
    public static void main(String[] args) {
        //Integer[] input = {3,9,20,null,null,15,7};
        //Integer[] input = {1,2,2,3,3,null,null,4,4};
        //int[] input = {-10,-3,0,5,9};
        //int[] input = {1, 3};
        int[] input = {0,1,2,3,4,5,6};
        TreeNode treeNode = new TreeNode();
        treeNode = treeNode.sortedArrayToBST(input);

        System.out.println();
    }

}
