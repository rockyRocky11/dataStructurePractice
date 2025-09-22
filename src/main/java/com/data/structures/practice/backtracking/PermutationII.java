package com.data.structures.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permuteUnique(nums) );
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }
    }
}
