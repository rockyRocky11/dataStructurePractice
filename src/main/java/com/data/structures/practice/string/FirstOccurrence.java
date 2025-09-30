package com.data.structures.practice.string;

public class FirstOccurrence {
    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";
        //String haystack = "leetcode";
        //String needle = "leeto";
        //String haystack = "leet0";
        //String needle = "leetcode";
        //String haystack = "hello";
        //String needle = "ll";
        //String haystack = "a";
        //String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {

        int start = 0;
        int end = needle.length();
        int len = needle.length();
        if(needle.length()>haystack.length())return -1;
            while(start<=haystack.length() - len && end<=haystack.length()){
                String val = haystack.substring(start, end);
            if (val.equals(needle)) {
                return start;
            }
            start++;
            end=start+len;
        }
        return -1;
    }
}
