package com.data.structures.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 7;
        System.out.println(combinationSum2(candidates, target));
       // System.out.println(backTrackForSum(0, 0, target, resList, sol););

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // step 1: sort to group duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    static void  backtrack(int[] nums, int remain, int start, List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue; // skip duplicates

            if (nums[i] > remain)
                break; // optimization: no need to continue

            path.add(nums[i]);
            backtrack(nums, remain - nums[i], i + 1, path, result); // i+1 = no reuse
            path.remove(path.size() - 1); // backtrack
        }
    }
}
