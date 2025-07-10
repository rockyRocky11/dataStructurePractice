package com.data.structures.practice.LeetCode.backtracking;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class CombinationSumNoDuplicates {
    public static void main(String[] args) {

       // int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates = {2,5,2,1,2};
//        int target = 8;
        int target = 5;
        System.out.println(combinationSum2(candidates, target));
       // System.out.println(backTrackForSum(0, 0, target, resList, sol););

    }

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList();
        List<Integer> sol = new ArrayList();
        HashSet<List<Integer>> uniqueComboList = new HashSet<>();


        //backTrack(candidates, target, 0, 0, resList, sol);
        backTrackForSum( candidates,0,  target, resList, sol, uniqueComboList);

        return resList;
    }



    public static void backTrackForSum(int[] candidates, int currentIndexInSubList,  int target, List<List<Integer>> resList, List<Integer> sol, HashSet<List<Integer>> uniqueComboList) {

        if (0 == target) {
            //System.out.println(sol);
            //Collections.sort(sol);
            List<Integer> temnpArray = new ArrayList<>(sol);
            Collections.sort(temnpArray);
            if(!uniqueComboList.contains(temnpArray)) {
                resList.add(temnpArray);
                uniqueComboList.add(temnpArray);
            }
            return;
        }
        if(target<0){
            return;
        }
        int j = currentIndexInSubList;
        //Add all possible options
        while (j < candidates.length) {
            if (j > currentIndexInSubList && candidates[j] == candidates[j - 1]) continue;
            sol.add(candidates[j]);
            backTrackForSum(candidates , j +1,  target-candidates[j], resList, sol, uniqueComboList);
            sol.remove(sol.size() - 1);
            j++;
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // step 1: sort to group duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public  static void backtrack(int[] nums, int remain, int start, List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates

            if (nums[i] > remain) break; // optimization: no need to continue

            path.add(nums[i]);
            backtrack(nums, remain - nums[i], i + 1, path, result); // i+1 = no reuse
            path.remove(path.size() - 1); // backtrack
        }
    }
}
