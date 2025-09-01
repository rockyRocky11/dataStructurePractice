package com.data.structures.practice.hashtable.problems;

import java.util.HashMap;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        int sLen=s.length();
        int tLen =t.length();
        if(sLen != tLen){
            return false;
        }
        HashMap<Character, Integer> countingMap1 = new HashMap<>();

        int conter1 = 0;
        for (char array : s.toCharArray()) {
            countingMap1.put(array, countingMap1.getOrDefault(array, 0) + 1);
        }
        for(char array :t.toCharArray()){
            if(!countingMap1.containsKey(array) || countingMap1.get(array) <= 0)return false;
            countingMap1.put(array, countingMap1.get(array)-1);
            sLen--;
        }
        if(sLen>0)return false;
        return true;

    }

    public boolean isAnagramArray(String s, String t) {
        int sLen=s.length();
        int tLen =t.length();
        if(sLen != tLen){
            return false;
        }

        int[] c = new int[26];
        for (char a : s.toCharArray()) {
            c[a-'a']++;
        }
        for(char a :t.toCharArray()){
            if(c[a-'a']== 0)return false;
            c[a-'a']--;
        }
        for(int i=0;i<26;i++){
            if(c[i]!=0)return false;
        }
        //if(sLen>0)return false;
        return true;

    }

}
