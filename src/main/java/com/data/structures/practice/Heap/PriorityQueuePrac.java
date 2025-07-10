package com.data.structures.practice.Heap;

import java.util.Collections;
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
//        System.out.println("Peek :"+pq.peek());
//        System.out.println("Remove :"+pq.remove());
//        System.out.println("Peek :"+pq.peek());
//        System.out.println("Poll :"+pq.poll());
//        System.out.println("Peek :"+pq.peek());
        System.out.println("Array Here");
        Object[] ints6 = pq.toArray();
        for(Object num:ints6){
            System.out.println(num);
        }
        System.out.println("Remove :"+pq.remove(54));
//        System.out.println("Peek :"+pq.peek());
//        System.out.println("Remove :"+pq.remove(55));
        System.out.println("Array Here");
        Object[] ints = pq.toArray();
        for(Object num:ints){
            System.out.println(num);
        }


        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

        // Add elements to the priority queue
        maxPQ.add(10);
        maxPQ.add(30);
        maxPQ.add(1);

        maxPQ.add(20);
        maxPQ.add(5);
        System.out.println("Array Here");


        // Remove and print elements from the priority queue
        Object[] ints1 = maxPQ.toArray();
        for(Object num:ints1){
            System.out.println(num);
        }

        maxPQ.remove(10);
        Object[] ints2 = maxPQ.toArray();
        for(Object num:ints2){
            System.out.println(num);
        }

    }
}
