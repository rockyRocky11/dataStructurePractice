package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.nio.file.AccessMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CoinChangeII {
    public static void main(String[] args) {

        int[] coins = { 1,2,5};
        //int[] coins = { 1};
        //int amount = 1;
       int amount = 5;
        //System.out.println(coinChange(coins, amount));
        System.out.println(change( amount, coins));
        System.out.println(changeRecMemo( amount, coins));
        System.out.println(coinChangeBottomUpMemo2( coins, amount ));
        //System.out.println(coinChangeBottomUpMemo(coins, amount));
    }
    static int changes = 0;
    public static int change( int amount, int[] coins) {
        changes = 0;
        Arrays.sort(coins);
        List<Integer> change = new ArrayList();
        recursionBackTrack(change, coins, amount, coins.length - 1);
        return changes;
    }

    public static void recursionBackTrack(List<Integer> change, int[] coins, int amount, int currentCoinIndex) {
        if (amount < 0 ) {
            return;
        }
        if (amount == 0) {
            changes++;
            return;
        }

        int i = currentCoinIndex;
        while (i >=0) {
            change.add(coins[i]);
            recursionBackTrack(change, coins, amount - coins[i], i);
            change.remove(change.size()-1);
            i--;
        }
    }

    public static int changeRecMemo( int amount, int[] coins) {
        Arrays.sort(coins);
        Integer[][] memo = new Integer[amount+1][coins.length];
        int rees= recursionBackTrackMemo(memo, coins, amount, 0);
        return rees;
    }

   /* ✅ 1. Add the currentCoinIndex to your memo key
    Right now, memo[amount] only tracks the number of ways for an amount, ignoring which coins you can still use. But different branches (e.g. starting with coin 1 or coin 2) will collide.

    Instead, memoize on (amount, currentCoinIndex) to capture both dimensions:

    java
            Copy
    Edit
    static Integer[][] memo;  // memo[amount][currentIdx]*/

    /*📊 Complexity
    Metric	Value
    Time	O(amount × coins.length)
    Space	O(amount × coins.length) + call stack*/

    public static int recursionBackTrackMemo(Integer[][] memo, int[] coins, int amount, int currentCoinIndex) {
        if (amount < 0 ) {
            return 0;
        }
        if(memo[amount][currentCoinIndex]!=null){
            return memo[amount][currentCoinIndex];
        }
        if (amount == 0) {
            return 1;
        }

        int i = currentCoinIndex;
        int count=0;
        while (i <coins.length) {
            if(coins[i]>amount){
                i++;
                continue;
            }
            count+=recursionBackTrackMemo(memo, coins, amount - coins[i], i);
            i++;
        }
        memo[amount][currentCoinIndex]=count;
        return count;
    }

    public static int coinChangeBottomUpMemo(int[] coins, int amount) {
        Arrays.sort(coins);
        Integer[][] memo = new Integer[amount + 1][coins.length];
        memo[0][0] = 0;
        for (int i = 1; i < amount + 1; i++) {

            for (int j=0;j<coins.length;j++) {
                if (coins[j] > i) {
                    break;
                }
                int currSum = i - coins[j];
                if (currSum == 0 ) {
                    memo[i][j]=1;
                }else if (currSum > 0 && memo[currSum][j] != null) {
                    memo[currSum][j]+= memo[currSum][j] ;
                }
            }

        }
        return memo[amount][0];
    }

    /*Avoids duplicates: Because each coin is processed sequentially, you never count the same set of coins in different orders.

    Time Complexity: O(number_of_coins × amount)

    Space Complexity: O(amount)*/

   /* Take coin 1, and find how many ways it can fill amount from 1 -5 --> 1 ways
    Take coin 2 and find out how many ways it fill amount 2-5
    keep going untill end of coin, each time the memo will be incremented.*/
    public static int coinChangeBottomUpMemo2(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memo = new int[amount + 1];
        memo[0] = 1;
            for (int j=0;j<coins.length;j++) {

                for (int i = 1; i <=amount; i++) {

                    int currSum = i - coins[j];
                     if (currSum >= 0 ) {
                        memo[i]+= memo[currSum] ;
                    }
                }


        }
        return memo[amount];
    }

}