package com.data.structures.practice.graph.edgeList;

import java.util.ArrayList;
import java.util.List;

public class MinCostConnectPoints {

    /* Complexity:

Edges = O(N^2) (since every pair of points can connect).

Sorting edges = O(N^2 log N^2) = O(N^2 log N).

Union-Find operations ≈ O(N^2).*/
    class UnionFind {

        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int unionFindParent(int x){
            if(x != parent[x]){
                parent[x]=unionFindParent(parent[x]);
            }
            return parent[x];
        }

        boolean union(int u, int v) {
            int pu = unionFindParent(u);
            int pv = unionFindParent(v);
            if (pu == pv)
                return false;
            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
            return true;
        }

    }

    public int minCostConnectPoints(int[][] points) {

        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<points.length;i++){//p^2
            for(int j=i+1;j<points.length;j++){
                int w = Math.abs(points[i][0]-points[j][0])+ Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i, j, w});
            }
        }

        edges.sort((a,b) -> a[2]-b[2]);  //O(nlogn)--> number of edges
        UnionFind un=new UnionFind(points.length);
        int cost=0;
        int edgeUsed=0;
        for(int[] edge: edges){
            int u=edge[0];
            int v= edge[1];
            int w = edge[2];
            if(un.union(u,v)){
                cost+=w;
                edgeUsed++;
            }
            if(edgeUsed == points.length-1)break;
        }

        return cost;
    }
}
