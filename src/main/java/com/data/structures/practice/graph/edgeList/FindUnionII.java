package com.data.structures.practice.graph.edgeList;

import java.util.Arrays;

public class FindUnionII {
    public static void main(String[] args) {
       // int[][] edges ={{1,2},{1,3},{2,3}};//ans =[2, 3]
       int[][] edges ={{1,2},{2,3},{3,4},{4,1},{1,5}};//ans =[4, 1]
     //  int[][] edges ={{4,2},{1,5},{5,2},{5,3},{2,4}};//ans =[4, 2]
        System.out.println(Arrays.toString(findRedundantDirectedConnection(edges)));
    }

    /*✅ Final Answer
Time Complexity: O(n)

Space Complexity: O(n)*/
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        int[] cand1 = new int[2];
        int[] cand2 = new int[2];

        // Step 1: detect if a node has two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                edge[1] = 0; // disable cand2
            }
        }

        // reset parent for Union-Find
        for (int i = 1; i <= n; i++) parent[i] = i;

        // Step 2: Union-Find
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (v == 0) continue; // skip disabled edge
            if (!union(u, v, parent, rank)) {
                if (cand1[0] != 0) return cand1;
                return new int[]{u, v};
            }
        }
        return cand2;
    }

    public static int findParent(int x, int[] parent) {
        if (parent[x] != x) parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public static boolean union(int u, int v, int[] parent, int[] rank) {
        int pu = findParent(u, parent);
        int pv = findParent(v, parent);
        if (pu == pv) return false;
        parent[pv] = pu;
        return true;
    }
}
