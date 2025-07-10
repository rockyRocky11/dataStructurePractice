package com.data.structures.practice.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
       // System.out.println(backTrackForSum(0, 0, target, resList, sol););

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList();
        List<Integer> sol = new ArrayList();

        //backTrack(candidates, target, 0, 0, resList, sol);
        backTrackForSum( candidates,0,  target, resList, sol);

        return resList;
    }



    public static void backTrackForSum(int[] candidates, int currentIndexInSubList,  int target, List<List<Integer>> resList, List<Integer> sol) {

        if (0 == target) {
            //System.out.println(sol);
            resList.add(new ArrayList<>(sol));
            return;
        }
        if(target<0){
            return;
        }
        int j = currentIndexInSubList;
        //Add all possible options
        while (j < candidates.length) {
            sol.add(candidates[j]);
            backTrackForSum(candidates , j ,  target-candidates[j], resList, sol);
            sol.remove(sol.size() - 1);
            j++;
        }
    }

   /* public static void backTrack(int[] candidates, int target, int sum, int index, List<List<Integer>> resList, List<Integer> sol) {

        if (sum == target) {
            resList.add(new ArrayList<>(sol));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (sum > target) {
            return;
        }

        // dont pick the number
        backTrack(candidates, target, sum, index + 1, resList, sol);

        //add the same
        sol.add(candidates[index]);
        sum += candidates[index];
        backTrack(candidates, target, sum, index, resList, sol);
        sum -= sol.get(sol.size() - 1);
        sol.remove(sol.size() - 1);

        return;
    }*/
}
