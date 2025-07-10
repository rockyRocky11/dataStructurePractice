package com.data.structures.practice.LeetCode.string;

import java.util.HashMap;
import java.util.Map;

public class CompressedString {
    public static void main(String[] args) {
        //String s = "abcde";
        String s = "mrm";
        //String s = "ft";
        //String s = "aaaaaaaaaaaaaabb";

        System.out.println(compressedString(s));

    }
    public static String compressedString(String word) {
        StringBuilder response = new StringBuilder();
        int count =1;
        char prev =word.charAt(0);
        if (word.length() == 1) {
            response.append(1);
            response.append(prev);
            return response.toString();
        }
        for(int i=1;i<word.length();i++){
            char curr = word.charAt(i);

            if(prev == curr){
                count++;
                if(count>9){
                    response.append(9);
                    response.append(prev);
                    count=1;
                }

                if(i == word.length()-1){
                    response.append(count);
                    response.append(prev);
                }
            }else{
                response.append(count);
                response.append(prev);
                prev = curr;
                count=1;
                if(i == word.length()-1){
                    response.append(count);
                    response.append(prev);
                }
            }


        }
        return response.toString();
    }

    public static String compressedStringMapDidNtWork(String word) {

        StringBuilder response = new StringBuilder();
        Map<Character, Integer> countingMap = new HashMap<>();
        char[] wordArray = word.toCharArray();
        for(char a: wordArray){
            countingMap.put(a, countingMap.getOrDefault(a,0)+1);
        }
        for(int i=0;i<word.length();i++){
            if(countingMap.get(word.charAt(i))>0) {
                if (countingMap.get(word.charAt(i)) <= 9) {
                    response.append(countingMap.get(word.charAt(i)));
                    response.append(word.charAt(i));
                } else {
                    int count = countingMap.get(word.charAt(i));
                    while (count > 0) {
                        if (count > 9) {
                            response.append(9);
                            response.append(word.charAt(i));
                            count = count - 9;
                        } else {
                            response.append(count);
                            response.append(word.charAt(i));
                            count = 0;
                        }
                    }
                }
                countingMap.put(word.charAt(i),0);
            }
        }
        return response.toString();
    }
}
