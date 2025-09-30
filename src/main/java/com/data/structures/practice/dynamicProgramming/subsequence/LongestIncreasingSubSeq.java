package com.data.structures.practice.dynamicProgramming.subsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
      //  int[] nums = {2, 5, 3, 7, 11, 8 , 10, 13, 6};
       // int[] nums = {0,1,0,3,2,3};
        //int[] nums = {7,7,7,7,7,7,7};

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISBinarySort(nums));

    }

    //Time : O(n^2)
    //Space O(n)
    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int mainProbMax = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            int subProbMax = 0;
            for (int j = i + 1; j < nums.length; j++) {

                if(nums[j]>nums[i]){
                    subProbMax = Math.max(subProbMax, dp[j]);
                }

            }
            dp[i] = 1 + subProbMax;
            mainProbMax = Math.max(mainProbMax, 1 + subProbMax);
        }
        return mainProbMax;
    }

   /* Still remains O(n log n):

    Best case: all increasing → O(n)

    Worst case: all random → O(n log n)*/
    public static int lengthOfLISBinarySort(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            if (tails.isEmpty() || num > tails.get(tails.size() - 1)) {
                tails.add(num); // Extend LIS
                //System.out.println(num);
            } else {
                // Binary search for the smallest tail ≥ num
                int left = 0, right = tails.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (tails.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails.set(left, num); // Replace with smaller element
            }
        }
        //System.out.println(tails);
        return tails.size();
    }

}
