package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.*;
public class CourseScheduleII {

  /*  Time Complexity: O(V + E)
    Space Complexity: O(V + E) (graph + recursion stack + result stack)*/
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int[] pre : prerequisites) {
            int x = pre[0];
            int y = pre[1];
            al.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }
        Set<Integer> topoSort = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        //System.out.println(al);
        while (i < numCourses) {
            if (!topoSort.contains(i))
                if(!dfs(topoSort, i, al, visited, result))return new int[]{};
            i++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean dfs(Set<Integer> topoSort, int course, Map<Integer, List<Integer>> al,
                              Set<Integer> visited, List<Integer> result) {
        //System.out.println(course);
        if(visited.contains(course))
            return false;
        visited.add(course);
        for (int pre : al.getOrDefault(course, Collections.emptyList())) {
            if (!topoSort.contains(pre))
                if(!dfs(topoSort, pre, al, visited, result))return false;
        }
        visited.remove(course);
        topoSort.add(course);
        //System.out.println("OUT " + course);
        result.add(course);
        return true;

    }
}
