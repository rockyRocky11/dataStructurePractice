package com.data.structures.practice.sorting;

public class Quick {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};
        int[] inputArray1 = {20, 35, -15, 7, 55, 1, -22};
        qucikSort(inputArray1);
        for (int j : inputArray1) {
            System.out.println(j);
        }

        for(int  pivotIndex=0;pivotIndex<inputArray.length; pivotIndex++){
            int pivotElement = inputArray[pivotIndex];
            int i = pivotIndex;
            int j= inputArray.length;
            while(i<j) {
                // alternate method is empty while loop
                while (i < j) {
                    if (inputArray[--j] < pivotElement) {
                        inputArray[i] = inputArray[j];
                        break;
                    }
                }
                while (i < j) {
                    if (inputArray[++i] > pivotElement) {
                        inputArray[j] = inputArray[i];
                        break;
                    }
                }
            }
            inputArray[i]=pivotElement;
        }

        for (int j : inputArray) {
            System.out.println(j);
        }

    }

    /*Time complexity:

    Average: O(n log n)

    Worst: O(n²) (bad pivot choices)

    Space complexity: O(log n) due to recursion stack.*/

    public static void qucikSort(int[] nums) {
        int n = nums.length;
        // kth largest is (n - k)th smallest in zero-based index
         quickSort(nums, 0, n);
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (right - left <2) return;

        // Choose a pivot index (can be randomized for better avg performance)
        int pivotIndex = partition1(nums, left, right);

        quickSort(nums, left, pivotIndex );
        quickSort(nums, pivotIndex + 1, right);

    }

    private  static  int partition1(int[] nums, int left, int right) {
        //we always take first element as pivot
        int pivot = nums[left];
        int i= left;
        int j= right;
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
