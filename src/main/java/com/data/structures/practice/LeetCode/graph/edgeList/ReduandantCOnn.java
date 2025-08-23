package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.*;

public class ReduandantCOnn {

    public static void main(String[] args) {
        //int[][] edges ={{1,2},{2,3},{3,4},{1,4},{1,5}};//1,4
        int[][] edges ={{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            al.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            al.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int i = 1;
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        while (i <= n) {
            dfs(i, 0, visiting, al, cycle);
            i++;
        }
        for (int j=edges.length-1;j>=0;j--) {
            int u = edges[j][0];
            int v = edges[j][1];
            if(cycle.contains(u) && cycle.contains(v)){
                return new int[]{u,v};
            }
        }
        return new int[2];
    }

    public static void dfs(int v, int pv, Set<Integer> visiting, Map<Integer, List<Integer>> al, Set<Integer> cycle ) {

        if (visiting.contains(v)) {
            System.out.println("cycle "+v + " " + pv);
            cycle.add(v);
            cycle.add(pv);
            return ;
        }
        visiting.add(v);
        for (int n : al.getOrDefault(v, Collections.emptyList())) {

            if (n != pv) {
                System.out.println(v + " " + pv + " " + n);
                dfs(n, v, visiting, al, cycle);
            }
        }
        visiting.remove(v);
    }
}
