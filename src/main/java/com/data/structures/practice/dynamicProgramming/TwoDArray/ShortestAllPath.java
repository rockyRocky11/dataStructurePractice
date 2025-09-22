package com.data.structures.practice.dynamicProgramming.TwoDArray;

import java.util.*;

class State{
    int mask;
    int node;
    int dis;
    State(int mask, int node, int dis){
        this.mask = mask;
        this.node = node;
        this.dis = dis;
    }


}

public class ShortestAllPath {

   /* We BFS over states:
    A state is (node, mask)
    node → one of n nodes
    mask → which subset of nodes has been visited → 2^n possibilities
    So total states = n * 2^n.*/

    /*🔹 Space Complexity
    We store:
    visited[node][mask] → n * 2^n booleans
    The BFS queue (in worst case) can also hold O(n * 2^n) states.
👉 Space complexity = O(n · 2ⁿ)*/


    public static void main(String[] args) {
        //int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        int[][] graph = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        System.out.println(shortestPathLength(graph));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisited = (1 << n)-1;

        boolean[][] visied = new boolean[n][1<<n];
        Queue<State> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            q.offer(new State(1<<i, i, 0 ));
        }
        while (!q.isEmpty()){
            State cur = q.poll();
            if(cur.mask == allVisited)return cur.dis;

            for(int v: graph[cur.node]){
                int nextMask = cur.mask | 1<<v;
                if(!visied[v][nextMask]){
                    visied[v][nextMask] = true;
                    q.offer(new State(nextMask, v, cur.dis+1 ));
                }
            }
        }

        return -1;
    }
}
