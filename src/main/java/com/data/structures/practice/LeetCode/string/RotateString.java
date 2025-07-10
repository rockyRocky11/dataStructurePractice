package com.data.structures.practice.LeetCode.string;

import java.util.HashMap;
import java.util.Map;

public class RotateString {

    public static void main(String[] args) {
        //String s = "abcde", goal = "cdeab";
        String s = "abcde", goal = "eabcd";
        //String s = "abcde", goal = "abced";

        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i + 1, s.length()) + s.substring(0, i + 1);
            if (temp.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static boolean rotateStringUsingBoyerMooreHorspool(String s1, String goal) {

        if (s1.length() != goal.length()) {
            return false;
        }
        String s = s1+s1;
        Map<Character, Integer> badTable = new HashMap<>();
        int len = goal.length();

        for (int i = 0; i < goal.length(); i++) {
            badTable.put(goal.charAt(i), (len - i - 1));
        }


        int i = len - 1;
        while (i < s.length()) {
            int incre = 1;
            int match =0;
            int start = i;
            for (int j = len - 1; j >=0; j--) {
                if (s.charAt(start) != goal.charAt(j)) {
                    incre=badTable.getOrDefault(s.charAt(start),len);
                    break;
                }else{
                    match++;
                    start--;
                }

            }
            if(match == len){
                return true;
            }
            i = i + incre;
        }
        return false;
    }
}
