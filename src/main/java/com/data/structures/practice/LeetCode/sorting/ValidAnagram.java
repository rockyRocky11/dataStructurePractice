package com.data.structures.practice.LeetCode.sorting;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        //String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        //String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramUsingReplace(s, t));
        System.out.println(isAnagramUsingMap(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        String[] array1 = s.split("");
        String[] array2 = t.split("");

        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.toString(array1).equals(Arrays.toString(array2));

    }

    public static boolean isAnagramUsingMap(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        String[] array1 = s.split("");
        String[] array2 = t.split("");
        HashMap<String, Integer> countingMap1 = new HashMap<>();
        HashMap<String, Integer> countingMap2 = new HashMap<>();

        int conter1 = 0;
        for (String array : array1) {
            countingMap1.put(array, countingMap1.getOrDefault(array, 1) + 1);
        }
        for(String array :array2){
            if(!countingMap1.containsKey(array))return false;
            countingMap1.put(array, countingMap1.get(array)-1);
        }


        for (Integer count : countingMap1.values()) {
            if (count !=1) {
                return false;

            }
        }
        return true;
    }
    public boolean isAnagramUsingCounter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : t.toCharArray()) {
            count[c]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }

    public static boolean isAnagramUsingReplace(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        String original = s;
        for(int i=0;i<original.length();i++){
            String c = original.charAt(i)+"";
            s=s.replaceFirst(c,"");
            t=t.replaceFirst(c,"");
        }
        if(s.equals(t)){
            return true;
        }
        return false;
    }

}
