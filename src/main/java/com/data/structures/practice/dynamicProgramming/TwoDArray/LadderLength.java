package com.data.structures.practice.dynamicProgramming.TwoDArray;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;

public class LadderLength {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
    }

    /*🔹 Time Complexity

    Preprocessing: O(N * L) to build the generic pattern map

    BFS: O(N * L²)

    For each word, you check L positions and each position might have multiple neighbors.

    Much faster than the old O(N² * L) approach.

            🔹 Space Complexity

    graph → O(N * L)

    visited → O(N)

    queue → O(N)*/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!graph.containsKey(newWord)) {
                    graph.put(newWord, new ArrayList<>());
                }
                graph.get(newWord).add(word);
            }
        }

        Deque<String> queue = new ArrayDeque();
        queue.offer(beginWord);
        int ans = 1;
        int res = Integer.MAX_VALUE;
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String begin = queue.poll();

                if (begin.equals(endWord)) {
                    return ans;
                }
                // System.out.println(begin + " ");
                for (int i = 0; i < len; i++) {
                    String newWord = begin.substring(0, i) + "*" + begin.substring(i + 1);
                    for (String word : graph.getOrDefault(newWord, new ArrayList<>())) {
                        if (visited.contains(word))
                            continue;
                        visited.add(word);
                        queue.offer(word);
                    }

                }
                // System.out.println();
            }
            // System.out.println(ans);
            ans++;
        }
        return 0;
    }
}
