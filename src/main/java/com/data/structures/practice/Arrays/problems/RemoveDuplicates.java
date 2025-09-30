package com.data.structures.practice.Arrays.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        //System.out.println(twoPointer(nums));
        //System.out.println(countUnique(nums1));
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(nums1));

    }

    private static int twoPointer(int[] nums) {
        int uniqueCounter = 0;
        int preValue = 0;
        for (int k = 0; k < nums.length; k++) {
            if(k==0){
                uniqueCounter++;
                preValue=nums[k];
            }
            else if(preValue !=nums[k]){
                nums[uniqueCounter++]=nums[k];
                preValue=nums[k];
            }
        }
        return uniqueCounter;
    }

    private static int countUnique(int[] nums) {
        Map<Integer, Integer> uniqueMap = new HashMap<>();
        int uniqueCounter = 0;
        int counter = 0;
        int[] uniqueArray = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            if (!uniqueMap.containsKey(nums[k])) {
                uniqueCounter++;
                uniqueMap.put(nums[k], nums[k]);
                uniqueArray[counter++]=nums[k];
            }
        }
        System.arraycopy(uniqueArray,0, nums,0,counter);
        return uniqueCounter;
    }
    private static int removeElement(int[] nums, int element) {
        int uniqueCounter = 0;
        for (int k = 0; k < nums.length; k++) {
             if(element !=nums[k]){
                nums[uniqueCounter++]=nums[k];
            }
        }
        return uniqueCounter;
    }

}
