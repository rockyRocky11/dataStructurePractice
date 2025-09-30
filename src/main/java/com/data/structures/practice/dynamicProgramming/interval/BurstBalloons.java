package com.data.structures.practice.dynamicProgramming.interval;

import java.util.Arrays;

public class BurstBalloons {
}

class SolutionBottomUp {
    int[][] dp;
    int[] arr;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n + 2][n + 2];
        arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;
        //for (int i = 0; i < n; i++) {
        //  arr[i + 1] = nums[i];
        //}
        System.arraycopy(nums, 0, arr, 1, n);
        for(int len=2;len<n+2;len++){//run interval all the way to end of array
            for(int i=0;i+len<n+2;i++){
                int j= i+len;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j], (dp[i][k]+dp[k][j]+(arr[i]*arr[j]*arr[k])));
                }

            }
        }
        return dp[0][n+1];
    }
}

class SolutionRec {
    int[][] dp;
    int[] arr;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n + 2][n + 2];
        arr = new int[n + 2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        return rec(arr, 0, n +1);
    }

    public int rec(int[] nums, int i, int j) {
        //System.out.println("i " + i + " j " + j);
        if (i + 1 == j) {
            //System.out.println("exit");
            return 0;
        }

        if(dp[i][j]!=-1)return dp[i][j];
        int maxCoins = Integer.MIN_VALUE;

        for (int k = i + 1; k < j; k++) {
            int coins = nums[i] * nums[k] * nums[j];
            int left = rec(nums, i, k);
            int right = rec(nums, k, j);
            coins += left + right;
            maxCoins = Math.max(maxCoins, coins);
        }
        dp[i][j] = maxCoins;
        return maxCoins;
    }
}
