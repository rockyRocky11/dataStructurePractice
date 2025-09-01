package com.data.structures.practice.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {

    //Time O(n)
    /*✅ So your statement is correct:
    If a remainder matches, it means we’ve found a subarray (between the first occurrence of that remainder and the current index) whose sum is divisible by k.*/
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> p = new HashMap<>();
        p.put(0, -1);
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem = sum%k;
            if(p.containsKey(rem)){
                if(i-p.get(rem)>1)return true;
            }else{
                p.put(rem, i);
            }
        }
        return false;
    }
}
