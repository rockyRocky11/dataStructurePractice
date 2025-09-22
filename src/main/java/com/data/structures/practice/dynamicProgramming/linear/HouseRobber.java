package com.data.structures.practice.dynamicProgramming.linear;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {


        /*In this example, when we encountered the frst house by deafult its choosen, since its the first house. Then when the next house comes, we compare with the first and pick the maximum one.
        So, now the memo has only the first house with 5 both index 0 and 1. When we pick the third house, we need to decide whether to pick or not, if you pick then add to the 0 index in the memo.
        why is that? because memo 0 is non adjacent house for index nums[2], if pick we are not pick then memo[i-1], why is that? because if the nums[i-1] is larger value, then it would have been stored in memo[i-1].*/
        int[] nums = {5, 3, 10, 10, 15, 7, 20};// Excepted result = 50
        System.out.println(rob(nums));
        System.out.println(robConstantSpace(nums));
        System.out.println(robRec(nums));
        System.out.println(robRecMemo(nums));
    }


    // This is ineffcient
    // Time: O(2^n) --> 2 options and need to repeat it to length of array
    // Space O(n)
    public static int robRec(int[] nums) {
        return robRecursion(nums, nums.length - 1);

    }

    public static int robRecursion(int[] nums, int i) {

        if (i == 0) {
            return nums[0];
        }
        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(nums[i]+robRecursion(nums,i-2), robRecursion(nums, i-1));
    }

    public static int robRecMemo(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        return robRecursionMemo(nums, nums.length - 1, memo);

    }

    public static int robRecursionMemo(int[] nums, int i, int[] memo) {

        if(i<0){
            return 0;
        }

        if (memo[i] !=-1) {
            return memo[i];
        }
        int res =Math.max(nums[i]+robRecursionMemo(nums,i-2, memo), robRecursionMemo(nums, i-1, memo));
        memo[i] = res;
        return res;
    }

    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] memo = new int[nums.length + 1];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }

        return memo[nums.length - 1];
    }

    public static int robConstantSpace(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prevPrevAmount = nums[0];
        int prevAmount = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] + prevPrevAmount > prevAmount) {
                int temp = prevAmount;
                prevAmount = nums[i] + prevPrevAmount;
                prevPrevAmount = temp;
            } else {
                prevPrevAmount = prevAmount;

            }
        }

        return prevAmount;
    }
}
