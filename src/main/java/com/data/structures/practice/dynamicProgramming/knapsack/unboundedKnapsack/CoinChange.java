package com.data.structures.practice.dynamicProgramming.knapsack.unboundedKnapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CoinChange {
    public static void main(String[] args) {

        //int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
       // int[] coins = {186,419,83,408};
        int[] coins = { 1,2,5};
      //  int amount = 9864;
       // int amount = 6249;
       int amount = 5;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeBottomUp(coins, amount));
    }
    static int changes=-1;
    public static int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount+1];
        memo[0] =0;
        Arrays.sort(coins);
        int res = dfs(coins,  amount,memo);
        return res == Integer.MAX_VALUE?-1:res ;
    }

    //Top DOwn recursion
    //Time O(CxAmount)
    private static int dfs(int[] coins, int rem, Integer[] memo) {
        if (rem < 0) return Integer.MAX_VALUE;      // No solution
        if (memo[rem] != null)                     // Already computed
            return memo[rem];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > rem) break;                  // No need to try larger coins
            int sub = dfs(coins, rem - coin, memo);
            if (sub != Integer.MAX_VALUE) {
                min = Math.min(min, sub + 1);
                System.out.println("Found match");
            }
        }

        memo[rem] = min;
        return min;
    }

    public static int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Fill with a large value (amount+1 is safe because max coins needed can’t exceed amount)
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // base case
        // Only in unbounded knapsack, iterate with the constraints first, because you are allowed to reuse the items
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}