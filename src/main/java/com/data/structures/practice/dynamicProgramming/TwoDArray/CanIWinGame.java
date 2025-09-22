package com.data.structures.practice.dynamicProgramming.TwoDArray;


import java.util.*;
public class CanIWinGame {

    public static void main(String[] args) {
        System.out.println(canIWin(4, 6));
    }


    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0 )
            return true;
        if(((maxChoosableInteger*(maxChoosableInteger+1))/2) < desiredTotal)return false;
        Map<Integer, Boolean> dp = new HashMap<>();

        return dfs(maxChoosableInteger, desiredTotal, 0, dp);

    }

    public static boolean dfs(int maxChoosableInteger, int desiredTotal, int used,
                       Map<Integer, Boolean> dp) {
        if (dp.containsKey(used))
            return dp.get(used);
        if (desiredTotal <= 0) {
            return false;
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {

            int bit = 1 << (i - 1);
            if ((used & bit) != 0)
                continue;

            if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i, used | bit, dp)) {
                dp.put(used, true);
                return true;
            }

        }
        dp.put(used, false);
        return false;
    }
}
