package com.data.structures.practice.graph.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteDFS {

    /*🧠 Complexity

    Time: O(V + E) (visit each node + edge once)

    Space: O(V) for colors + recursion/queue*/
    int[] color;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1, graph))
                    return false;
            }

        }
        return true;

    }

    public boolean dfs(int u, int c, int[][] graph) {

        color[u] = c;

        for (int v : graph[u]) {

            if (color[v] == 0) {
                if (!dfs(v, -c, graph))
                    return false;
            } else if (color[v] == c) {
                return false;
            }

        }
        return true;

    }
}
