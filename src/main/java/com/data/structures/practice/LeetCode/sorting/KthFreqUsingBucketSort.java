package com.data.structures.practice.LeetCode.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KthFreqUsingBucketSort {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        topKFrequent(nums, k);
    }

    /*Time Complexity: O(n) (map + bucket filling + iteration)
    Space Complexity: O(n)*/

    /*If you’re prepping for interviews, FAANG engineers love when you mention:

    Heap approach for general k

    Bucket sort for integers when range is reasonable

    Tradeoffs between O(n log k) and O(n)*/
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> map : freqMap.entrySet()) {
            int v = map.getValue();
            int ky = map.getKey();
            if (bucket[v] == null) {
                bucket[v] = new ArrayList<>();
            }
            bucket[v].add(ky);
        }

        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && ans.size() < k; i--) {
            if (bucket[i] != null) {
                ans.addAll(bucket[i]);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
