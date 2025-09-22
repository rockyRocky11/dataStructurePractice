package com.data.structures.practice.dynamicProgramming.knapsack.subSetKnapsack;

public class LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }

    //time O(n* newTarget)
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int n : stones)
            sum += n;
        int newTarget = sum / 2;
        boolean[] dp = new boolean[newTarget + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = newTarget; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for (int i = newTarget; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
