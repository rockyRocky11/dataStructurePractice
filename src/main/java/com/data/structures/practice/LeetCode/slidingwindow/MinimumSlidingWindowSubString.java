package com.data.structures.practice.LeetCode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumSlidingWindowSubString {
    public static void main(String[] args) {
       // String s = "ADOBECODEBANC", t = "ABC";
        String s = "aaaaaaaaaaaabbbbbcdd", t = "abcdd";
        //String s = "a", t = "aa";
        System.out.println(minWindow(s, t));
    }

/*    ✅ Time and Space Complexity
    Time Complexity: O(N) where N = s.length() — both pointers move at most N times.

    Space Complexity: O(K) where K = unique characters in t — for need and window.*/
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char a : t.toCharArray()) {
            need.put(a, (need.getOrDefault(a, 0)) + 1);
        }
        int needCount = need.size();
        int have = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        int startIndex = 0;
        while (right < n) {
            char temp = s.charAt(right);
            window.put(temp, (window.getOrDefault(temp, 0)) + 1);
            if (need.containsKey(temp) && window.get(temp).intValue() == need.get(temp).intValue()) {
                have++;
            }

            while (have == needCount) {

                //Cleaver way to keep track of min
                //another best way to form min substring, by tracking only start index
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                char temp1 = s.charAt(left);
                window.put(temp1, window.getOrDefault(temp1, 0) - 1);
                if (need.containsKey(temp1) && window.get(temp1) < need.get(temp1)) {
                    have--;
                }
                left++;

            }

            right++;
        }

        //just by using startIndex and minLen stored we are forming substring
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen + 1);
    }
}
