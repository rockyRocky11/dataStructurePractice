package com.data.structures.practice.LeetCode.graph.matrix;

public class NumberOfProvinces {


    /*⏱️ Complexity
    Time: O(n^2) because adjacency matrix has n^2 entries.

            Space: O(n) for visited + recursion stack.*/
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int[] v = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (v[i] == 0) {
                dfs(isConnected, i, v);
                ans++;
            }

        }
        return ans;
    }

    public void dfs(int[][] isConnected, int src, int[] v) {
        if (v[src] == 1)
            return;
        v[src] = 1;
        for (int i = 0; i < isConnected[0].length; i++) {
            if (isConnected[src][i] == 1) {
                dfs(isConnected, i, v);
            }
        }

    }
}
