package com.data.structures.practice.LeetCode.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1;
//        int n =0;
//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1;
//        int n =0;
//        int[] nums1 = {2, 0};
//        int[] nums2 = {1};
//        int m = 1;
//        int n =1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0)
            return;
        if(nums1.length==0) {
            System.arraycopy(nums2, n, nums1, 0, n);
            return;
        }
        int[] tempArray= new int[m+n];
        int i=0;
        int j=0;
        int tempIndex=0;

        while(i<m && j< n){
            tempArray[tempIndex++]=nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
        }

        System.arraycopy(nums2, j, tempArray, tempIndex, n-j);
        tempIndex = tempIndex+(n-j);
        System.arraycopy(nums1, i, tempArray, tempIndex, m-i);
        tempIndex = tempIndex+(m-i);

        System.arraycopy(tempArray, 0, nums1, 0, tempIndex);


    }
}
