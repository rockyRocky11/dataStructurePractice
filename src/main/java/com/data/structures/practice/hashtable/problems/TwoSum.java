package com.data.structures.practice.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

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
