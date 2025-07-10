package com.data.structures.practice.LeetCode.string;

public class LongestPrefix {
    public static void main(String[] args) {
        //String[] strs = {"a"};
         String[] strs = {"flower", "flow", "flight"};
        //String[] strs = {"dog", "racecar", "car"};
        //String[] strs = {"a","a","b"};
        //String[] strs = {"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixReverse(strs));
        System.out.println(longestCommonPrefixWithIndexOF(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String firstArg = strs[0];
        String res = "";
        String response = firstArg;
        int max = 0;
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = firstArg.length(); i > 0; i--) {
            response = firstArg.substring(0, i);
            int counter = 1;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() >= response.length() && response.equals(strs[j].substring(0, i))) {
                    counter++;
                }
            }
            if (counter == strs.length && response.length() > max) {
                res = response;
                max = response.length();
            }
        }
        return res;
    }

    public static String longestCommonPrefixReverse(String[] strs) {
        String firstArg = strs[0];
        String res = "";
        String response = strs[0];
        int max = 0;
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i <= firstArg.length(); i++) {
            response = firstArg.substring(0, i);
            int counter = 1;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() >= response.length() && response.equals(strs[j].substring(0, i))) {
                    counter++;
                }
            }
            if (counter != strs.length) {
               break;
            }
            else{
                res = response;
            }
        }
        return res;
    }

    public static String longestCommonPrefixWithIndexOF(String[] strs) {
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
