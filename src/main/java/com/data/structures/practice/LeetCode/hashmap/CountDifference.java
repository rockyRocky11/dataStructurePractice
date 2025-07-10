package com.data.structures.practice.LeetCode.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountDifference {
    public static void main(String[] args) {

        //int[] nums = {1,2,2,1};
        //int k = 1;
        int[] nums = {2,9,1,5,4,2,8,3,6,6};
        int k = 1;
        //int[] nums = {1, 3};
        //int k = 3;
        //int[] nums = {3, 2, 1, 5, 4};
        //int k = 2;
        System.out.println(countKDifference(nums, k));
        System.out.println(countKDifferenceMap1(nums, k));

    }

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && (nums[i] - nums[j] == k || nums[j] - nums[i] == k)) {
                    count++;
                }

            }
        }
        return (int) count / 2;
    }

    public static int countKDifferenceMap1(int[] nums, int k) {
        LinkedHashMap<Integer, Integer> resMap = new LinkedHashMap<>(200);
        int count = 0;
        for (int num : nums) {
            if (resMap.containsKey(k + num)) {
                count = count + resMap.get(k + num);
            }
            if (resMap.containsKey(-(k - num))) {
                count = count + resMap.get(-(k - num));
            }
            resMap.put(num, resMap.getOrDefault(num, 0) + 1);

        }
        return count;
    }

    public int best(int[] nums, int k) {
        int freq[] = new int[101+k];
        int pairs = 0;
        for(int i:nums){
            freq[i]++;
        }
        for(int i=0;i<nums.length;i++){
            pairs+=freq[nums[i]+k];
        }

        return pairs;
    }
}
