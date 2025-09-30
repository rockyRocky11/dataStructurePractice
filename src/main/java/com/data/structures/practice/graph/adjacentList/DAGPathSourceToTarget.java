package com.data.structures.practice.graph.adjacentList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/*⏱ Time & Space Complexity
N = number of nodes, P = number of all possible paths

Worst case: Each path explored → exponential in N (like exploring all subsets).

Time: O(N * P)

N for copying path into resList

P = number of paths from 0 → target.

        Space:

O(N) recursion stack + O(N) for path list

O(N * P) for result storage.*/
public class DAGPathSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(graph, 0, resList, sol);
        return resList;
    }

    public void dfs(int[][] graph, int src, List<List<Integer>> resList, List<Integer> sol) {
        sol.add(src);
        if (src == graph.length - 1) {
            resList.add(new ArrayList(sol));
        } else {
            for (int num : graph[src]) {
                dfs(graph, num, resList, sol);
            }
        }
        sol.remove(sol.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();

        // start with path [0]
        List<Integer> startPath = new ArrayList<>();
        startPath.add(0);
        queue.offer(startPath);

        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);

            // If we reached the target, add to result
            if (lastNode == graph.length - 1) {
                resList.add(new ArrayList<>(path));
                continue;
            }

            // Otherwise, expand neighbors
            for (int neighbor : graph[lastNode]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(neighbor);
                queue.offer(newPath);
            }
        }

        return resList;
    }
}
