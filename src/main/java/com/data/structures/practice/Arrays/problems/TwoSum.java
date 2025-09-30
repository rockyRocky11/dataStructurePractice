package com.data.structures.practice.Arrays.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        //int[] ans1 = twoSumWithHashMap(nums, 13);
        int[] ans2 = twoSumWithHashMap(nums, 6);

        //System.out.println(Arrays.toString(ans));
        //System.out.println(Arrays.toString(ans1));
        System.out.println(Arrays.toString(ans));

    }


    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int[] ans = new int[2];
        while (i < nums.length - 1) {
            int val = nums[i];
            for (int k = 0; k < nums.length; k++) {
                if (i != k && val + nums[k] == target) {
                    ans[0] = i;
                    ans[1] = k;
                    break;
                }
            }
            i++;
        }
        return ans;
    }

    public static int[] twoSumWithHashMap(int[] nums, int target) {

        //If x+y = target then target -x is Y so take any no as x then serach for target -x in the map
        //in Hashmap O(1) for get
        Map<Integer, Integer> searchingMap = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i];
            if (searchingMap.containsKey(complement)) {
                return new int[]{i, searchingMap.get(complement)};
            } else {
                searchingMap.put(nums[i], i);
            }
        }
        return null;
    }
}
