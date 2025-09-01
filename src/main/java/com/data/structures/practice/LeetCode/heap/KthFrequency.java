package com.data.structures.practice.LeetCode.heap;

import java.util.*;

public class KthFrequency {

    /*Time Complexity:

    Counting frequencies: O(n)

    Heap insertions: O(n log k)

    Total: O(n log k)

    Space Complexity: O(n) for the map + heap.*/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] ans = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> map : freqMap.entrySet()) {
            int v = map.getValue();
            int ky = map.getKey();

            // System.out.println(ky + " " + v);

            pq.offer(new int[] { ky, v });

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int size = pq.size();

        for(int i=0;i<size;i++){
            ans[idx++]=pq.poll()[0];
        }
        return ans;
    }

    public int[] topKFrequentBucket(int[] nums, int k) {
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
