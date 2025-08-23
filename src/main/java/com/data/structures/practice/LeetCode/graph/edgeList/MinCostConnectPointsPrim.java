package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*🔹 Complexity
Time: O(n^2 log n)

For each of n nodes, we may push up to n edges into the heap.

Space: O(n^2) worst case (heap can hold many edges).*/
public class MinCostConnectPointsPrim {

    public int minCostConnectPoints(int[][] points) {

        int cost = 0;
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);//We need the neighbor with less weight to form MST
        pq.offer(new  int[]{0,0});//Starting with 0 node with  0 weight
        boolean[] mst = new boolean[n];
        int eu =0;

        //O(n^2logn)
        while(eu<n){//O(n)
            int[] cur = pq.poll();
            int u = cur[0];
            int w = cur[1];
            if(mst[u])continue;
            // System.out.println(u+" "+w);
            mst[u]=true;
            eu++;
            cost+=w;

            //O(nlogn)
            for(int v=0;v<n;v++){//try to find the node with less weight that can be added to the curr node
                if(!mst[v]){
                    int vw = Math.abs(points[u][0]-points[v][0]) + Math.abs(points[u][1]-points[v][1]);
                    pq.offer(new int[]{v, vw});//O(logn)
                }
            }
        }

        return cost;
    }
  /*  O(n^2) time, O(n)*/

    public int minCostConnectPointsWithArray(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];   // Tracks nodes already in MST
        int[] minDist = new int[n];         // Min edge cost to connect node
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;  // Start with node 0, cost 0
        int cost = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            // Pick the non-MST node with the smallest edge cost
            for (int v = 0; v < n; v++) {
                if (!inMST[v] && (u == -1 || minDist[v] < minDist[u])) {
                    u = v;
                }
            }

            // Add this node to MST
            inMST[u] = true;
            cost += minDist[u];

            // Update minDist[] for remaining nodes
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0])
                            + Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }

        return cost;
    }
}
