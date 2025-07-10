package com.data.structures.practice.LeetCode.dynamicProgramming;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] input = {1, -3, 4, -1, 2, 1, -5, 4}; //ans = 6
        int[] input1 = {5,4,-1,7,8}; //ans = 23
        int[] input2 = {-2,1}; //ans = 1
        System.out.println(calculateMaxSum(input2));
    }

    public static int calculateMaxSum(int[] input){

        int currentSubArray = input[0];
        int maxSum = 0;
        for(int i=1;i< input.length;i++){
            if(currentSubArray+input[i]>input[i]){
                currentSubArray = currentSubArray+input[i];
            }else{
                currentSubArray = input[i];

            }

            maxSum = Math.max(maxSum, currentSubArray);

        }
        return maxSum;
    }
}
