package com.data.structures.practice.LeetCode.treePrac;

import java.util.*;

public class NoOfWaysReOrderBST {

    static final int MOD = 1_000_000_007;
    //MOD: for modulo arithmetic to avoid overflow
    static List<List<Long>> comb;
    //comb: Pascal’s triangle to store combinations C(n, r) precomputed for reuse

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6}; // Expected output: 19
        System.out.println(numOfWays(nums));
    }

    public static int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        int n = nums.length;
        comb = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            comb.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) comb.get(i).add(1L);
                else {
                    long val = (comb.get(i - 1).get(j - 1) + comb.get(i - 1).get(j)) % MOD;
                    comb.get(i).add(val);
                }
            }
        }

        return (int) ((countWays(list) - 1 + MOD) % MOD); // -1 to exclude original input
    }

    private static long countWays(List<Integer> nums) {
        if (nums.size() <= 2) return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        int leftSize = left.size(), rightSize = right.size();

        long waysToInterleave = comb.get(leftSize + rightSize).get(leftSize);
        return ((waysToInterleave * leftWays) % MOD * rightWays) % MOD;
    }
}
