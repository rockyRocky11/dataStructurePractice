package com.data.structures.practice.graph.edgeList;

import java.util.*;
public class Network {
    public int networkDelayTime(int[][] times, int n, int k) {

        //Preparing Adjacent List
        Map<Integer, List<int[]>> al = new HashMap<>();
        for(int[] time: times){
            int u = time[0];//source
            int v = time[1];//target
            int w = time[2];
            al.computeIfAbsent(u, k1-> new ArrayList<>()).add(new int[]{v,w});
        }
        // System.out.println(al);

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){

            int[] temp = pq.poll();
            int d = temp[0];
            int u = temp[1];
            //System.out.println("qu "+u);
            if(d>dist[u])continue;

            for(int[] nei: al.getOrDefault(u, Collections.emptyList())){
                int node = nei[0];
                // System.out.println("n "+node);
                int w = nei[1];
                // System.out.println("w "+(d+w));
                if(d+w<dist[node]){
                    dist[node]=d+w;
                    pq.offer(new int[]{d+w, node});
                }
            }

        }
        // System.out.println(Arrays.toString(dist));
        int ans = Integer.MIN_VALUE;
        for(int num: dist){
            if(num == Integer.MAX_VALUE)return -1;
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
