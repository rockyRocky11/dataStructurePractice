package com.data.structures.practice.LeetCode.dynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n=5;
        int[] storeArray = new int[46];
        storeArray[1] = 1;
        storeArray[2] = 2;
        System.out.println(fiboRecurrsionBottomUp(n, storeArray));//5

    }

    public static int fiboRecurrsionBottomUp(int input, int[] storeArray) {
        if (storeArray[input] > 0) {
            return storeArray[input];
        }
        for (int i = 3; i <= input; i++) {
            storeArray[i] = storeArray[i - 1] + storeArray[i - 2];
        }
        return storeArray[input];
    }
}
