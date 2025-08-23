package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        //int numCourses = 2;
        //int numCourses = 4;
        int numCourses = 7;
        //int numCourses = 1;
        //int numCourses = 4;
       //int[][] prerequisites = {{0, 1},{1, 0}};
        //int[][] prerequisites = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        int[][] prerequisites = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        //int[][] prerequisites = {{1, 0}};
       // int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        //int[][] prerequisites = {{2,3},{1,2},{0,1},{0,4},{4,5},{5,1}};
       //int[][] prerequisites = {};
        //System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
        System.out.println(canFinish(numCourses, prerequisites));
        System.out.println(canFinishEdeg(numCourses, prerequisites));
    }


    /*Time & Space

    Time: O(V + E)

    Space: O(V + E) (graph + recursion stack)*/
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int[] edge : prerequisites) {

            int u = edge[0];
            int v = edge[1];
            al.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Set<Integer> taken = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        int i = 0;
        while (i < numCourses) {
            if (!al.containsKey(i)) {
                taken.add(i);
                i++;
                continue;
            }
            if (!dfsWithAdjacentList(i, al, taken, visiting))
                return false;
            i++;
        }
        return taken.size() == numCourses;
    }

    public static boolean dfsWithAdjacentList(int course, Map<Integer, List<Integer>> al, Set<Integer> taken,
                                              Set<Integer> visiting) {
        if (taken.contains(course))
            return true;
        if (visiting.contains(course))
            return false;
        visiting.add(course);
        for (int n : al.getOrDefault(course, Collections.emptyList())) {
            if (!dfsWithAdjacentList(n, al, taken, visiting)) {
                return false;
            }
        }
        visiting.remove(course);
        taken.add(course);
        return true;
    }

    public static boolean canFinishEdeg(int numCourses, int[][] prerequisites) {
        Set<Integer> taken = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        //This is matrix DFS Recursion
        int i = numCourses - 1;
        while (i > 0) {
            if (!taken.contains(i) && !dfsWithEdgeList(i, taken, visited, prerequisites)) {
                return false;
            }
            i--;
        }
        return true;
    }

    //DFS Recusion with EdgeList
    public static boolean dfsWithEdgeList(int course, Set<Integer> taken, Set<Integer> visited, int[][] prerequisites) {
        //System.out.println("Course :" + course);

        boolean courseFinished = true;
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            if (u == course) {

                visited.add(course);

                if (!taken.contains(v)) {
                    if (visited.contains(v)) {
                        return false;
                    }
                    if (!dfsWithEdgeList(v, taken, visited, prerequisites)) {
                        return false;
                    }
                }
            }
        }
        if (courseFinished) {
            visited = new HashSet<>();
            taken.add(course);
        }
        return courseFinished;
    }
}
