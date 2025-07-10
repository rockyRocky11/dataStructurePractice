package com.data.structures.practice.LeetCode.dynamicProgramming;

public class FibnonacciSeq {
    public static void main(String[] args){
        int input1 = 5;
        int input2 = 20;
        System.out.println(fiboRecurrsion(input1));//5
        System.out.println(fiboRecurrsion(input2));//6765
        int[] storeArray = new int[input1+1];
        int[] storeArray1 = new int[input2+1];
        System.out.println(fiboRecurrsionMemoized(input1, storeArray));//5
        System.out.println(fiboRecurrsionMemoized(input2, storeArray1));//6765
        int[] storeArray2 = new int[input1+1];
        storeArray2[1]=1;
        storeArray2[2]=1;
        int[] storeArray3 = new int[input2+1];
        storeArray3[1]=1;
        storeArray3[2]=1;
        System.out.println(fiboRecurrsionBottomUp(input1, storeArray2));//5
        System.out.println(fiboRecurrsionBottomUp(input2, storeArray3));
    }

    //1, 1, 2, 3, 5, 8, 13
    //fin(n) = fib(n-1)+fib(n-2);
    public static int fiboRecurrsion(int input){
    if(input ==1 || input ==2){
        return 1;
    }
    return fiboRecurrsion(input-1)+fiboRecurrsion(input-2);
    }

    public static int fiboRecurrsionMemoized(int input, int[] storeArray){
        int result= 0;
        if(storeArray[input]>0){
            return storeArray[input];
        }
        if(input ==1 || input ==2){
            return 1;
        }else{
            result=fiboRecurrsion(input-1)+fiboRecurrsion(input-2);
            storeArray[input]=result;
        }
        return result;
    }

    public static int fiboRecurrsionBottomUp(int input, int[] storeArray){
        if(storeArray[input]>0){
            return storeArray[input];
        }
        for(int i=3;i<=input;i++){
            storeArray[i]=storeArray[i-1]+storeArray[i-2];
        }
        return storeArray[input];
    }
}
