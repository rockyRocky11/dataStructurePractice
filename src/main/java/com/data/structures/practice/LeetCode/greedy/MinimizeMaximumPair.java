package com.data.structures.practice.LeetCode.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimizeMaximumPair {
    public static void main(String[] args) {
        //int[] nums ={3,5,2,3};
        //int[] nums ={3,5,4,2,4,6};
        int[] nums ={4,1,5,1,2,5,1,5,5,4};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int i=0;
        int j=nums.length-1;
        int mid = nums.length/2;
        int maxPair = 0;

        while(i<mid && j >= mid){

            if(nums[i]+nums[j]>maxPair){
                maxPair = nums[i]+nums[j];
            }
            i++;
            j--;
        }
        return maxPair;
    }
}
