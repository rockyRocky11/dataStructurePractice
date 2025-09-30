package com.data.structures.practice.sorting.implementation;

public class MergeBetter {
    public int[] sortArray(int[] nums) {
        int[] tempArray = new int[nums.length];
        recursiveSplit( nums,  0,  nums.length, tempArray);
        return nums;

    }

    public void recursiveSplit(int[] nums, int start, int end, int[] tempArray){

        if(end-start<2)return;
        int mid = (start+end)/2;
        recursiveSplit( nums,  start,  mid, tempArray);
        recursiveSplit( nums,  mid,  end, tempArray);
        merge(nums, start, mid, end, tempArray);
    }

    public void merge(int[] nums, int start, int mid, int end, int[] tempArray){

        int i=start;
        int j = mid;
        int tempIndex=0;
        while(i<mid && j<end){
            tempArray[tempIndex++]=nums[i]<=nums[j]? nums[i++]: nums[j++];//<= makes it stable
        }

        // take care of left overs on i side
        while(i<mid){
            tempArray[tempIndex++]=nums[i++];
        }

        // take care of left overs on j side
        while(j<end){
            tempArray[tempIndex++]=nums[j++];
        }
        System.arraycopy(tempArray, 0, nums, start, tempIndex);

    }
}
