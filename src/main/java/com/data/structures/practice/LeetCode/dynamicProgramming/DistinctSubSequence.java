package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubSequence {
    public static void main(String[] args) {
            String s = "rabbbit", t = "rabbit";
        //String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s, t));
        System.out.println(numDistinctMemo(s, t));
        System.out.println(numDistinctMemoBottomUp(s, t));
    }

    public static int numDistinct(String s, String t) {

        return dfs(s, t, 0, "");
    }

    public static int dfs(String s, String t, int i, String newString) {
        if (newString.equals(t)) return 1;
        if (i >= s.length() || s.length() < t.length()) {

            return 0;
        }
        //System.out.println(newString);


        String temp = newString + s.charAt(i);
        int include = dfs(s, t, i + 1, temp);
        int exclude = dfs(s, t, i + 1, newString);
        return include + exclude;

    }

    public static int numDistinctMemo(String s, String t) {
        Integer[][] dp = new Integer[s.length()+1][t.length()+1];
        int res = dfsMemo(s, t, 0, 0,  dp);
        return res;
    }

    public static int dfsMemo(String s, String t, int i,int j, Integer[][] dp) {
        if(dp[i][j] != null)return dp[i][j];
        if (j == t.length()){
            //System.out.println(i+","+j);
            return 1;
        }
        if (i >= s.length()) {
            return 0;
        }
        int total=0;
        if( s.charAt(i) == t.charAt(j)){
            total+= dfsMemo(s, t, i + 1, j+1, dp);

        }
        total+= dfsMemo(s, t, i +1, j, dp);

        //int total = include + exclude;
        dp[i][j] = total;
        return total;

    }

   /* 🧠 Time and Space Complexity
    Time: O(m * n) — nested loops over s and t

    Space: O(m * n) — 2D DP table

*/
    public static int numDistinctMemoBottomUp(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][n]=1;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int total=0;
                if(s.charAt(i) == t.charAt(j)){
                    total+=dp[i+1][j+1];
                }
                    total+=dp[i+1][j];

                dp[i][j]=total;
            }
        }
        return dp[0][0];
    }
}
