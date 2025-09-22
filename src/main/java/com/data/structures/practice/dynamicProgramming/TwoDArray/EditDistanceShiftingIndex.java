package com.data.structures.practice.dynamicProgramming.TwoDArray;

public class EditDistanceShiftingIndex {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        //String word1 = "intention", word2 = "execution";

        System.out.println(minDistance(word1, word2));
        System.out.println(minDistanceMemo(word1, word2));
        System.out.println(minDistanceBottom(word1, word2));

    }

    public static int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    public static int dfs(String word1, String word2, int i, int j) {


        if(i == word1.length()){
            return word2.length()-j;
        }
        if(j == word2.length()){
            return word1.length()-i;
        }
        int insert =0;
        int delete =0;
        int replace =0;
        if(word1.charAt(i) == word2.charAt(j)){
           return dfs(word1, word2,  i+1, j+1);
        }
        else{
            //when you insert the word2 will automatically match, so just swift j by 1
             insert = 1+dfs(word1, word2,  i, j+1);
             //when you delete, you delete from word1, so swift i by 1
             delete = 1+dfs(word1, word2,  i+1, j);
             //when you repalce, you pick one from word2, so that will match with word1, so swift both by 1
             replace = 1+dfs(word1, word2,  i+1, j+1);

        }
        return Math.min(insert, Math.min(delete, replace));

    }

    public static int minDistanceMemo(String word1, String word2) {
        Integer[][] dp =new Integer[word1.length()][word2.length()];
        int res= dfsMemo(word1, word2, 0, 0, dp);
        return res;
    }

    public static int dfsMemo(String word1, String word2, int i, int j, Integer[][] dp) {

        //This is the trickiest part of imagine
        if(i == word1.length()){
            return word2.length()-j;
        }
        if(j == word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        int insert =0;
        int delete =0;
        int replace =0;
        if(word1.charAt(i) == word2.charAt(j)){
            return dfsMemo(word1, word2,  i+1, j+1, dp);
        }
        else{
            //when you insert the word2 will automatically match, so just swift j by 1
            insert = 1+dfsMemo(word1, word2,  i, j+1,  dp);
            //when you delete, you delete from word1, so swift i by 1
            delete = 1+dfsMemo(word1, word2,  i+1, j, dp);
            //when you repalce, you pick one from word2, so that will match with word1, so swift both by 1
            replace = 1+dfsMemo(word1, word2,  i+1, j+1, dp);

        }
        dp[i][j]= Math.min(insert, Math.min(delete, replace));
        return dp[i][j];
    }


    public static int minDistanceBottom(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp =new int[m+1][n+1];
        //fill base cases
        for(int i=0;i<m;i++){
            dp[i][n]=m-i;
        }
        for(int i=0;i<n;i++){
            dp[m][i]=n-i;
        }
        //Start from bottom because we can finish sub problems with the help of base cases
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                    int insert = 1+dp[i][j+1];
                    //when you delete, you delete from word1, so swift i by 1
                    int delete = 1+dp[i+1][j];
                    //when you repalce, you pick one from word2, so that will match with word1, so swift both by 1
                    int replace = 1+dp[i+1][j+1];
                    dp[i][j]= Math.min(insert, Math.min(delete, replace));
                }

            }
        }
        return dp[0][0];
    }

}
