package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CoinChangeII {
    public static void main(String[] args) {

        //int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
       // int[] coins = {186,419,83,408};
        int[] coins = { 1,2,5};
      //  int amount = 9864;
       // int amount = 6249;
       int amount = 5;
        //System.out.println(coinChange(coins, amount));
        System.out.println(change( amount, coins));
        //System.out.println(coinChangeBottomUpMemo(coins, amount));
    }
    static int changes = 0;
    public static int change( int amount, int[] coins) {
        changes = 0;
        Arrays.sort(coins);
        List<Integer> change = new ArrayList();
        recursionBackTrack(change, coins, amount, coins.length - 1);
        return changes;
    }

    public static void recursionBackTrack(List<Integer> change, int[] coins, int amount, int currentCoinIndex) {
        if (amount < 0 ) {
            return;
        }
        if (amount == 0) {
            changes++;
            return;
        }

        int i = currentCoinIndex;
        while (i >=0) {
            change.add(coins[i]);
            recursionBackTrack(change, coins, amount - coins[i], i);
            change.remove(change.size()-1);
            i--;
        }
    }
    //static int changes=-1;
    public static int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount+1];
        memo[0] =0;
        Arrays.sort(coins);
        int res = dfs(coins,  amount,memo, 0);
        return res == Integer.MAX_VALUE?-1:res ;
    }

    //Top DOwn recursion
    //Time O(CxAmount)
    private static int dfs(int[] coins, int rem, Integer[] memo, int currIndex) {
        if (rem < 0) return Integer.MAX_VALUE;      // No solution
        if (memo[rem] != null)                     // Already computed
            return memo[rem];

        int min = Integer.MAX_VALUE;
        for (int i=currIndex;i<coins.length; i++) {
            int coin = coins[i];
            if (coin > rem) break;                  // No need to try larger coins
            int sub = dfs(coins, rem - coin, memo, i);
            if (sub != Integer.MAX_VALUE) {
                min = Math.min(min, sub + 1);
                System.out.println("Found match");
            }
        }

        memo[rem] = min;
        return min;
    }

    public static int coinChangeBottomUpMemo(int[] coins, int amount) {
        Arrays.sort(coins);
        Integer[] memo = new Integer[amount + 1];
        memo[0] = 0;
        int totalNoOfWays=0;
        for (int i = 1; i < amount + 1; i++) {
            int minn = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                int currSum = i - coin;
                if (currSum >= 0 && memo[currSum] != null && memo[currSum] != Integer.MAX_VALUE) {
                    minn = Math.min(memo[currSum] + 1, minn);
                }
            }
            memo[i]=minn;
        }
        return totalNoOfWays;
    }

}