package com.data.structures.practice.greedy.huffman;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    static class Node{
        char ch;
        int freq;
        Node left;
        Node right;
        Node(char ch, int freq, Node left, Node right){
            this.ch = ch;
            this.freq=freq;
            this.left = left;
            this.right=right;
        }

        Node(char ch, int freq){
            this.ch = ch;
            this.freq=freq;
        }
    }
    public static String frequencySort(String s) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)->b.freq-a.freq);
        Map<Character, Integer> countingMap = new HashMap<>();

        for(char c: s.toCharArray()){
            countingMap.put(c, countingMap.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character, Integer> entry: countingMap.entrySet()){
            minHeap.offer(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuffer sb = new StringBuffer();
        while (minHeap.size()>0){
            Node temp = minHeap.poll();
            for(int i=0;i<temp.freq;i++){
                sb.append(temp.ch);
            }
        }

        return sb.toString();
    }
}
