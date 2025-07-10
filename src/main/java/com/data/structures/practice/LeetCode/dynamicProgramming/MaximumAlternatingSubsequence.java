package com.data.structures.practice.LeetCode.dynamicProgramming;

public class MaximumAlternatingSubsequence {

    static long res = 0;
    public static void main(String[] args) {

        int[] nums = {4,2,5,3};
        //int[] nums = {5,6,7,8};
        //int[] nums = {6,2,1,2,4,5};
        System.out.println(maxAlternatingSum(nums));
        System.out.println(maxAlternatingSumRecuMemo(nums));
    }

    public static long maxAlternatingSum(int[] nums) {
        res = 0;
        maxAlternatingSumRec(nums,  true,  0,  0);
        return res;
    }

    public static void maxAlternatingSumRec(int[] nums, boolean add, int i, int sum) {

        if(i>= nums.length){
            res = Math.max(res, sum);
            return;
        }
        maxAlternatingSumRec(nums,  !add,  i+1,  add?sum+nums[i]:sum-nums[i]);
        maxAlternatingSumRec(nums,  add,  i+1,  sum);
    }
        /*

                    | Metric        | Value           |
                    | ------------- | --------------- |
                    | Time          | O(n × 2) = O(n) |
                    | Space (stack) | O(n)            |
                    | Space (memo)  | O(n × 2)        |
        */

    public static long maxAlternatingSumRecuMemo(int[] nums) {
        Long[][] dp = new Long[nums.length][2];
        return maxAlternatingSumRecMemo(nums,  0,  0,  dp);
    }

    public static long maxAlternatingSumRecMemo(int[] nums, int add, int i, Long[][] dp) {

        if(i>= nums.length){
            return 0;
        }
        if(dp[i][add] !=null){
            return dp[i][add];
        }
        long include =  (add ==0?nums[i]:-nums[i])+maxAlternatingSumRecMemo(nums,  add==0?1:0,  i+1,  dp);
        long exclude = maxAlternatingSumRecMemo(nums,  add,  i+1,  dp);

        return dp[i][add]=Math.max(include, exclude);
    }
}
