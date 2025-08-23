package com.data.structures.practice.LeetCode.graph.algorithms;

import java.util.*;

public class TarjansScc {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int n=3;
        for(int  i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // Example directed graph
        graph.get(0).add(2);
        graph.get(2).add(1);
        graph.get(1).add(0);/*
        graph.get(0).add(3);
        graph.get(3).add(4);*/
        System.out.println(tarjanSCC(n, graph));
    }

    static int[] disc, low;
    static Deque<Integer> stack;
    static boolean[] stackMember;
    static int time;
    static List<List<Integer>> sccList;
    public static List<List<Integer>> tarjanSCC(int n, List<List<Integer>> graph){
        disc = new int[n];
        low = new int[n];
        stack = new ArrayDeque<>();
      //  stackMember = new boolean[n];
        sccList = new ArrayList<>();

        Arrays.fill(disc, -1);// unvisited

        for(int i=0;i<n;i++){
            if(disc[i]==-1){
                dfs(i, graph);
            }
        }

        return sccList;

    }

    public  static  void dfs(int u, List<List<Integer>> graph){
        disc[u]=low[u]=time++;
        stack.push(u);
       // stackMember[u]=true;
        for(int v: graph.get(u)){
            if(disc[v]==-1){
                //new edge
                dfs(v, graph);
                low[u]= Math.min(low[u], low[v]);
            }else{
                //back edge
                low[u]=Math.min(low[u], disc[v]);
            }
        }

        // if u is the root of SCC
        if(low[u]==disc[u]){
            List<Integer> ssc = new ArrayList<>();
            while(true){
                int v = stack.pop();
                ssc.add(v);
              //  stackMember[v]=false;
                if( u==v)break;
            }
            sccList.add(ssc);
        }

    }

}
