package com.data.structures.practice.graph.edgeList;

import java.util.Arrays;

public class FindCheapestPrice {

    //Bellman–Ford

    /*✅ Final:

    Time = O(kE)

    Space = O(n)*/
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.MAX_VALUE;
        }
        temp[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] dist = Arrays.copyOf(temp, n);
            for (int[] edge : flights) {
                int s = edge[0];
                int d = edge[1];
                int p = edge[2];

                if (temp[s] != Integer.MAX_VALUE && temp[s] + p < dist[d]) {
                    dist[d] = temp[s] + p;
                }

            }
            temp = dist;
        }

        return temp[dst] == Integer.MAX_VALUE ? -1 : temp[dst];
    }
}
