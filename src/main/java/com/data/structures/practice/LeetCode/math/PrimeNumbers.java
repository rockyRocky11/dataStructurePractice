package com.data.structures.practice.LeetCode.math;

import java.util.Arrays;

public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println(primeNaive(10));
        System.out.println(primeNaiveBetter(10));
        listPrimeNumbers(10);

    }

   /* Number greater than 1 divisible by 1 and itself is prime number
    Time : O(n)*/
    public static boolean primeNaive(int n){
    if(n<2){
        return false;
    }
    for(int i=2;i<n;i++){
        if(n%i ==0){
            return false;
        }
    }
    return true;
    }

    public static boolean primeNaiveBetter(int n){
        if(n<2){
            return false;
        }
        int sq = (int)Math.sqrt(n);
        for(int i=2;i<=sq;i++){
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }

   /* 🧠 Time Complexity:
    O(nloglogn)*//*
    Which is very fast for large ranges (up to 10⁶ or 10⁷).*/
    public static void listPrimeNumbers(int max){

        boolean[] res =listPrimeNumbersUsingSieveOfEratosthenes(max);
        System.out.println(Arrays.toString(res));
    }

    public static boolean[] listPrimeNumbersUsingSieveOfEratosthenes(int max){
        boolean[] flags = new boolean[max+1];
        for(int i=2;i<max;i++){
            flags[i]=true;
        }
        int prime =2;
        while(prime<= Math.sqrt(max)) {
            crossOff(prime, flags);


            prime = getNextPrime(prime, flags);
            if (prime > flags.length) {
                break;
            }
        }
        return flags;
    }

    public static void crossOff(int prime, boolean[] flags){
        //all multiple of prime number is not prime
        for(int i=prime*prime;i<flags.length;i+=prime){
            flags[i]=false;
        }
    }

    public static int getNextPrime(int prime, boolean[] flags){
        int next = prime+1;
       while (next< flags.length && !flags[next]){
            next++;
        }
       return next;
    }
}
