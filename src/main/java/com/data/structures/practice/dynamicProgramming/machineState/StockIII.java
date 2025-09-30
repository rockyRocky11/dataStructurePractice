package com.data.structures.practice.dynamicProgramming.machineState;

import java.util.Arrays;

public class StockIII {

    public static void main(String[] args) {

        //int[] prices = {3,3,5,0,0,3,1,4};//6
        int[] prices = {1, 2, 3, 4, 5};//4
        SolutionBottomUpWithTransactionAndHoldFlag solution = new SolutionBottomUpWithTransactionAndHoldFlag();
        System.out.println(solution.maxProfit(prices));
    }

}

class SolutionBottomUpWithTransactionAndHoldFlag {
    int[][][] dp;
    int n;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][0][0] = 0;//no  buy no profit
        dp[0][0][1] = -prices[0]; // buy
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = Integer.MIN_VALUE; // at first index we can sell yet
            dp[0][i][1] = Integer.MIN_VALUE; // impossible
        }


        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <=k; j++) {
                if(j==0){
                    dp[i][j][0] = dp[i - 1][j][0];//nothing state
                }else{
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);//sell
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]); // hold or buy state

            }
        }

        int res = 0;
        for (int i = 0; i <=k ; i++) {
            res = Math.max(res, dp[n - 1][i][0]);
        }

        return res;//return the last day sold state
    }
}


class Solution {
    int[][][] dp;
    int n;

    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2][2];

        // Fill with -1
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                Arrays.fill(dp[i][t], -1);
            }
        }
        return rec(prices, 0, 0, 0);
        //System.out.println("sd");
        //return dp[n-1][1][1];

    }

    public int rec(int[] prices, int i, int t, int h) {
        // System.out.println(i);
        if (t > 1 || i == n)
            return 0;
        // if (dp[i][t][h] != -1)
        //   return dp[i][t][h];
        if (h == 0) {
            //When not holding you can either buy or rest
            int rest = rec(prices, i + 1, t, 0);
            int buy = rec(prices, i + 1, t, 1) - prices[i];// h==0 you can't buy new stock until u sell what you are holding
            dp[i][t][h] = Math.max(rest, buy);
            System.out.println(" i:" + i + " res:" + dp[i][t][h] + " t:" + t);
            return dp[i][t][h];
        } else {
            //When  holding you can either sell or rest
            int rest = rec(prices, i + 1, t, 1);
            int sell = rec(prices, i + 1, t + 1, 0) + prices[i];// you can't buy new stock until u sell what you are holding
            dp[i][t][h] = Math.max(rest, sell);
            System.out.println(" i:" + i + " res:" + dp[i][t][h] + " t:" + t);
            return dp[i][t][h];
        }
    }
}