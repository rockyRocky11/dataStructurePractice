package com.data.structures.practice.dynamicProgramming.machineState;

public class StockIV {
}

class SolutionStockIVDP {



    public int maxProfit(int k, int[] prices) {


        int n = prices.length;
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
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j][0] - prices[i]); // buy state

            }
        }

        int res = 0;
        for (int i = 0; i < k + 1; i++) {
            res = Math.max(res, dp[n - 1][i][0]);
        }

        return res;//return the last day sold state
    }
}
