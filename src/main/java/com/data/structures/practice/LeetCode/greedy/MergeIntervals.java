package com.data.structures.practice.LeetCode.greedy;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{1,4},{4,5}};
        int[][] re= mergeGreedy(intervals);
        System.out.println(re);
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        List<int[]> time = new ArrayList<>();
        for(int[] interval: intervals){
            time.add(new int[]{interval[0], 1});
            time.add(new int[]{interval[1], -1});
        }
        time.sort((a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int start=time.get(0)[0];
        int meeting=1;
        for(int i=1;i<time.size();i++){
            if(meeting ==0){
                start=time.get(i)[0];
            }
            meeting+=time.get(i)[1];
            if(meeting ==0){
                res.add(new int[]{start, time.get(i)[0]});
            }
        }

        int[][] r = new int[res.size()][2];
        int index=0;
        for(int[] t: res){
            r[index][0]=t[0];
            r[index][1]=t[1];
            index++;
        }

        return r;
    }
    /*🕒 Time and Space Complexity
        Time Complexity: O(n log n) due to sorting, where n = intervals.length.

        Space Complexity: O(n) in the worst case, for storing the merged intervals in res.*/
    public static int[][] mergeGreedy(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        for(int i=0;i<n;i++){
            if(res.isEmpty() || res.get(res.size()-1)[1]<intervals[i][0]){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }else {
                res.set(res.size()-1,new int[]
                        {res.get(res.size()-1)[0]
                                ,Math.max(res.get(res.size()-1)[1],intervals[i][1])});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
