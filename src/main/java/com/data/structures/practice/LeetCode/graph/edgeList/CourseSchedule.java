package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        //int numCourses = 2;
        int numCourses = 1;
        //int numCourses = 4;
        //int[][] prerequisites = {{0, 1},{1, 0}};
        //int[][] prerequisites = {{1, 0}};
       // int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        //int[][] prerequisites = {{2,3},{1,2},{0,1},{0,4},{4,5},{5,1}};
       int[][] prerequisites = {};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int unvisited =0;
        int visiting =1;
        int visited =2;
        List<Integer> output = new ArrayList<>();
        int[] states = new int[numCourses];
        //This is matrix DFS Recursion
        int i=numCourses-1;
        while(i>=0) {
            if(states[i] != visited && !dfsWithEdgeList1(i, states, prerequisites, output)){
                return new int[0];
            }
            i--;
        }
        int[] result=new int[numCourses];
        for(int j=0;j<numCourses;j++){
            result[j]=output.get(j);
        }

        return result;
    }

    //DFS Recusion with EdgeList --> This is a post order, because the neighbors are added into the list first.
    public static boolean dfsWithEdgeList1(int course, int[] states, int[][] prerequisites, List<Integer> output) {
        System.out.println("Course :" + course);

        boolean courseFinished=true;
        for (int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            if(u == course) {

                states[course]=1;

                if (states[v] !=2) {
                    if (states[v] ==1) {
                        return false;
                    }
                    if (!dfsWithEdgeList1(v, states, prerequisites, output)) {
                        courseFinished = false;
                    }
                }
            }
        }
        if(courseFinished){
            states[course]=2;
            output.add(course);
        }
        return courseFinished;
    }

    public static Map<Integer, List<Integer>> createAdjacentList(int numCourses, int[][] prerequisites) {
        int i = 0;
        Map<Integer, List<Integer>> al = new HashMap<>();
        if(prerequisites.length ==0 && numCourses ==1){
            int j=0;
            while(j<numCourses){
                al.put(j, new ArrayList<>());
                j++;
            }
        }
        for (int[] edge : prerequisites) {

            int u = edge[0];
            int v = edge[1];
            //computeIfAbsent is its there  add v into the existing list of key U
            //
            if (!al.containsKey(v)) {
                al.put(v, new ArrayList<>());
            }
            //computeIfAbsent is its there  add u into the existing list of key v

            al.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

        }
        return al;
    }

    public static int[][] createAdjacentMatrix(int n, int[][] edges) {

        int[][] matrix = new int[n][n];
        for(int[] edge: edges){
            matrix[edge[1]][edge[0]]=1;
        }
        return matrix;
    }

    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[][] matrix =createAdjacentMatrix( numCourses, prerequisites);

        Set<Integer> taken = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int[] output = new int[numCourses];
        //This is matrix DFS Recursion
        int i=numCourses-1;
        int index=0;
        while(i>0) {
            if(!taken.contains(i) && !dfs(i, taken, visited, matrix, output)){
                return new int[0];
            }
            i--;
        }
        return output;
    }

    public static int[] findOrder3(int numCourses, int[][] prerequisites) {

        Set<Integer> taken = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int[] output = new int[numCourses];
        //This is matrix DFS Recursion
        int i=numCourses-1;
        while(i>0) {
            if(!taken.contains(i) && !dfsWithEdgeList(i, taken, visited, prerequisites, output)){
                return new int[0];
            }
            i--;
        }
        return output;
    }
    //DFS Recusion with EdgeList
    public static boolean dfsWithEdgeList(int course, Set<Integer> taken, Set<Integer> visited, int[][] prerequisites, int[] output) {
        System.out.println("Course :" + course);

        boolean courseFinished=true;
        for (int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            if(u == course) {

                visited.add(course);

                if (!taken.contains(v)) {
                    if (visited.contains(v)) {
                        return false;
                    }
                    if (!dfsWithEdgeList(v, taken, visited, prerequisites, output)) {
                        courseFinished = false;
                    }
                }
            }
        }
        if(courseFinished){
            visited = new HashSet<>();
            output[taken.size()]=course;
            taken.add(course);
        }
        return courseFinished;
    }

    //DFS Recusion with Matrix
    public static boolean dfs(int course, Set<Integer> taken, Set<Integer> visited, int[][] matrix, int[] output) {
        System.out.println("Course :" + course);

        boolean courseFinished=true;
        for (int j=0;j<matrix[course].length;j++) {
            visited.add(course);

            if(matrix[j][course] ==1 && !taken.contains(j)) {
                if(visited.contains(j)){
                    return false;
                }
                    if(!dfs(j, taken, visited, matrix, output)){
                        courseFinished=false;
                    }
            }
        }
        if(courseFinished){
            visited = new HashSet<>();
            output[taken.size()]=course;
            taken.add(course);
        }
        return courseFinished;
    }

    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> al = createAdjacentList(numCourses, prerequisites);
        boolean[] seen = new boolean[numCourses];
        int[] res = new int[numCourses];

        int i = 0;
        int index = 0;
        if(al.size() != numCourses){
            return new int[0];
        }
        while (i < numCourses) {
            if(!al.containsKey(i)){
                res[index++] = i;
            }
            else if (al.get(i).isEmpty()) {
                if(!seen[i]){
                    seen[i] = true;
                    res[index++] = i;
                }
            }else{
                for(int num: al.get(i)){
                    if(!al.get(num).isEmpty() && !seen[num]){
                        return new int[0];
                    }
                    if(!seen[num] && al.get(num).isEmpty()){
                        res[index++] = num;
                        seen[num] = true;
                    }
                }
                res[index++] = i;
                seen[i] = true;
            }
            i++;
        }

        return res;
    }
}
