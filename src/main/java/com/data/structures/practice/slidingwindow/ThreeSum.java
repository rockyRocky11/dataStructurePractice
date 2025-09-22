package com.data.structures.practice.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {-1,0,1,0};
       int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
        System.out.println(threeSumSlidingWindow(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList();

        int i = 0;
        int n = nums.length;
        int prevIndex = 0;
        ;
        while (i < n - 2) {
            if (i != 0 && nums[prevIndex] == nums[i]) {
                i++;
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1;
            int jprev = 0;
            while (j < n - 1) {
                if (j != i + 1 && nums[jprev] == nums[j]) {
                    j++;
                    continue;
                }
                int newTarget = target - nums[j];
                int k = j + 1;
                int kprev = 0;
                while (k < n) {
                    if (k != j + 1 && nums[kprev] == nums[k]) {
                        k++;
                        continue;
                    }
                    if (nums[k] == newTarget) {
                        List<Integer> sol = new ArrayList();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[k]);
                        resList.add(sol);

                    }
                    kprev = k;
                    k++;

                }
                jprev = j;
                j++;
            }
            prevIndex = i;
            i++;
        }
        return resList;


    }
    public static List<List<Integer>> threeSumSlidingWindow(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList();

        int i = 0;
        int n = nums.length;
        while (i < n - 2) {
            while (i > 0 && i < n - 2 && nums[i] == nums[i - 1]){
                i++;
            }
            int target = -nums[i];
            int j = i + 1;
            int k = n-1;
            while (j < k) {
                while (j < k && (j != i + 1 && nums[j] == nums[j-1]) ) {
                    j++;
                }

                while (j < k && (k != n-1 && nums[k] == nums[k+1])) {
                    k--;
                }
                int sum =nums[j]+nums[k];
                if(sum == target){
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(nums[k]);
                    resList.add(sol);
                    k--;
                    j++;
                }else if(sum> target){
                    k--;
                }else {
                    j++;
                }
            }
            i++;
        }
        return resList;


    }
}
