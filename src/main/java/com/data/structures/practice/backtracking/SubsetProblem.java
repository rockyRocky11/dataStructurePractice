package com.data.structures.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetProblem {
    private static List<List<Integer>> results = new ArrayList<>();
    private static List<Integer> solu = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {0};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        backTrack(0, nums);
        return results;
    }

    public static void backTrack(int n, int[] nums) {

        if (n >= nums.length) {
            results.add(new ArrayList<>(solu));
            return;
        }

        //Dont pick n
        backTrack(n + 1, nums);
        //pick n
        solu.add(nums[n]);
        backTrack(n + 1, nums);
        solu.remove(solu.size()-1);

    }
}
