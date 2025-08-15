package com.data.structures.practice.LeetCode.dynamicProgramming;

public class LongestPalindromeSubseq3 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestCommonSubsequenceBottomUpMemo("bbbab"));
       // System.out.println(longestPalindromeSubseqBottom("bbbab"));
       //System.out.println(longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));

    }

    /*✅ Summary Table
    Aspect	Current Code	Recommended DP Approach
    Correctness	Center-based → may miss LPS	Full-range recursion → correct
    Time	O(n²)	O(n²)
    Space	O(n²) + recursion	O(n²) + recursion
    Simplicity	More complex	Cleaner and more direct*/
    public static int longestPalindromeSubseq(String s) {
        int res = 0;
        Integer[][] dp = new Integer[s.length() + 1][s.length() + 1];
        for (int start = 0; start < s.length(); start++) {
            int odd = dfs(s, start, start, dp);
            int even = dfs(s, start, start + 1, dp);
            int temp = Math.max(odd, even);
            res = Math.max(temp, res);
        }
        return res;
    }

    public static int dfs(String s, int i, int j, Integer[][] dp ) {

        if(i<0 || j >= s.length()){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j]=(i==j?1:2)+dfs(s, i-1, j+1, dp);
        }else{
            dp[i][j]=Math.max(dfs(s, i-1, j, dp),dfs(s, i, j+1, dp));
        }

        return dp[i][j];

    }

    public static int longestCommonSubsequenceBottomUpMemo(String s) {
        StringBuilder sb = new StringBuilder(s);
        String text2 =sb.reverse().toString();

        int[][] dp = new int[s.length()+1][text2.length()+1];

        for(int i=1;i< s.length()+1;i++){
            for(int j=1;j< text2.length()+1;j++){
                if(s.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][text2.length()];
    }

   /* public static int longestPalindromeSubseqBottom1(String s) {
        int res = 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 2;
                    }
                    if (i - 1 >= 0 && j + 1 < s.length()) {
                        dp[i][j] += dp[i - 1][j + 1];
                    }
                } else {
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j + 1 < s.length()) {
                        dp[i][j] += Math.max(dp[i][j], dp[i][j + 1]);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
    }


        public static int longestPalindromeSubseqBottom(String s) {
        int n= s.length();
        int[][] dp = new int[s.length() ][s.length() ];
        for (int i = n-1; i <=0; i--) {
            dp[i][i]=1;
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                        dp[i][j]=dp[i+1][j-1]+2;

                }else{
                        dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);

                }
            }
        }
        return dp[0][n-1];
    }*/



}
