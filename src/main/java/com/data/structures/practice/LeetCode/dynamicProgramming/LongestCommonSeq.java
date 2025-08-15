package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSeq {
    public static boolean res;

    public static void main(String[] args) {

         String text1 = "abcde", text2 = "ace";
        //String text1 = "ylqpejqbalahwr", text2 = "yrkzavgdmdgtqpg";
        //String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd";
        //String text1 = "abcba", text2 = "abcbcba";//
        //String text1 = "bl", text2 = "yby";
        //String text1 = "oxcpqrsvwf", text2 = "shmtulqrypy";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(longestCommonSubsequenceMemo(text1, text2));
        System.out.println(longestCommonSubsequenceBottomUpMemo(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int maxVal = Integer.MIN_VALUE;
        Map<String, Integer> dp = new HashMap<>();
        for (int i = text1.length() - 1; i >= 0; i--) {
            List<Integer> indices = findAllOccurrences(text2, text1.charAt(i));
            int midMax = 0;
            for (int currIndex : indices) {
                int subProbMax = 0;
                if (currIndex >= 0) {
                    for (int j = i + 1; j < text1.length(); j++) {
                        char subChar = text1.charAt(j);
                        for (int k = currIndex + 1; k < text2.length(); k++) {
                            char subChar2 = text2.charAt(k);
                            if (subChar == subChar2) {
                                subProbMax = Math.max(subProbMax, dp.get(j + "," + k));
                                break;
                            }
                        }
                    }
                    subProbMax = subProbMax + 1;
                    dp.put(i + "," + currIndex, subProbMax);
                    midMax = Math.max(midMax, subProbMax);
                }
            }
            maxVal = Math.max(maxVal, midMax);
        }
        return maxVal;
    }

    public static List<Integer> findAllOccurrences(String str, char target) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                positions.add(i);
            }
        }
        return positions;
    }

    public static int longestCommonSubsequenceMemo(String text1, String text2) {

        Integer[][] memo = new Integer[text1.length()][text2.length()];
        int res =  rec( text1,  text2, memo, 0, 0);
        return res;
    }

    public static int rec(String text1, String text2, Integer[][] memo, int i, int j) {

        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }
        int maxx = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] =1+ rec( text1,  text2, memo, i+1, j+1);
        }else{
            memo[i][j] = Math.max(rec( text1,  text2, memo, i, j+1), rec( text1,  text2, memo, i+1, j));
        }
        return memo[i][j];
    }


   /* 🧠 Time and Space Complexity
    Complexity	Value
    Time	O(m × n) where m = length of text1, n = length of text2
    Space	O(m × n) due to 2D array*/
    public static int longestCommonSubsequenceBottomUpMemo(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=1;i< text1.length()+1;i++){
            for(int j=1;j< text2.length()+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
