package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.Arrays;

public class FindUnion {
    public static void main(String[] args) {
        //int[][] edges ={{1,2},{2,3},{3,4},{4,1},{1,5}};//ans =[4, 1]
        int[][] edges ={ {1,2}, {2,3}, {4,5}};//ans =[4, 1]
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    /*Time Complexity: O(N α(N)) ≈ O(N) (inverse Ackermann).

    Space Complexity: O(N).*/
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!union(u, v, parent, rank))
                return new int[] { u, v };
        }
        return new int[2];
    }

    public static int findParent(int x, int[] parent){
        if(x != parent[x]){
            parent[x]=findParent(parent[x], parent);
        }
        return parent[x];
    }

    public static boolean union(int u, int v, int[] parent, int[] rank){
        int pu = findParent(u, parent);
        int pv = findParent(v, parent);
        if(pu == pv)return false;
        if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        } else if(rank[pv]<rank[pu]){
            parent[pv]=pu;
        }else{
            parent[pv]=pu;
            rank[pu]++;
        }
        return true;
    }
}
