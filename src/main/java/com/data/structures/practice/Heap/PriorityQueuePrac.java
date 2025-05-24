package com.data.structures.practice.Heap;

import java.util.PriorityQueue;

public class PriorityQueuePrac {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
        System.out.println("Peek :"+pq.peek());
        System.out.println("Remove :"+pq.remove());
        System.out.println("Peek :"+pq.peek());
        System.out.println("Poll :"+pq.poll());
        System.out.println("Peek :"+pq.peek());



    }
}
