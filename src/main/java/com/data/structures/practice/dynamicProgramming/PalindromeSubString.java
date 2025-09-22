package com.data.structures.practice.dynamicProgramming;

public class PalindromeSubString {
    static int count =0;
    public static void main(String[] args) {
        //System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));

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

    public static int countSubstrings(String s) {
        count =0;
        String res = "";
        for (int start = 0; start < s.length(); start++) {
            String odd = getPalindrome(s, start, start);
            String even = getPalindrome(s, start, start + 1);
System.out.println("odd "+odd);
System.out.println("even "+even);
           // if(!odd.equals(""))count++;
            //if(!even.equals(""))count++;
        }
        return count;
    }

    public static String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;

            System.out.println(count);
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }


}
