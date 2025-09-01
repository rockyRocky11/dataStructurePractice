package com.data.structures.practice.sorting.problems;

public class FindKthSmallestUsingQuickSelect {

    /*Time & Space Complexity
    Average Time:

    Flatten: O(m·n)

    Quickselect: O(m·n) average (partitioning ~O(N), recursing one side only).

    Total average: O(m·n)

    Worst Time: O((m·n)²) if pivot choices are consistently bad.

            Space: O(m·n) for nums array + O(log(m·n)) recursion stack.*/
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[idx++] = matrix[i][j];
            }
        }
        return quickSelect(nums, k - 1, 0, nums.length);
    }

    public int quickSelect(int[] nums, int k, int l, int r) {
        if(l ==r){
            return nums[l];
        }

        int p = partition(nums, l, r);
        if(k<p){
            return quickSelect(nums, k, l, p);
        } else if(k>p){
            return quickSelect(nums, k, p+1, r);
        }
        return nums[p];

    }

    public int partition(int[] nums, int l, int r) {

        int pivot = nums[l];
        int i=l;
        int j=r;
        while(i<j){
            while(i<j && nums[--j]>pivot);
            if(i<j){
                nums[i]=nums[j];
            }

            while(i<j && nums[++i]<pivot);
            if(i<j){
                nums[j]=nums[i];
            }
        }
        nums[i]=pivot;
        return i;
    }
}
