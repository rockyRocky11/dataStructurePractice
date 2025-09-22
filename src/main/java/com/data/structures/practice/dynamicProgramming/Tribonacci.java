package com.data.structures.practice.dynamicProgramming;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));//4
        System.out.println(tribonacci(25));//1389537
    }

    public static int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] store = new int[n+1];
        store[1] = 1;
        store[2] = 1;
        if(store[n]==1){
            return store[n];
        }
        for(int i=3;i<=n;i++){
            store[i]=store[i-1]+store[i-2]+store[i-3];
        }
        return store[n];
    }
}
