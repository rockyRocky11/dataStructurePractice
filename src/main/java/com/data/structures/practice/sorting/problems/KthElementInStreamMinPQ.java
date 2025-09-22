package com.data.structures.practice.sorting.problems;

import java.util.PriorityQueue;

public class KthElementInStreamMinPQ {


   /* Constructor: O(n log k) (insert into min-heap of size k).

    add(): O(log k).*/
    class KthLargest {

        int size = 0;
        int k;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {

            this.k = k;
            pq = new PriorityQueue<>();
            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {

            if (pq.size() < k) {
                pq.offer(val);
            } else if (val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }
}
