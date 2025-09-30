package com.data.structures.practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;


/*3. Summary Table
Version	addNum() Time	findMedian() Time	Space
Your isOdd	O(log n) (lower constants)	O(1)	O(n)
Standard	O(log n) (higher constants)	O(1)	O(n)*/
public class MedianFinderHeapMyBetterVersion {

    PriorityQueue<Integer> less;
    PriorityQueue<Integer> greater;
    boolean isOdd;


    public MedianFinderHeapMyBetterVersion() {
        less = new PriorityQueue<>(Collections.reverseOrder());
        greater = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (less.isEmpty() && greater.isEmpty()) {
            less.offer(num);
            isOdd = !isOdd;
            return;
        }


      if(isOdd){

          if(num<less.peek()){
              greater.offer(less.poll());
              less.offer(num);
          }else{
              greater.offer(num);
          }

      }else{
          if(num>greater.peek()){
              less.offer(greater.poll());
              greater.offer(num);
          }else {
              less.offer(num);
          }
      }


        isOdd = !isOdd;

    }

    public double findMedian() {

        if (isOdd) {
            return less.peek()!=null? less.peek():0.0;
        }
        return (double) ((less.peek() != null ? less.peek() : 0) + (greater.peek() != null ? greater.peek() : 0)) / 2;
    }


    public static void main(String[] args) {

        /*MedianFinderHeap2 medianFinder = new MedianFinderHeap2();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());*/

        MedianFinderHeapMyBetterVersion medianFinder = new MedianFinderHeapMyBetterVersion();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());


       /* MedianFinderHeap medianFinder = new MedianFinderHeap();
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());*/

         /*MedianFinderHeap2 medianFinder = new MedianFinderHeap2();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());*/

        /*MedianFinderHeap2 medianFinder = new MedianFinderHeap2();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());*/

    }
}
