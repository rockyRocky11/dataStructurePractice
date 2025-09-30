package com.data.structures.practice.treePrac.treePrac;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeImpl {



    int val;
    TreeNodeImpl left;
    TreeNodeImpl right;

    TreeNodeImpl() {
    }

    TreeNodeImpl(int val) {
        this.val = val;
    }

    TreeNodeImpl(int val, TreeNodeImpl left, TreeNodeImpl right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNodeImpl sortedArrayToBST(int[] nums) {

        int start = 0;
        int end = nums.length;
        int mid = end/2;
        return recussiveBST(nums, start, end);

    }

    public static TreeNodeImpl recussiveBST(int[] nums, int start, int end) {

        if(end-start ==0){
            return null;
        }
        if(end-start ==1){
            return new TreeNodeImpl(nums[start]);
        }
        if(end-start==2){
            TreeNodeImpl subRoot = new TreeNodeImpl(nums[start+1]);
            subRoot.left=new TreeNodeImpl(nums[start]);
            return subRoot;
        }
        int mid = (start+end)/2;
        TreeNodeImpl leftSubTree = recussiveBST(nums, start, mid);
        TreeNodeImpl rightSubTree = recussiveBST(nums, mid+1, end);

        TreeNodeImpl root = new TreeNodeImpl(nums[mid]);
        root.left=leftSubTree;
        root.right=rightSubTree;

        return root;
    }

    public TreeNodeImpl inertBulkLevelOrder(Integer[] input){

        if(input == null || input.length <= 0){
            return null;
        }
        Queue<TreeNodeImpl> queue = new LinkedList();
        TreeNodeImpl root = new TreeNodeImpl(input[0]);
        queue.add(root);

        int i=1;
        while(i< input.length && !queue.isEmpty()){

            TreeNodeImpl tempRoot = queue.poll();
            if(i< input.length && input[i] != null){
                tempRoot.left = new TreeNodeImpl(input[i]);
                queue.add(tempRoot.left);
            }
            i++;
            if(i< input.length && input[i] != null){
                tempRoot.right = new TreeNodeImpl(input[i]);
                queue.add(tempRoot.right);
            }
            i++;
        }
        return root;

    }


}
