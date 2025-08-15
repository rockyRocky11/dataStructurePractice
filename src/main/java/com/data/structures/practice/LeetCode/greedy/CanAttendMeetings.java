package com.data.structures.practice.LeetCode.greedy;


// Definition of Interval:

import java.util.*;

public class CanAttendMeetings {
    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();
       /* intervals.add(new Interval(0,30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));*/
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(4, 8));
        intervals.add(new Interval(5, 9));

        System.out.println(canAttendMeetings(intervals));
        System.out.println(canAttendMeetingsTwo(intervals));
        System.out.println(canAttendMeetingsTwoUsingSweep(intervals));

    }

    public static boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort((a, b) -> a.end - b.end);
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;

    }

  /*  🕒 Time Complexity:
    O(n log n) for sorting + O(n log n) for heap operations ⇒ O(n log n) overall

    n is the number of meetings*/

   /* 🧠 Space:
    O(n) for the heap*/
    public static int canAttendMeetingsTwo(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();

    }

    public static int canAttendMeetingsTwoUsingSweep(List<Interval> intervals) {
        int n=intervals.size();
        List<int[]> time = new ArrayList<>();
        for(Interval interval:intervals){
            time.add(new int[]{interval.start,1});
            time.add(new int[]{interval.end,-1});
        }
        //if time is same, then we need to know if its start or end, we want exit first, so we can put them in one day
        time.sort((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int res=0;
        int count=0;
        for(int[] tm: time){
            count+=tm[1];
            res = Math.max(res, count);
        }
        return res;
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
