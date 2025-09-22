package com.data.structures.practice.sorting.implementation;

import java.util.Random;

public class QuickRandom {
    Random rand = new Random();

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length);
        return nums;

    }

    public void quickSort(int[] nums, int start, int end) {
        if (end - start < 2)
            return;

        int randomIndex = start + rand.nextInt(end - start);
        swap(nums, start, randomIndex);
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex);
        quickSort(nums, pivotIndex + 1, end);
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
