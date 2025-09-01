package com.data.structures.practice.hashtable.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutive {

    //Time N*(logn )
    public int longestConsecutive(int[] nums) {

        TreeSet<Integer> ts = new TreeSet<>();
        for (int n : nums) {
            ts.add(n);
        }
        int prev = Integer.MAX_VALUE;
        int res = 0;
        int ans=Integer.MIN_VALUE;
        for (int n : ts) {
            // System.out.println("n :" + n + " prev: " + prev + " res:" + res);
            if (prev == Integer.MAX_VALUE) {
                prev = n;
                res = 1;
            } else if (n - prev == 1) {
                res++;
                prev = n;
            } else {
                res = 1;
                prev = n;
            }
            ans=Math.max(ans, res);
        }
        return ans==Integer.MIN_VALUE?0:ans;
    }


    //Linear approach
    //O(n)
    public int longestConsecutiveWithFindStartMethod(int[] nums) {

        Set<Integer> ts = new HashSet<>();
        for (int n : nums) {
            ts.add(n);
        }

        int ans = Integer.MIN_VALUE;
        for (int n : ts) {
            int res = 1;
            if (!ts.contains(n - 1)) {
                while (ts.contains(n + 1)) {
                    n++;
                    res++;
                }
            }

            ans = Math.max(ans, res);
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
