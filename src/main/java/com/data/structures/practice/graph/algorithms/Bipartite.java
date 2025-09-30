package com.data.structures.practice.graph.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    /*🧠 Complexity

    Time: O(V + E) (visit each node + edge once)

    Space: O(V) for colors + recursion/queue*/
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1;// initially assigning 1 color

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {

                    if (color[v] == 0) {
                        color[v] = -color[u];
                        q.offer(v);
                    } else if (color[v] == color[u]) {
                        return false;
                    }

                }
            }
        }
        return true;
    }
}
