package com.data.structures.practice.sorting.implementation;

public class HeapSort {

    public static void main(String[] args) {

       // int[] inputArray = {20, 35, -15, 7, 55, 1, -22};
        int[] inputArray = {4,5,8,2};
        heapSort(inputArray);
        for (int j : inputArray) {
            System.out.println(j);
        }


    }

    public static void heapSort(int[] nums){
        System.out.println("befor");
        for (int i = 0; i < 4; i++) {
            System.out.print(nums[i] + " ");
        }
        int n=nums.length;

        for(int i=n/2-1;i>=0;i--){// we run heapfify only for integral indexes from 0-n/2-1
            heapify(nums, n, i);
        }

        //O(n logn)
        for(int i=n-1;i>0;i--){//>0 because last remaining index is in its place
            /*for (int j = 0; j < n; j++) {
                System.out.print(nums[j] + " ");
            }*/
            swap(nums, 0, i);

            heapify(nums, i , 0);// Need to heapify after removing the top element to bring  the next largest element

        }
        System.out.println();
        System.out.println("afet");
        for (int i = 0; i < 4; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }

    //Time : O(logn)
    public static void heapify(int[] nums, int n, int i){

        int largest = i;
        int left = 2*i+1;//left child formula
        int right = 2*i+2;//left child formula

        if(left<n && nums[left]>nums[largest]){
            largest = left;
        }

        if(right<n && nums[right]>nums[largest]){
            largest = right;
        }
        // If largest is not root
        if(largest != i){
            swap(nums, i, largest);

            // Recursively heapify the affected subtree
            heapify(nums, n, largest);
        }

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
