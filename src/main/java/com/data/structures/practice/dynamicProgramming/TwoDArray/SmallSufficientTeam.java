package com.data.structures.practice.dynamicProgramming.TwoDArray;

import java.util.*;
public class SmallSufficientTeam {

    public static void main(String[] args) {
        String[] req_skills=  {"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        List<String> s = new ArrayList<>();
        s.add("java");
        people.add(s);
        List<String> s1 = new ArrayList<>();
        s1.add("nodejs");
        people.add(s1);
        List<String> s2 = new ArrayList<>();
        s2.add("nodejs");
        s2.add("reactjs");
        people.add(s2);


        System.out.println(Arrays.toString(smallestSufficientTeam(req_skills, people)));
    }
    static int allReq;
    static  Map<String, Integer> store;

    static  int[] peopleMask;

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        store = new HashMap<>();
        Map<Integer, List<Integer>> dp = new HashMap<>();
        int n = req_skills.length;
        int m = people.size();
        peopleMask = new int[m];

        allReq = (1 << n) - 1;
        int idx = 0;
        for (String s : req_skills) {
            store.put(s, idx++);
        }
        for (int i = 0; i < m; i++) {
            int nextMask = 0;
            for (String s : people.get(i)) {
                nextMask = nextMask | 1 << store.get(s);
            }
            peopleMask[i] = nextMask;
            //System.out.println(peopleMask[i]);
        }
        dp.put(0, new ArrayList());

        //This is just a nested for loop
        //It works onnly because of bitmask
        for (int i = 0; i < m; i++) {
            int currMask = peopleMask[i];
            List<Integer> allKeys = new ArrayList(dp.keySet());
            for (int prevMask : allKeys) {
                int newMask = currMask + prevMask;
                if (!dp.containsKey(newMask) || (dp.get(prevMask).size() + 1) < dp.get(newMask).size()) {
                    List<Integer> newTeam = new ArrayList<>(dp.get(prevMask));
                    newTeam.add(i);
                    dp.put(newMask, newTeam);
                }
            }

        }

        int[] res = new int[dp.get(allReq).size()];
        int j = 0;
        for (int i : dp.get(allReq)) {
            res[j++] = i;
        }
        return res;
    }

}
