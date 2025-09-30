package com.data.structures.practice.dynamicProgramming.TwoDArray;

public class EditDistanceBruteForce {
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //String word1 = "horse", word2 = "ros";
        String word1 = "intention", word2 = "execution";

        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {
        minCount = Integer.MAX_VALUE;
        dfs(word1, word2, 0);
        return minCount;
    }

    public static void dfs(String word1, String word2, int count) {

        if (word1.equals(word2)) {
            minCount = Math.min(minCount, count);
            return;
        }

        boolean insert = false;
        String insertString = "";
        for (int i = 0; i < word2.length(); i++) {
            if ( i>= word1.length() || word1.charAt(i) != word2.charAt(i)) {
                insertString = word1.substring(0, i) + word2.charAt(i) + word1.substring(i);
                insert = true;
                break;
            }
        }
        if (insert) {
            dfs(insertString, word2, count + 1);
        }

        boolean delete = false;
        String deleteString = "";
        for (int i = 0; i < word1.length(); i++) {
            if (i>= word2.length() || word1.charAt(i) != word2.charAt(i)) {
                deleteString = word1.substring(0, i) + word1.substring(i+1);
                delete = true;
                break;
            }
        }
        if (delete) {
            dfs(deleteString, word2, count + 1);
        }

        boolean replace = false;
        String replaceString = "";
        for (int i = 0; i < word2.length(); i++) {
            if ( i>= word1.length() ) {
                replaceString = word1.substring(0, i) + word2.charAt(i);
                replace = true;
                break;
            }
            else  if ( word1.charAt(i) != word2.charAt(i)) {
                replaceString = word1.substring(0, i) + word2.charAt(i) + word1.substring(i+1);
                replace = true;
                break;
            }
        }
        if (replace) {
            dfs(replaceString, word2, count + 1);
        }

    }

}
