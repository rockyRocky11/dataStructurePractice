package com.data.structures.practice.LeetCode.greedy;

public class BalancedString {
    public static void main(String[] args) {
        //String s = "RLRRLLRLRL";
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {

        int subString = 0;
        int balanceCounter = 0;
        //assume R is 1 and L is -1

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                balanceCounter++;
            } else {
                balanceCounter--;
            }

            if (balanceCounter == 0) {
                subString++;
            }
        }
        return subString;
    }
}
