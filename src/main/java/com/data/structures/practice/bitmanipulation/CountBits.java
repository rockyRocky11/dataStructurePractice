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
            // The core concept here is based on how a decimal is converted into binary
            //Solved using dynamic programing, i/2 will give me previous number
            //because thats how binary is formed, keep dividing by2
            //the last is to add 1 if the number is odd.
           // resList[i]= resList[i/2]+(i%2==1?1:0);
            //This is same as above logic, but i>>1 is equal to divide by 2
            //i&1 will tell you the last is digit is 1 or 0
            resList[i]= resList[i>>1]+(i&1);
        }

        return resList;

    }
}
