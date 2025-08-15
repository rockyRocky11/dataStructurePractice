package com.data.structures.practice.LeetCode.binarySearch;

import java.util.Arrays;

public class SsearchRangeLowerUpperBound {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        int lowerIndex=searchRangeLower(nums, target);
        int upperIndex=searchRangeUpper(nums, target)-1;
        res[0]=lowerIndex>=0&& lowerIndex< nums.length&& nums[lowerIndex]==target?lowerIndex:-1;
        res[1]=upperIndex>=0&& upperIndex< nums.length&& nums[upperIndex]==target?upperIndex:-1;
        return res;
    }

    public static int searchRangeLower(int[] nums, int target) {
        int lefft=0;
        int right=nums.length;
        while(lefft<right){
            int mid = (lefft+right)/2;
            if(target<=nums[mid]){
                right=mid;
            }else{
                lefft=mid+1;
            }
        }
        return lefft;
    }

    public static int searchRangeUpper(int[] nums, int target) {
        int lefft=0;
        int right=nums.length;
        while(lefft<right){
            int mid = (lefft+right)/2;
            if(target<nums[mid]){
                right=mid;
            }else{
                lefft=mid+1;
            }
        }
        return lefft;
    }
}
