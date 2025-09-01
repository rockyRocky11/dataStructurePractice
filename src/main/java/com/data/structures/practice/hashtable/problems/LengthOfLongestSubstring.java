package com.data.structures.practice.hashtable.problems;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int res = 0;
        int start = 0;
        int end =0;
        int n = s.length();
        int[] store = new int[200];
        while(start <n && end <n){
            if(store[s.charAt(end)] >=start){
                start=store[s.charAt(end)];
            }
            store[s.charAt(end)]=end+1;
            end++;
            res = Math.max(res, (end-start));
        }
        return res;
    }
}
