package com.data.structures.practice.dynamicProgramming;

import java.util.Map;

public class MinimumCoins {
    public static void main(String[] args) {
        int sum = 13;
        int[] coins ={1, 4, 5};
        int sum1 = 150;
        int[] coins1 ={1, 4, 5};
        System.out.println(minimumCoins1(sum, coins));
        System.out.println(minimumCoins2(sum, coins));
        System.out.println(minimumCoins2(sum1, coins1));
        //System.out.println(minimumCoins1(sum1, coins1));
        //minimum number of coins from above needed to reach the given sum
    }


    public static int minimumCoins1(int sum, int[] coins){
        int[] memo = new int[sum+1];
        int answer = 0;

        return minimumCoins(sum, coins, memo, answer);

    }

    public static int minimumCoins(int sum, int[] coins, int[] memo, int answer){

        if(memo[sum]>0){
            return memo[sum];
        }
        if(sum ==0){
            return answer;
        }

        for(int coin: coins) {
            int subProblem = sum-coin;
            if(subProblem>0){
                answer = minIgnore(answer, minimumCoins1(subProblem, coins)+1);
                memo[sum]=answer;
            }
        }
        return answer;

    }

    public static int minimumCoins2(int sum, int[] coins){

        int[] store = new int[sum+1];
        store[0]=0;
        for(int a=1;a<sum+1;a++){
            for(int coin: coins){
                if(a-coin>=0){
                    store[a]=Math.min(store[a], 1+store[a-coin]);
                }
            }
        }
        if(store[sum] != sum+1){
            return store[sum];

        }
        return -1;
    }

    public static int minIgnore(int a, int b){
        if(a <=0){
            return b;
        }
        if(b <=0){
            return a;
        }
        return Math.min(a, b);
    }
}
