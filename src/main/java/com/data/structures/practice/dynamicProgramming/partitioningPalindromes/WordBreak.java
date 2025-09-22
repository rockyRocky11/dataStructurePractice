package com.data.structures.practice.dynamicProgramming.partitioningPalindromes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
}

class SolutionWordBreakBottomUpDP {
    Set<String> set;
    int n;
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j,i);
                //System.out.println(sub+" "+j+" "+i+" "+dp[j]);
                if(dp[j] && set.contains(sub)){
                    dp[i]=true;
                    break;//Optimaization we already found the match for index i, now move on to next
                }
            }
        }

        return dp[n];
    }

}

//With memoization → O(n²):
class SolutionWordBreakRec {
    Set<String> set;
    int n;
    int[] dp ;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        dp = new int[n+1];
        return  rec(s, 0);
    }

    public boolean rec(String s, int idx){

        if(idx>=n)return true;
        if(dp[idx] !=0){
            return dp[idx]==1;
        }
        boolean res=false;
        for(int i=idx;i<n;i++){
            String sub = s.substring(idx, i+1);
            //System.out.println(sub);
            if(set.contains(sub)){
                if(rec(s, i+1)){
                    dp[idx]=1;
                    return true;
                }
            }
        }
        dp[idx]=-1;
        return  false;
    }
}
