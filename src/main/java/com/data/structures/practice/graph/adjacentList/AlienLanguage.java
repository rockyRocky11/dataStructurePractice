package com.data.structures.practice.graph.adjacentList;

import java.util.List;
import java.util.Map;
import java.util.*;

public class AlienLanguage {



    public static void main(String[] args) {
        //String[] Input = {"z", "o"};//zo
        //String[] Input = {"wrt","wrf","er","ett","rftt","te"};//wertf
        //String[] Input = {"abc","bcd","cde"};//edabc
        String[] Input = {"wrtkj","wrt"};//edabc
        System.out.println(foreignDictionary(Input));
    }

    private static final int visited = 2;

    private static final int visiting = 1;

    public static String foreignDictionary(String[] words) {

        //Creating Adjacency List
        Map<Character, List<Character>> adjList = new HashMap<>();
        for(String word: words){
            for(char letter: word.toCharArray()){
                if(!adjList.containsKey(letter)){
                    adjList.put(letter, new ArrayList<>());
                }
            }

        }
        int i = 0;
        while (i < words.length - 1) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i + 1].toCharArray();
            boolean smallerWordComesLast = word1.length>word2.length;
            int j = 0;
            boolean noMatch= true;
            while (j < word1.length && j < word2.length) {
                if (word1[j] != word2[j]) {
                    noMatch= false;
                    adjList.computeIfAbsent(word1[j], k -> new ArrayList()).add(word2[j]);
                    break;
                }
                j++;

            }
            //if all the letters are matching then the smaller words should come first, if that condidion fails return ""
            // This criteria failed --> There is no index i such that a[i] != b[i] and a.length < b.length.
            if(smallerWordComesLast&&noMatch){
                return "";
            }

            i++;
        }


        int[] states = new int[26];
        List<Character> res = new ArrayList();
        int n = 0;
        for (Map.Entry<Character, List<Character>> adj : adjList.entrySet()) {
            if (states[(adj.getKey() - 'a')] != visited && !dfsPostOrder(adj.getKey(), states, res, adjList)) {
                return "";
            }
            n++;
        }
        Collections.reverse(res);
        StringBuffer letters = new StringBuffer();
        for (Character re : res) {
            letters.append(re);
        }
        return letters.toString();
    }

    public static Map<Character, List<Character>> createAdjacencyList(String[] words) {

        Map<Character, List<Character>> adjList = new HashMap<>();
        for(String word: words){
            for(char letter: word.toCharArray()){
                if(!adjList.containsKey(letter)){
                    adjList.put(letter, new ArrayList<>());
                }
            }

        }
        int i = 0;
        while (i < words.length - 1) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i + 1].toCharArray();
            int j = 0;
            while (j < word1.length && j < word2.length) {
                if (word1[j] != word2[j]) {
                    adjList.computeIfAbsent(word1[j], k -> new ArrayList()).add(word2[j]);
                    break;
                }
                j++;

            }

            i++;
        }

        return adjList;
    }

    //DFS post order recursion, because the node is captured the end of recursion, if its in the middle then its in order
    private static boolean dfsPostOrder(char source, int[] states, List<Character> res, Map<Character, List<Character>> adjList) {

        if (states[(source - 'a')] == visiting) {
            return false;
        }
        if (adjList.containsKey(source) && !adjList.get(source).isEmpty()) {
            for (char letter : adjList.get(source)) {
                states[(source - 'a')] = visiting;
                if (states[(letter - 'a')] != visited && !dfsPostOrder(letter, states, res, adjList)) {
                    return false;
                }
            }
        }
        states[(source - 'a')] = visited;
        res.add(source);
        return true;
    }

}
