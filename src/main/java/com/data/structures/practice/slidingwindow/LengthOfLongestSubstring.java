package com.data.structures.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
    String s = "abcabcbb";
    //String s = "abba";
    System.out.println(lengthOfLongestSubstring(s));
    System.out.println(lengthOfLongestSubstringUsingLastIndex(s));
    System.out.println(lengthOfLongestSubstring2(s));
    }

    /*✅ Final Verdict:
    Your implementation is correct, efficient, and uses sliding window perfectly.

    Time complexity: O(n)
    Each character is visited at most twice (once when expanding, once when shrinking).

    Space complexity: O(1)
    Because the store array size is constant (128 or 256).*/
    public static int lengthOfLongestSubstring(String s) {

        int res = 0;
        int start = 0;
        int end =0;
        int n = s.length();
        int[] store = new int[200];
        while(start <n && end <n){
            while(store[s.charAt(end)] ==1){

                store[s.charAt(start)] =0;
                start++;
            }
            store[s.charAt(end)]=1;
            end++;
            res = Math.max(res, (end-start));
        }
        return res;
    }

    public static int lengthOfLongestSubstringUsingLastIndex(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLength = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start) {
                start = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

   /* ⏱ Time and Space Complexity
    Time: O(N)
    Every character is processed once.

    start only moves forward — total work is linear.

    Space: O(1)
    Fixed-size array store[200] → constant space.

    No matter how big the string is, space doesn't grow.*/
    public static int lengthOfLongestSubstring2(String s) {

        int res = 0;
        int start = 0;
        int end =0;
        int n = s.length();
        int[] store = new int[200];
        while(start <n && end <n){
            if(store[s.charAt(end)] >=start){
                start=store[s.charAt(end)];
            }
            store[s.charAt(end)]=end+1;
            end++;
            res = Math.max(res, (end-start));
        }
        return res;
    }
}
