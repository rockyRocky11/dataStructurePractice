package com.data.structures.practice.sorting.problems;

public class FindMissing {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {

        int[] countingArray = new int[nums.length+1];

        for(int i=0;i< nums.length;i++){
            countingArray[nums[i]]++;
        }

        for(int i=0;i< countingArray.length;i++){
            if(countingArray[i] ==0){
                return i;
            }
        }
        return -1;
    }
}
