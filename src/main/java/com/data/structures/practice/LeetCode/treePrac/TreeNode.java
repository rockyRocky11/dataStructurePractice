package com.data.structures.practice.LeetCode.treePrac;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {



    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        int start = 0;
        int end = nums.length;
        int mid = end/2;
        return recussiveBST(nums, start, end);

    }

    public static TreeNode recussiveBST(int[] nums, int start, int end) {

        if(end-start ==0){
            return null;
        }
        if(end-start ==1){
            return new TreeNode(nums[start]);
        }
        if(end-start==2){
            TreeNode subRoot = new TreeNode(nums[start+1]);
            subRoot.left=new TreeNode(nums[start]);
            return subRoot;
        }
        int mid = (start+end)/2;
        TreeNode leftSubTree = recussiveBST(nums, start, mid);
        TreeNode rightSubTree = recussiveBST(nums, mid+1, end);

        TreeNode root = new TreeNode(nums[mid]);
        root.left=leftSubTree;
        root.right=rightSubTree;

        return root;
    }

    public TreeNode inertBulkLevelOrder(Integer[] input){

        if(input == null || input.length <= 0){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(input[0]);
        queue.add(root);

        int i=1;
        while(i< input.length && !queue.isEmpty()){

            TreeNode tempRoot = queue.poll();
            if(i< input.length && input[i] != null){
                tempRoot.left = new TreeNode(input[i]);
                queue.add(tempRoot.left);
            }
            i++;
            if(i< input.length && input[i] != null){
                tempRoot.right = new TreeNode(input[i]);
                queue.add(tempRoot.right);
            }
            i++;
        }
        return root;

    }


}
