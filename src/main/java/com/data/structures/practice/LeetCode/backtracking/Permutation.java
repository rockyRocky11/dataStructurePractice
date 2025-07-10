package com.data.structures.practice.LeetCode.backtracking;

import java.util.List;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums) );
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList();
        List<Integer> sol = new ArrayList();
        boolean[] used = new boolean[nums.length];
        backTrack(used, resList, sol, nums);
        return resList;
    }

    public static void backTrack(boolean[] used, List<List<Integer>> resList, List<Integer> sol, int[] nums){
        if(sol.size() == nums.length){
             resList.add(new ArrayList(sol));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            sol.add(nums[i]);
            used[i]=true;
            backTrack(used, resList, sol, nums);
            sol.remove(sol.size()-1);
            used[i]=false;
        }
    }
}
