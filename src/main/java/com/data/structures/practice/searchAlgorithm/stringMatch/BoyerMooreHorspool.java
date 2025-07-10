package com.data.structures.practice.searchAlgorithm.stringMatch;

import java.util.*;

public class BoyerMooreHorspool {
    public static void main(String[] args) {
        //String s = "abcde", goal = "cdeab";
        String s = "abcde", goal = "eabcd";
        //String s = "abcde", goal = "abced";

       // System.out.println(rotateStringUsingBoyerMooreHorspool(s, goal));

        //String s1 = "bantlaf", goal1 = "ant";
        String s1 = "mwjpqffpbxbhxsdqbgcnplqtjklgpfgiqpxsjkjmhjlrkjiccb", goal1 = "hxsdqbgcnplqtjklgpfgiqpxsjkjmhjlrkjiccbmwjpqffpbxb";

        System.out.println(rotateStringUsingBoyerMooreHorspool(s1, goal1));


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

    public static boolean isSubstringUsingBoyerMooreHorspool(String s, String goal) {
        int len = goal.length();
        int slen = s.length();

        if (len > slen) return false;

        // Build bad character shift table
        Map<Character, Integer> badTable = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            badTable.put(goal.charAt(i), len - i - 1);
        }

        int i = len - 1;

        while (i < slen) {
            int j = len - 1;
            int k = i;

            while (j >= 0 && s.charAt(k) == goal.charAt(j)) {
                j--;
                k--;
            }

            if (j < 0) {
                return true; // Match found
            }

            char mismatchedChar = s.charAt(i);
            int shift = badTable.getOrDefault(mismatchedChar, len);
            i += shift;
        }

        return false;
    }
}
