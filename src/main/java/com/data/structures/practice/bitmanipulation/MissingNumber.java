package com.data.structures.practice.bitmanipulation;

public class MissingNumber {
    public static void main(String[] args) {
       // int[] nums = {3,0,1};
       // int[] nums = {0,1};
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberUsingXOR(nums));

    }
    public static int missingNumber(int[] nums) {

        int n= nums.length;
        int res=0;
        int sum=n*(n+1)/2;
        for(int i=0;i< nums.length;i++){
            res+=nums[i];
        }
        return sum-res;
    }

    public static int missingNumberUsingXOR(int[] nums) {
        int n = nums.length;
        int xorAll = 0;
        int xorNums = 0;

        // XOR from 0 to n
        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }

        // XOR all elements in the array
        for (int num : nums) {
            xorNums ^= num;
        }

        // Missing number is the XOR difference
        return xorAll ^ xorNums;
    }

}
