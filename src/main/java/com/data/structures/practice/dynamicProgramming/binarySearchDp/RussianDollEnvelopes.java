package com.data.structures.practice.dynamicProgramming.binarySearchDp;

import java.util.*;
public class RussianDollEnvelopes {
    public static void main(String[] args) {
       int[][] i = {{5,4},{6,4},{6,7},{2,3}};//3
        //int[][] i = {{30,50},{12,2},{3,4},{12,15}};//3
        //int[][] i = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};//5
        Solution solution = new Solution();
        SolutionIter solutioni = new SolutionIter();
        System.out.println(solution.maxEnvelopes(i));
        System.out.println(solutioni.maxEnvelopes(i));
    }
}

class SolutionIter {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        List<int[]> tail = new ArrayList<>();
        int n = envelopes.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            int[] ei = envelopes[i];
            int maxSub = 0;
            for (int j = i + 1; j < n; j++) {
                int[] ej = envelopes[j];
                if (ei[0] < ej[0] && ei[1] < ej[1]) {
                    maxSub = Math.max(maxSub, dp[j]);
                }
            }
            maxSub=1+maxSub;
            res = Math.max(res, maxSub);
            dp[i] = maxSub;

        }
        return res;
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        List<int[]> tail = new ArrayList<>();
        for(int[] en: envelopes){
            if(tail.isEmpty() || en[0]>tail.get(tail.size()-1)[0] && en[1]>tail.get(tail.size()-1)[1]){
                tail.add(en);
            }else{
               // if(en[0] == tail.get(tail.size()-1)[0] || en[1] ==tail.get(tail.size()-1)[1])continue;
                int left =0,right = tail.size();
                while(left<right){
                    int mid = left+(right-left)/2;
                    if(tail.get(mid)[0] <en[0] && tail.get(mid)[1] <en[1]){
                        left=mid+1;
                    }else{
                        right =mid;
                    }
                }
                tail.set(left, en);
            }
        }
        return tail.size();
    }

}
