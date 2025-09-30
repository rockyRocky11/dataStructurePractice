package com.data.structures.practice.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class OccurrenceCheck {
    public static void main(String[] args) {
        String s = "abacbc";
        //String s = "aaabb";
        //String s = "a";
       //String s = "tveixwaeoezcf";
       //String s = "fhojjkontbncdhwxbnexplclvjyexzsvqyyhpfpnvhdskuhkuoihiqgalklqketjikdlgrawhfo";
//System.out.println(areOccurrencesEqual(s));
//System.out.println(areOccurrencesEqualWithMOD(s));
System.out.println(areOccurrencesEqualWithAsCII2(s));
    }

    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> response = new HashMap<>();
        for(char c: s.toCharArray()){
            response.put(c, response.getOrDefault(c,0)+1);
        }
        int prevCount = response.get(s.charAt(0));
       for(int currentCount: response.values()){
           if(prevCount!=currentCount){
               return false;
           }
       }

    return true;
    }

    public static boolean areOccurrencesEqualWithMOD(String s) {
        String[] inputArray = s.split("");
        Map<String, Integer> response = new HashMap<>();
        int uniqueElements = 0;
        int maxCount = 0;
        for (int i = 0; i < inputArray.length; i++) {
            Integer currentValue = response.get(inputArray[i]);
            if (currentValue != null) {
                response.put(inputArray[i], currentValue + 1);
                currentValue=currentValue+1;

            } else {
                uniqueElements++;
                response.put(inputArray[i], 1);
                currentValue=1;
            }
            if (currentValue > maxCount) {
                maxCount =currentValue;
            }
        }

        return uniqueElements * maxCount == s.length();
    }

    public static boolean doubleLoop(String s) {
        String[] inputArray = s.split("");
        if(s.length()-1 ==0){
            return true;
        }
        int prevCounter =0;
        for (int i = 0; i < inputArray.length; i++) {
             String  currentValue= inputArray[i];
             int counter =0;
            for (int j = 0; j < inputArray.length; j++) {
                if(i!=j && currentValue.equals(inputArray[j])){
                    counter=counter+1;
                }

            }
            if(i==0){
                prevCounter = counter;
            }
            if(prevCounter !=counter){
                return false;
            }

        }
        return true;
    }

    public static boolean areOccurrencesEqualWithAsCII(String s) {
        int freq[] = new int[26];
        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i)-97]++;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<26 ; i++){
            if(st.isEmpty() && freq[i]!=0) st.push(freq[i]);
            else if(freq[i]!= 0 && st.peek()!= freq[i]) return false;
        }
        return true;
    }

    public static boolean areOccurrencesEqualWithAsCII2(String s) {
        int freq[] = new int[26];
        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i)-97]++;
        }
        int prevValue = 0;
        for(int i = 0; i<26 ; i++){
            if(prevValue ==0 && freq[i] !=0){
                prevValue=freq[i];
            }
            if(freq[i] !=0 && freq[i] !=prevValue)return false;

        }
        return true;
    }
}
