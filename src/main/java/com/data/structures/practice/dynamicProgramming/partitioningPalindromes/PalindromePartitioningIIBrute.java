package com.data.structures.practice.dynamicProgramming.partitioningPalindromes;

public class PalindromePartitioningIIBrute {
    public static void main(String[] args) {
        String s = "aab";
        Solution solution = new Solution();
        System.out.println(solution.minCut(s));
    }
    }

    class Solution{
     int res;
    int n;
    boolean[][] dp;

    public int minCut(String s) {
        res = Integer.MAX_VALUE;
        n = s.length();
        dp = new boolean[n][n];
        backTrack(s, 0, 0);
        return res;
    }

    public void backTrack(String s, int idx, int count) {
        if (idx >= n) {
            // System.out.println("palindrome count "+count);
            res = Math.min(count - 1, res);
        }
        for (int i = idx; i < n; i++) {//Control partition
            if (i + 1 > n)
                continue;
            if (!isPlaindrome(s, idx, i ))
                continue;
            // System.out.println(s.substring(idx, idx+i)+" "+idx);
            //System.out.println(count);
            backTrack(s, i + 1, count + 1);

        }
    }

    public boolean isPlaindrome(String s, int a, int b) {System.out.print("her  ");
        System.out.println(s.substring(a, Math.min(b+1, n)));
        int i = a, j = b;
        if (dp[a][b])
            return dp[a][b];

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                dp[a][b] = false;
                return false;
            }
            i++;
            j--;
        }
        dp[a][b] = true;
        return true;
    }
}
