package com.data.structures.practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;


/*3. Summary Table
Version	addNum() Time	findMedian() Time	Space
Your isOdd	O(log n) (lower constants)	O(1)	O(n)
Standard	O(log n) (higher constants)	O(1)	O(n)*/
public class MedianFinderHeapStandard {

    PriorityQueue<Integer> less;    // max-heap for lower half
    PriorityQueue<Integer> greater; // min-heap for upper half

    public MedianFinderHeapStandard() {
        less = new PriorityQueue<>(Collections.reverseOrder());
        greater = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Always push to max-heap first
        less.offer(num);

        // Step 2: Balance so that all numbers in less <= all in greater
        greater.offer(less.poll());

        // Step 3: Ensure size property: less >= greater
        if (less.size() < greater.size()) {
            less.offer(greater.poll());
        }
    }

    public double findMedian() {
        if (less.size() > greater.size()) {
            return less.peek();
        } else {
            return (less.peek() + greater.peek()) / 2.0;
        }
    }


    public static void main(String[] args) {

        /*MedianFinderHeap medianFinder = new MedianFinderHeap();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());*/

       /* MedianFinderHeap medianFinder = new MedianFinderHeap();
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());*/

       /*  MedianFinderHeap medianFinder = new MedianFinderHeap();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());*/

        MedianFinderHeapStandard medianFinder = new MedianFinderHeapStandard();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());

    }
}
