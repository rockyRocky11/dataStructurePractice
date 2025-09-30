package com.data.structures.practice.sorting.implementation;

import java.util.ArrayList;
import java.util.List;

public class PatienceSort {
    public int lengthOfLIS(int[] nums) {
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
