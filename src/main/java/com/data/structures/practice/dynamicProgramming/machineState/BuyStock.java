package com.data.structures.practice.dynamicProgramming.machineState;

import java.util.Arrays;

public class BuyStock {
    public static void main(String[] args) {
        int[] d={7,1,5,3,6,4};
        SolutionBottomUp  solutionBottomUp = new SolutionBottomUp();
        System.out.println(solutionBottomUp.maxProfit(d));
    }
}
class SolutionGreeedy {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;

        for(int i= 1;i<prices.length;i++){
            int currentProfit = prices[i]-buyPrice;
            if(prices[i]<buyPrice){
                buyPrice = prices[i];
                //maxProfit=currentProfit;

            }
            maxProfit=Math.max(maxProfit,currentProfit);

        }
        return Math.max(maxProfit, 0);
    }
}

class SolutionBottomUp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        dp[0][0][0] = 0;//no  buy no profit
        dp[0][0][1] = -prices[0]; // buy
        dp[0][1][0] = 0; // at first index we can sell yet
        dp[0][1][1] = Integer.MIN_VALUE; // impossible

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = dp[i-1][0][0];//nothing state
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0]-prices[i]);//buy state
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]+prices[i]);//sell
            dp[i][1][1] = Integer.MIN_VALUE; // impossible
        }
        return Math.max(dp[n-1][0][0], dp[n-1][1][0]);//return the last day sold state
    }
}

class SolutionDPShortCutOptimized {
    public int maxProfit(int[] prices) {
        int sold = 0;
        int hold = -prices[0];

        for(int i= 1;i<prices.length;i++){
            sold = Math.max(sold, hold+prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return sold;
    }
}

class SolutionBottomUpShortCut {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;//sold state
        dp[0][1] = -prices[0]; // hold state

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);//sold rest tranision
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);//hold buy tranision
        }
        return dp[n-1][0];//return the last day sold state
    }
}

class SolutionRec {
    public int maxProfit(int[] prices) {

        return rec(prices, 0, 0, 0);
    }

    public int rec(int[] prices, int i, int t, int h) {
        // System.out.println(s);
        if (t > 0 || i == prices.length)
            return 0;
        if (h == 0) {
            //When not holding you can either buy or sell
            int rest = rec(prices, i + 1, t, 0);
            int buy = rec(prices, i + 1, t, 1) - prices[i];
            return Math.max(rest, buy);
        } else {
            int rest = rec(prices, i + 1, t, 1);
            int sell = rec(prices, i + 1, t + 1, 0) + prices[i];
            return Math.max(rest, sell);
        }
    }

}

class SolutionRecMemo {
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
        System.out.println(i);
        if (t > 1 || i == n)
            return 0;
        // if (dp[i][t][h] != -1)
        //   return dp[i][t][h];
        if (h == 0) {
            //When not holding you can either buy or sell
            int rest = rec(prices, i + 1, t, 0);
            int buy = rec(prices, i + 1, t, 1) - prices[i];// h==0 you can't buy new stock until u sell what you are holding
            dp[i][t][h]= Math.max(rest, buy);
            // System.out.println(" i:"+i+" res:"+ dp[i][t][h]+" t:"+t);
            return dp[i][t][h];
        } else {
            int rest = rec(prices, i + 1, t, 1);
            int sell = rec(prices, i + 1, t + 1, 0) + prices[i];// you can't buy new stock until u sell what you are holding
            dp[i][t][h] = Math.max(rest, sell);
            // System.out.println(" i:"+i+" res:"+ dp[i][t][h]+" t:"+t);
            return  dp[i][t][h];
        }
    }
}