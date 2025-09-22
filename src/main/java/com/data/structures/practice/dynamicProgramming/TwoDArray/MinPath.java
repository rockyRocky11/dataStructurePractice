package com.data.structures.practice.dynamicProgramming.TwoDArray;

public class MinPath {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum1DArray(grid));
    }
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] store = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    store[0][0] = grid[0][0];
                } else if (i == 0) {
                    // System.out.println("i==0");
                    store[i][j] = grid[i][j] + store[i][j - 1];
                } else if (j == 0) {
                    store[i][j] = grid[i][j] + store[i - 1][j];
                } else {
                    store[i][j] = grid[i][j] + Math.min(store[i - 1][j], store[i][j - 1]);
                }
                // System.out.println(store[i][j]);
            }
        }
        return store[n - 1][m - 1];

    }

    public static int minPathSum1DArray(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] store = new int[m];
        store[0]=grid[0][0];
        for(int i=1;i<m;i++){
            store[i]=store[i-1]+grid[0][i];//store all sum of the top row
        }
        for (int i = 1; i < n; i++) {
            store[0] += grid[i][0];
            for (int j = 1; j < m; j++) {

                store[j] = grid[i][j] + Math.min(store[j], store[j - 1]);//store[j]==top store[j-1] left

                // System.out.println(store[i][j]);
            }
        }
        return store[m - 1];

    }
}
