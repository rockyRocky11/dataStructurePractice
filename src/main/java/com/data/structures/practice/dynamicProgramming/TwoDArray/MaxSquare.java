package com.data.structures.practice.dynamicProgramming.TwoDArray;

import java.util.Arrays;

public class MaxSquare {
    static int res;

    public static int maximalSquare(char[][] matrix) {
        res = -1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dfs(matrix, i, j, dp);
            }
        }
        return res < 0 ? 0 : res * res;
    }

    public static int dfs(char[][] matrix, int row, int col, int[][] dp) {
        if (!isExist(matrix, row, col))
            return 0;
        if (dp[row][col] !=-1)
            return dp[row][col];
        int right = dfs(matrix, row, col + 1, dp);
        int down = dfs(matrix, row + 1, col, dp);
        int dia = dfs(matrix, row + 1, col + 1, dp);

        dp[row][col] = 1 + Math.min(right, Math.min(down, dia));
        res = Math.max(dp[row][col], res);
        return dp[row][col];
    }

    public static boolean isExist(char[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || matrix[row][col] == '0')
            return false;
        return true;
    }

    public static int maximalSquareBottomUp(char[][] matrix) {
        res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int dia = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;

                    dp[i][j] = 1 + Math.min(left, Math.min(up, dia));
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return  res * res;
    }

    public static int maximalSquareRollingArray(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];// row above, used for up and dia
        int[] curr = new int[n];//curr row, used for left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if(i==0 || j ==0){
                        curr[j]=1;
                    }else{
                        curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j-1]));
                    }
                    res = Math.max(curr[j], res);
                }else{
                    curr[j]=0;
                }
            }
            int[] temp =prev;
            prev= curr;
            curr = temp;
        }
        return res * res;
    }
}
