package com.data.structures.practice.dynamicProgramming.partitioningPalindromes;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        String s = "aab";
        SolutionI solutionI = new SolutionI();
        System.out.println(solutionI.minCut(s));

    }
}

    class SolutionI{

    int n;
    boolean[][] dp;
    int[] cuts;

    public int minCut(String s) {
        n = s.length();
        dp = new boolean[n][n];
        cuts = new int[n];

        for (int i = 0; i < n; i++) {
            cuts[i] = Integer.MAX_VALUE;
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        //dp method
        for(int i=0;i<n;i++){

            if(dp[0][i]){
                cuts[i]=0;
            }else{
                for(int j=0;j<i;j++){
                    if(dp[j+1][i]){
                        cuts[i]=Math.min(cuts[i], cuts[j]+1);
                    }
                }
            }

        }

        return cuts[n-1];
    }

    public int backTrack(String s, int idx, int count) {

        if (idx >= n) {
            return -1;
        }
        if (cuts[idx] != Integer.MAX_VALUE)
            return cuts[idx];
        int minCut = Integer.MAX_VALUE;
        for (int i = idx; i < n; i++) {

            if (!dp[idx][i])
                continue;
            minCut = Math.min(minCut, backTrack(s, i + 1, count + 1) + 1);

        }
        cuts[idx]=minCut;
        return minCut;
    }
}
