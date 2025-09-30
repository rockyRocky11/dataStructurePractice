package com.data.structures.practice.dynamicProgramming.bitMask;

import java.util.*;
public class KPartition {
}


class Solution {
    List<List<Integer>> res;
    Map<String, Boolean> memo ;
    int bit;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        memo = new HashMap<>();
        int n=nums.length;
        bit=0;
        int startValue=0;
        for(int i=0;i<n;i++){
            startValue+=nums[i];
            int nextBit = 1 << i ;
            bit=bit|nextBit;
        }
        res = new ArrayList<>();
        Arrays.sort(nums);
        // int startValue = nums[n-1];
        if(startValue%k !=0)return false;

        startValue = startValue/k;
        //for(int i=startValue;i>=0;i--){
        if(rec(nums, 0, 0,  k, 0, startValue, 0))return true;
        //  }
        return false;
    }

    public boolean rec(int[] nums, int idx, int sum, int k, int currBit, int targetSum, int matchCount){
        String key = currBit+"-"+sum+"-"+matchCount;
        if(memo.containsKey(key))return memo.get(key);

        if(matchCount == k){
            return bit == currBit;
        }

        for(int i = nums.length-1;i>=0;i--){
            int bitToCheck = 1<<i;
            if((bitToCheck  & currBit) !=0 || (nums[i]+sum )>targetSum )continue;
            //if(nums[i]+sum == targetSum){
            if(rec(nums, i+1, nums[i]+sum == targetSum?0:sum+nums[i], k, currBit|bitToCheck
                    , targetSum, nums[i]+sum == targetSum?matchCount+1: matchCount)) {
                memo.put(key, true);

                return true;
            }
            // }
        }
        memo.put(key, false);
        return false;

    }
}
