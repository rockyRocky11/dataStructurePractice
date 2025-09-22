package com.data.structures.practice.greedy.sweepLine;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CoveredLine {
    public static void main(String[] args) {
        //int[][] intervals ={{1,4},{3,6},{2,8}};
        //int[][] intervals ={{3,10},{4,10},{5,11}};
        int[][] intervals ={{1,2},{1,4},{3,4}};
System.out.println(removeCoveredIntervals(intervals));
    }

  /*  ✅ Time Complexity: O(N log N)
Arrays.sort(...): O(N log N) — sorting the intervals.

for loop with maxHeap.poll() and maxHeap.offer():

    Each offer and poll takes O(log K), where K is the size of the heap.

    In the worst case, we do both operations for each interval ⇒ total heap operations = O(N log N).

    Therefore, overall time is O(N log N).

            ✅ Space Complexity: O(N)
    The maxHeap stores at most N elements in the worst case ⇒ O(N).

    The input sort is in-place (though it may use small stack space), so main additional space is due to the heap.*/
        public static int removeCoveredIntervals(int[][] intervals) {

            Arrays.sort(intervals, (a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int res=0;
            for(int[] interval: intervals){
                if(!maxHeap.isEmpty() && interval[1]>maxHeap.peek() ){
                    maxHeap.poll();
                    res++;
                }
                maxHeap.offer(interval[1]);
            }
            return res+1;
        }


       /*
        ✅ Time Complexity: O(N log N)
    Sorting: O(N log N)

    Single pass through intervals: O(N)

    Total: O(N log N)

✅ Space Complexity: O(1) (excluding input)
    Only a few variables (res, end) used.

    In-place sorting doesn’t need extra space (apart from call stack).*/
    public int removeCoveredIntervalsWithoutHeap(int[][] intervals) {

        Arrays.sort(intervals, (a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int res=0;
        int end=intervals[0][1];
        for(int[] interval: intervals){
            if( interval[1]>end ){
                end =interval[1];
                res++;
            }

        }
        return res+1;
    }
}
