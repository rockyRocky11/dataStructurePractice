package com.data.structures.practice.dynamicProgramming.knapsack.subSetKnapsack;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    //Time n* nlogn --> n^2 logn

    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if (n == 1)
            return stones[0];
        int i = n - 2;
        int j = n - 1;
        //System.out.println(i + " " + j);
        while (i >= 0) {
            Arrays.sort(stones);
            if (stones[i] == stones[j]) {
                i -= 2;
                j -= 2;
            } else {
                stones[i] = stones[j] - stones[i];
                i--;
                j--;
            }
            //System.out.println(i + " " + j);
        }
        return j == 0 ? stones[0] : 0;
    }

    //Time n* logn --> n logn

    public int lastStoneWeightPQ(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int n: stones){
            pq.offer(n);
        }
        //System.out.println(pq);
        while(pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                pq.offer(a-b);
            }
            // System.out.println(pq);
        }
        return pq.size()==0?0:pq.poll();
    }
}
