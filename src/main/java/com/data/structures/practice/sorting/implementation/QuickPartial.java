package com.data.structures.practice.sorting.implementation;

import java.util.Random;

public class QuickPartial {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];
        return sortArray(nums, k);
    }

    Random rand = new Random();

    public int sortArray(int[] nums, int k) {

        return quickSort(nums, 0, nums.length, nums.length - k);

    }

    public int quickSort(int[] nums, int start, int end, int k) {
        if (end == start )
            return nums[start];

        int randomIndex = start + rand.nextInt(end - start);
        swap(nums, start, randomIndex);
        int pivotIndex = partition(nums, start, end);
        // if(pivotIndex <= nums.length-k){
        if (pivotIndex == k) {
            return nums[k];
            //System.out.println(nums[nums.length-k]);
        } else if (pivotIndex < k) {
            return quickSort(nums, pivotIndex + 1, end, k);
        } else {
            return quickSort(nums, start, pivotIndex , k);
        }
    }

    public int partition(int[] nums, int start, int end) {
        //int[] slice1 = Arrays.copyOfRange(nums, start, end);
        // System.out.println(Arrays.toString(slice1));
        int pivotElement = nums[start];//pivot element is always at start
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[--j] >= pivotElement)
                ;//element on the right should be greater than pivot
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[++i] <= pivotElement)
                ;//element on the left should be less than pivot
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[j] = pivotElement;
        // int[] slice2 = Arrays.copyOfRange(nums, start, end);
        //System.out.println(Arrays.toString(slice2));
        return j;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
