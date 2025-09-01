package com.data.structures.practice.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    //Time: O(n^2)
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m = new HashMap<>();
        char[] sr = s.toCharArray();
        char[] tr = t.toCharArray();

        for (int i = 0; i < sr.length; i++) {
            char c = sr[i];
            char b = tr[i];
            if (!m.containsKey(b)) {
                m.put(b, c);
            } else if (m.containsKey(b) && m.get(b) != c) {
                m.put(b, c);
                return false;
            }
        }
        int[] count = new int[300];
        for (int i : m.values()) {
            if (count[i] >= 1)
                return false;
            count[i]++;
        }
        return true;
    }

    //Time O(n)
    public boolean isIsomorphicArrayMethod(String s, String t) {
        int[] sr = new int[256];
        int[] tr = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char b = t.charAt(i);
            //   System.out.println(sr[c]+" " +tr[b]);
            if (sr[c]!=tr[b])return false;

            sr[c]=i+1;
            tr[b]=i+1;
        }

        return true;
    }
}
