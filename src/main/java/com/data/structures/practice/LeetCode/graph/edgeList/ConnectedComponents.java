package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.Arrays;

public class ConnectedComponents {

    /*Time and Space Complexity
    Part	Time	Space
    Initialization	O(n)	O(n)
    Union all edges	O(E * α(n))	O(1) extra
    Count components	O(n)	O(1) extra
    Overall	O(n + E * α(n)) ≈ O(n + E)	O(n)

    α(n) is very slow-growing (≤ 5 for practical n), so almost linear.*/
    public static void main(String[] args) {
        //int[][] edges ={{1,2},{2,3},{3,4},{4,1},{1,5}};//ans =[4, 1]
        int[][] edges ={{0,1}, {1,2}, {2,3}, {4,5}};//ans =[4, 1]
        int n=6;
        System.out.println(countComponents(n, edges));
    }

    /*Time Complexity: O(N α(N)) ≈ O(N) (inverse Ackermann).

    Space Complexity: O(N).*/
    public static int countComponents( int n, int[][] edges) {
        int[] parent = new int[n ];
        int[] rank = new int[n ];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank);
        }
        int ans=0;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == i)ans++;
        }
        return ans;
    }

    public static int findParent(int x, int[] parent){
        if(x != parent[x]){
            parent[x]=findParent(parent[x], parent);
        }
        return parent[x];
    }

    public static void union(int u, int v, int[] parent, int[] rank){
        int pu = findParent(u, parent);
        int pv = findParent(v, parent);
        if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        } else if(rank[pv]<rank[pu]){
            parent[pv]=pu;
        }else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }
}
