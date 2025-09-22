package com.data.structures.practice.dynamicProgramming.TwoDArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindCheapestPrice {
    public static void main(String[] args) {
       int n = 4;
       int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
       int src = 0, dst = 3, k = 1;

       System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    //This is a graph problem
    /*✅ Summary
    Aspect	Complexity
    Time	O(n * K * E)
    Space (DP)	O(n * K)
    Space (graph)	O(E)
    Stack depth	O(K)*/
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        //Building adjacency list
        List<int[]>[] graph = new List[n];
        for(int i=0;i<n;i++)graph[i]= new ArrayList<>();

        for(int[] f: flights){
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        Integer[][] dp =new Integer[n][K+2];//dp size is k+2, because we consider k=0 as invalid

        int ans = dfs(flights, graph, src, dst, K+1, dp);
        return ans == Integer.MAX_VALUE?-1: ans;
    }

    public static int dfs(int[][] flights, List<int[]>[] graph, int node, int dst, int stopsRem, Integer[][] dp){

        if(node == dst)return 0;

        if(stopsRem ==0)return Integer.MAX_VALUE;

        if(dp[node][stopsRem] != null)return dp[node][stopsRem];
        int minCost = Integer.MAX_VALUE;
        for(int[] nei: graph[node]){
            int nextPlaceCost = dfs(flights, graph, nei[0], dst, stopsRem-1, dp);
            if(nextPlaceCost != Integer.MAX_VALUE){
                minCost = Math.min(nextPlaceCost+ nei[1], minCost);
            }
        }
        dp[node][stopsRem]=minCost;
        return minCost;
    }

}
