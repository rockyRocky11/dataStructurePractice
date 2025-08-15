package com.data.structures.practice.bitmanipulation;

public class CountBits {
    public static void main(String[] args) {
        int n = 5;
        for (int num:countBits(n)){
            System.out.println(num);
        }

    }

    public static int[] countBits(int n) {

        int[] resList = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            //Solved using dynamic programing, i/2 will give me previous number
            //because thats how binary is formed, keep dividing by2
            //the last is to add 1 if the number is odd.
           // resList[i]= resList[i/2]+(i%2==1?1:0);
            resList[i]= resList[i>>1]+(i&1);
        }

        return resList;

    }
}
