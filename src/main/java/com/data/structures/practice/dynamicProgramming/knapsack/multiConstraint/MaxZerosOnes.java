package com.data.structures.practice.dynamicProgramming.knapsack.multiConstraint;

public class MaxZerosOnes {

    /*✅ Summary

    Time: O(len * m * n)

    Space: O(m * n)*/
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] count = new int[len][2];
        int idx = 0;
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    zeros++;
                if (c == '1')
                    ones++;
            }
            count[idx][0] = zeros;
            count[idx][1] = ones;
            idx++;
        }

        int[][] dp = new int[m + 1][n + 1];

        // For 0/1 Knapsack we need to iterate with the values, only for unbounded iterate with the target/constraint
        for (int k = 0; k < count.length; k++) {
            int zeros = count[k][0];
            int ones = count[k][1];
            // In knapsack problems we start with the max
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    if (zeros <= i && ones <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
