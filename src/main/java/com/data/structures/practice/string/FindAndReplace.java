package com.data.structures.practice.string;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplace {
    public static void main(String[] args) {
        //String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String[] words = {"badc", "abab", "dddd", "dede", "yyxx"}; //["abab","dede"]
        //  String pattern = "abb";
        String pattern = "baba";
        System.out.println(findAndReplacePattern(words, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {


        List<String> response = new ArrayList<>();

        for (String word : words) {
            boolean wordsMatched = true;
            int[] freqPattern = new int[26];
            int[] freqWord = new int[26];
            for (int i = 0; i < word.length(); i++) {

                int patterIndex = pattern.charAt(i) - 'a';
                int wordIndex = word.charAt(i) - 'a';

                if (freqWord[wordIndex] != freqPattern[patterIndex]) {
                    wordsMatched = false;
                    break;
                } else {
//                because when you initialize a new array, all the entries are initialized with 0, but here the initialized value should be something
//                unique (you can also initialize it with any negative number or even null if you use Integer array). So I let the normal index start from 1,
//                which makes 0 unique. You can also check the code below, here I initialize the array with -1 and update the index with i. Hope I explained your doubt.
                    freqWord[wordIndex] = freqPattern[patterIndex] = i + 1;
                }

            }
            if (wordsMatched)
                response.add(word);
        }
        return response;
    }
}
