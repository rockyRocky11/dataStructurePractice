package com.data.structures.practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

    /*Time:

    Building the max-heap with all elements: O(n log n)

    Removing k elements: O(k log n) (usually dominated by the build)

    Overall: O(n log n)

    Space:

    O(n) for the heap storing all elements.*/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) {
            pq.add(n);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.poll();

    }

    //O(n log k)	O(k)
    public int findKthLargestStoreOnlyK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();

    }

    /*Total: O(n)
    O(1)*/
    public int findKthLargestUsingCountingSort(int[] nums, int k) {
        // Frequency array for counting sort, covers range from -10000 to 10000
        int[] s = new int[20001];

        // Count occurrences of each number in nums, offset by 10000 to handle negatives
        for (int n : nums) {
            s[n + 10000]++;
        }

        int stop = 0;
        // Iterate from the largest possible value down to smallest
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] != 0) {
                stop += s[i];  // Accumulate counts
            }
            // Once we've reached or passed k elements, return the corresponding value
            if (stop >= k) {
                return i - 10000;  // Convert back from offset index to original value
            }
        }

        return -1; // Return -1 if kth largest not found (should not happen if input valid)
    }
}
