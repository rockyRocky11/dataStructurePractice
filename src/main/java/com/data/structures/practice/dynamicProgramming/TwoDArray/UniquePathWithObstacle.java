package com.data.structures.practice.dynamicProgramming.TwoDArray;

public class UniquePathWithObstacle {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};//2
        //int[][] obstacleGrid = {{0,1},{0,0}};
        //int[][] obstacleGrid = {{1,0}};
        //int[][] obstacleGrid = {{0},{0}};
        //int[][] obstacleGrid = {{0, 1, 0, 0}};//0
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int[][] store = new int[obstacleGrid.length][obstacleGrid[0].length];
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] != 1) {
                store[0][0] = 1;
            }

            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] != 1) {
                    store[i][0] = store[i-1][0];
                }
            }
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[0][i] != 1) {
                    store[0][i] =  store[0][i-1];
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }
                    store[i][j] = store[i][j - 1] + store[i - 1][j];

                }
            }
            return store[m - 1][n - 1];
        }

}
