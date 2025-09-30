package com.data.structures.practice.graph.algorithms;

import java.util.*;
public class TarjanBridge {
    int[] desc, low, parent;
    List<List<Integer>> bridges;
    List<List<Integer>> graph;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        desc = new int[n];
        low = new int[n];
        parent =new int[n];
        bridges = new ArrayList<>();
        graph= new ArrayList<>();
        time=0;
        for(int i=0;i<n;i++){
            desc[i]=-1;
            graph.add(new ArrayList<>());
        }
        for(List<Integer> edge: connections){
            int u= edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(desc[i]==-1)dfs(i);
        }
        return bridges;
    }

    public void dfs(int u){
        desc[u]=low[u]=time++;
        for(int v: graph.get(u)){
            if(desc[v]==-1){
                parent[v]=u;
                dfs(v);
                low[u]=Math.min(low[u],  low[v]);
                // bridge condition
                if(low[v]>desc[u]){
                    //this  is a bridge with edge back
                    bridges.add(List.of(u,v));
                }
            } else if(v != parent[u]){
                low[u]=Math.min(low[u],  desc[v]);
            }
        }
    }
}
