package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.util.*;

public class PartitionEqualSubsetSum {

    static List<Integer> d = new ArrayList<>();
    static boolean canPartition = false;

    public static void main(String[] args) {
        canPartition = false;
        int[] nums = {1, 5, 11, 5};//true
        //int[] nums ={1,2,3,5};
        //int[] nums ={1,2,5};
        // int[] nums ={1,1};
        //int[] nums = {100, 100, 100, 100, 100, 100, 100, 100};
        System.out.println(canPartition(nums));
        System.out.println(canPartitionMemo(nums));
        System.out.println(canPartitionBottomUp(nums));

    }

    // Time Comp: 2^n

    public static boolean canPartition(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        canPartitionRec(nums, 0, target / 2);
        return canPartition;
    }

    public static void canPartitionRec(int[] nums, int i, int target) {

        if (target < 0) {
            return;
        }
        if (i >= nums.length) {
            if (target == 0) {
                canPartition = true;

            }
            return;
        }
        canPartitionRec(nums, i + 1, target - nums[i]);
        canPartitionRec(nums, i + 1, target);

    }


    /*⏱ Time and Space Complexity
        Metric	Value
        Time	O(n * sum/2)
        Space (memo)	O(n * sum/2)
        Call stack	O(n)*/
    //Idea here is to store wether its possible to reach the sum at each index level and current sum
    public static boolean canPartitionMemo(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[nums.length][target];
        return canPartitionRecMemo(nums, 0, target / 2, dp);
    }

    public static boolean canPartitionRecMemo(int[] nums, int i, int target, Boolean[][] dp) {
        if (target < 0) {
            return false;
        }
        if (i >= nums.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (dp[i][target] != null && dp[i][target]) {
            return true;
        }

        boolean include = canPartitionRecMemo(nums, i + 1, target - nums[i], dp);
        boolean exclude = canPartitionRecMemo(nums, i + 1, target, dp);

        dp[i][target] = include || exclude;
        return dp[i][target];
    }

    public static boolean canPartitionBottomUpSet(int[] nums) {

        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        target = target / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        dp.add(nums[nums.length - 1]);

        for (int i = nums.length - 2; i > 0; i--) {
            List<Integer> tempList = new ArrayList<>();
            for (int sum : dp) {
                int temp = sum + nums[i];
                if (!dp.contains(temp)) {
                    tempList.add(temp);
                }
            }
            for (int newSumL : tempList) {
                dp.add(newSumL);
            }

        }
        if (dp.contains(target)) {
            return true;
        }
        return false;
    }
        /*
            ✅ Time & Space Complexity
            Metric	Value
            Time	O(n * target)
            Space	O(target)

            Much more efficient than the Set + List combination.*/

    /*✅ Why This Works
    This uses classic subset sum DP:

    Each time we add a number, we update which totals are reachable.

    The array dp[i] will be true if we can reach sum i with some subset.*/
    public static boolean canPartitionBottomUp(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        // If total sum is odd, can't split equally
        if (total % 2 != 0) return false;

        int target = total / 2;

        // dp[i] = true if a subset sums to 'i'
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // base case

        for (int num : nums) {
            // Traverse backwards to avoid using the same num twice
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }


}
