package com.data.structures.practice.dynamicProgramming.interval;

import java.util.Arrays;

public class PolygonTriangle {
    public static void main(String[] args) {
        int[] values ={3,7,4,5};
        SolutionPolygonTriangle solutionPolygonTriangle = new SolutionPolygonTriangle();
        SolutionPolygonTriangleBottomUp solutionPolygonTriangleBottomUp = new SolutionPolygonTriangleBottomUp();
        System.out.println(solutionPolygonTriangle.minScoreTriangulation(values));
        System.out.println(solutionPolygonTriangleBottomUp.minScoreTriangulation(values));
    }
}

class SolutionPolygonTriangle {
    int[][] dp ;
    public int minScoreTriangulation(int[] values) {

        int n = values.length;
        dp = new int[n][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return rec(values, 0, n-1);
    }

   /* ⏱️ Complexity

    Time: O(n^3) (for each interval [i,j], we try all k)

    Space: O(n^2) for DP table*/

    public int rec(int[] values, int i, int j){
        System.out.print(" interval i="+i+" j="+j);
        if(j-i<2)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int minScore = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            System.out.print("  K="+k);
            System.out.print(" For i="+i+" k "+k+" j="+j);
            int score = values[i]*values[k]*values[j];
            score+=rec(values, i, k)+rec(values, k, j);
            minScore = Math.min(minScore, score);
        }
        dp[i][j] = minScore;
        //System.out.print(" minScore="+minScore);
        System.out.println();
        return minScore;
    }
}

class SolutionPolygonTriangleBottomUp {
    int[][] dp ;

    //👉 Total = O(n³).
    public int minScoreTriangulation(int[] values) {

        int n = values.length;
        dp = new int[n][n];
        // intervals shorter than 2 → already 0 (default initialization)
        //int[] values ={3,7,4,5};
        // build intervals by increasing length
        for(int len=2;len<n;len++){// interval length
            for(int i=0;i+len<n;i++){
                int j=i+len;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    //dp[i][j]=i≤k<jmin​(dp[i][k]+dp[k+1][j]+cost(i,j,k))
                    dp[i][j]=Math.min(dp[i][j], (values[i]*values[k]*values[j]+dp[i][k]+dp[k][j]));
                }
            }
        }
        return dp[0][n-1];
    }


}
