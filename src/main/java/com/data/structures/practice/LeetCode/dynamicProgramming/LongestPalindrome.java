package com.data.structures.practice.LeetCode.dynamicProgramming;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
       System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("caba"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("ccd" ));

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
                r++;
                l--;
            }
            //System.out.println(r+" "+ l);
            //System.out.println(s.substring(l+1,r));
            return s.substring(l+1,r);
        }

    }

}
