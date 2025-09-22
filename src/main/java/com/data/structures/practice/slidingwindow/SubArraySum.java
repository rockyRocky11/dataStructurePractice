package com.data.structures.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
                int k = 2;
                /*int[] nums = {1,2,3};
                int k = 3;*/
               /* int[] nums = {-1,-1,1};
                int k = 1;*/
                System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {

        int i=0;
        int n =nums.length;
        int sum=0;
        int res=0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        while(i<n){
            sum+=nums[i];
            if(prefixSum.containsKey(sum-k)){
                res+=prefixSum.get(sum-k);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1);
            i++;
        }
        return res;
    }
}
