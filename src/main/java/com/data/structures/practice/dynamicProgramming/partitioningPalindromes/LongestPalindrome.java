package com.data.structures.practice.dynamicProgramming.partitioningPalindromes;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeDPMethod("abba"));
        System.out.println(longestPalindrome("cbbd"));
       System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("caba"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("ccd" ));

    }

    /*⏱️ Complexity

    Time: O(n^2) — checking all substrings.

            Space: O(n^2) for DP table.*/

    public static String longestPalindromeDPMethod(String s) {
        int n = s.length();
        if (n <= 1) return s;

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // Base case: single characters
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Base case: length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // General case: length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    //Idea here for checking palindrome substring is take each index and consider as middle and expand outwards,
    //do the same for even with two index
    /*
            | Metric               | Your Recursive             | Iterative                 |
            | -------------------- | -------------------------- | ------------------------- |
            | Time (theoretical)   | O(n²), worse for large `n` | O(n²), faster in practice |
            | Memory (LeetCode)    | Similar                    | Similar                   |
            | Stack Space          | O(n)                       | O(1)                      |
            | Practical difference | ⚠️ May TLE for large `n`   | ✅ More stable             |
*/

    public static String longestPalindrome(String s) {
        String res = "";
        for (int start = 0; start < s.length(); start++) {
            String odd = getPalindrome(s, start, start);
            System.out.println("odd "+odd);
            String even = getPalindrome(s, start, start + 1);
            System.out.println("even "+even);
            String temp = (odd.length() > even.length()) ? odd : even;
            if (temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }

    public static String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

//My recursive is faster but it takes O(n) space
    class Solution {
        public static String longestPalindrome(String s) {
            return longestPalindrome1( s, 0);
        }
        public static String longestPalindrome1(String s, int start) {
            if(start >= s.length()){
                return "";
            }
            String odd = getPalindrome(s,start, start );
            String even = getPalindrome(s,start, start+1 );
            String nextSubString = longestPalindrome1(s, start+1);
            String temp = odd.length()>even.length()?odd:even;
            return nextSubString.length() >temp.length()?nextSubString:temp;

        }
        public static String getPalindrome(String s, int l, int r){
            while(l>=0 && r<s.length() && s.charAt(r) == s.charAt(l)){
                r++;//Expanding towards right
                l--;//expanding towards left
            }
            //System.out.println(r+" "+ l);
            //System.out.println(s.substring(l+1,r));
            return s.substring(l+1,r);
        }

    }

}
