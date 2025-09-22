package com.data.structures.practice.dynamicProgramming.TwoDArray;

public class UniquePath {
    static int count = 0;

    public static void main(String[] args) {
        int m = 23, n = 12;//193536720
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePathsRecursion(int m, int n) {

        int[][] matrix = new int[m][n];
        dfsRecursion(0, 0, matrix);
        return count;
    }

    public static void dfsRecursion(int m, int n, int[][] matrix) {

        if(m<0 || n<0|| m>= matrix.length || n>= matrix[0].length|| matrix[m][n] ==1){
            return;
        }
        matrix[m][n]=1;
        if(m==matrix.length-1 && n==matrix[0].length-1){
            count++;
            matrix[m][n]=0;
            return;
        }
        dfsRecursion(m+1, n, matrix);//down
        //dfs(m-1, n, matrix);//up
        dfsRecursion(m, n+1, matrix);//right
        //dfs(m, n-1, matrix);//left
        matrix[m][n]=0;
    }

    public static int uniquePaths(int m, int n) {
        int[][] store = new int[m][n];

        return bottomUPTabulation(m, n, store);
        //return count;
    }

    public static int bottomUPTabulation(int m, int n, int[][] store) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    store[i][j] = 1;
                } else {
                    store[i][j] = store[i][j - 1] + store[i - 1][j];
                }
            }
        }
        return store[m - 1][n - 1];
    }
}
