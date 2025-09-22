package com.data.structures.practice.sorting.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class PatienceSortFull {

    public static void main(String[] args) {
        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};
        int[] inputArray1=patienceSort(inputArray);
        for (int j : inputArray1) {
            System.out.println(j);
        }
    }

    public static int[] patienceSort(int[] nums) {
        // Step 1: Make piles
        List<Stack<Integer>> piles = new ArrayList<>();
        for (int num : nums) {
            int idx = findPile(piles, num);
            if (idx == piles.size()) {
                piles.add(new Stack<>());
            }
            piles.get(idx).push(num);
        }

        // Step 2: Use a min-heap to extract elements in sorted order
        PriorityQueue<PileEntry> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < piles.size(); i++) {
            pq.offer(new PileEntry(piles.get(i).pop(), i));
        }

        int[] result = new int[nums.length];
        int idx = 0;

        while (!pq.isEmpty()) {
            PileEntry entry = pq.poll();
            result[idx++] = entry.value;

            if (!piles.get(entry.pileIndex).isEmpty()) {
                pq.offer(new PileEntry(piles.get(entry.pileIndex).pop(), entry.pileIndex));
            }
        }

        return result;
    }

    // Binary search to find leftmost pile where top >= num
    private static int findPile(List<Stack<Integer>> piles, int num) {
        int l = 0, r = piles.size() ;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (piles.get(mid).peek() < num) {
                l = mid + 1;
            } else {
                r = mid ;
            }
        }
        return l;
    }

    // Helper class to store heap entries
    private static class PileEntry {
        int value;
        int pileIndex;
        PileEntry(int value, int pileIndex) {
            this.value = value;
            this.pileIndex = pileIndex;
        }
    }


}
