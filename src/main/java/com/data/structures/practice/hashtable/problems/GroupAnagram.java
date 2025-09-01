package com.data.structures.practice.hashtable.problems;

import java.util.*;

public class GroupAnagram {

    //Time: O(L*nlogn)

    public List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();

        for (String a : strs) {
            char[] ar = a.toCharArray();
            Arrays.sort(ar);
            String n = new String(ar);
            map.computeIfAbsent(n, k -> new ArrayList<>()).add(a);

        }

        return new ArrayList<>(map.values());

    }

    //This method is slower than sorting
    public List<List<String>> groupAnagramsCountingArray(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();

        for(String a: strs){
            int[] c = new int[26];

            for(char h: a.toCharArray()){
                c[h-'a']++;
            }
            String ar=Arrays.toString(c);
            map.computeIfAbsent(ar, k->new ArrayList()).add(a);
        }

        return new ArrayList<>(map.values());

    }
}
