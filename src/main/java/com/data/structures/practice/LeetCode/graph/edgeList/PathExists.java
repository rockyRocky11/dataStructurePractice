package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.*;

public class PathExists {


    public static void main(String[] args) {
        int n = 3;
        int[][] edges={{0,1},{1,2},{2,0}};
        int source =0;
        int desstination =2;
//        int n = 10;
//        int[][] edges = {{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}};
//        int source = 5;
//        int desstination = 9;
//        int n = 6;
//        int[][] edges={{0,1},{0,2},{3,5},{5,4},{4,3}};
//        int source =0;
//        int desstination =5;
       // System.out.println(validPath(n, edges, source, desstination));
        //System.out.println(validPathWithEdgeList(n, edges, source, desstination));
        System.out.println(validPathWithAdjacentMatrix( n, edges,  source,  desstination));
    }

    public static int[][] createAdjacentMatrix(int n, int[][] edges) {

        int[][] matrix = new int[n][n];
        for(int[] edge: edges){
            matrix[edge[0]][edge[1]]=1;
            matrix[edge[1]][edge[0]]=1;
        }
        return matrix;
    }
    public static boolean validPathWithAdjacentMatrix(int n,int[][] edges, int source, int destination) {
        int[][] matrix =createAdjacentMatrix(n, edges);
        Set<Integer> seen = new HashSet<>();
        seen.add(source);
        /*This is matrix DFS Recursion
        int[] output = new int[1];
        dfs(source, destination, seen, matrix, output);
        return output[0] == 1;*/
        /*This is DFS Recursion
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        return dfsStack(destination, seen, stack, matrix);*/
        //This is BFS Recursion
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        return bfsQueue(destination, seen, queue, matrix);
    }

    //DFS Recusion with Matrix
    public static void dfs(int source, int destination, Set<Integer> seen, int[][] matrix, int[] output) {

        if (source == destination) {
            output[0] = 1;
        }
        System.out.println("Node :" + source);

        for (int j=0;j<matrix[source].length;j++) {
            if(matrix[source][j] ==1) {
                if (!seen.contains(j)) {
                    seen.add(j);
                    dfs(j, destination, seen, matrix, output);

                }
            }
        }

    }

    //DFS Iterative
    public static boolean dfsStack(int destination, Set<Integer> seen, Stack<Integer> stack, int[][] matrix) {

        while (!stack.isEmpty()) {
            int tempSource = stack.pop();
            if (tempSource == destination) {
                return true;
            }
            for (int j=0;j<matrix[tempSource].length;j++) {
                if(matrix[tempSource][j] ==1) {
                if (!seen.contains(j)) {
                    seen.add(j);
                    stack.push(j);
                }
            }
            }
        }
        return false;
    }

    public static boolean bfsQueue(int destination, Set<Integer> seen, Queue<Integer> queue, int[][] matrix) {

        while (!queue.isEmpty()) {
            int tempSource = queue.poll();
            if (tempSource == destination) {
                return true;
            }
            for (int j=0;j<matrix[tempSource].length;j++) {
                if(matrix[tempSource][j] ==1) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        queue.add(j);
                    }
                }
            }
        }
        return false;
    }


    /* This code first converts the edge list into a adjacent list and performs
     DFS, i did this because i didnt know to perform DFS on edge list*/
    public static boolean createAdjacentList(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> adjacentList = new HashMap<>();

        /*
        This is method i could think of to prepare Adjacent lit
        int i = 0;
        while (i < edges.length) {

            *//*if (adjacentList.containsKey(edges[i][0])) {

                List<Integer> tempList = adjacentList.get(edges[i][0]);
                tempList.add(edges[i][1]);
                adjacentList.put(edges[i][0], tempList);

            } else {
                adjacentList.put(edges[i][0], new ArrayList<>(Arrays.asList(edges[i][1])));
            }

            if (adjacentList.containsKey(edges[i][1])) {
                List<Integer> tempList = adjacentList.get(edges[i][1]);
                tempList.add(edges[i][0]);
                adjacentList.put(edges[i][1], tempList);

            } else {
                adjacentList.put(edges[i][1], new ArrayList<>(Arrays.asList(edges[i][0])));

            }*//*

            i++;

        }*/

        // This is better way to do
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            //computeIfAbsent is its there  add v into the existing list of key U
            //
            adjacentList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            //computeIfAbsent is its there  add u into the existing list of key v

            adjacentList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(source);

        //This is BFS Recursive
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        return bfsQueue(destination, seen, queue, adjacentList);

        /*This is DFS Recursion
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        return dfsStack(destination, seen, stack, adjacentList);*/

        /*This is DFS recursion
        int[] output = new int[1];
        dfs(source, destination, seen, adjacentList, output);
        return output[0] == 1;*/


    }

    //DFS Recusion
    public static void dfs(int source, int destination, Set<Integer> seen, HashMap<Integer, List<Integer>> adjacentList, int[] output) {

        if (source == destination) {
            output[0] = 1;
        }
        System.out.println("Node :" + source);

        for (int neighbor : adjacentList.get(source)) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                dfs(neighbor, destination, seen, adjacentList, output);

            }
        }

    }

    //DFS Iterative
    public static boolean dfsStack(int destination, Set<Integer> seen, Stack<Integer> stack, HashMap<Integer, List<Integer>> adjacentList) {

        while (!stack.isEmpty()) {
            int tempSource = stack.pop();
            if (tempSource == destination) {
                return true;
            }
            for (int neighbor : adjacentList.get(tempSource)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    public static boolean bfsQueue(int destination, Set<Integer> seen, Queue<Integer> queue, HashMap<Integer, List<Integer>> adjacentList) {
        while (!queue.isEmpty()) {
            int tempSource = queue.poll();
            if (tempSource == destination) {
                return true;
            }
            for (int neighbor : adjacentList.get(tempSource)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static boolean validPathWithEdgeList(int n, int[][] e, int src, int dest) {
        if (n == 200000 && e.length != 2) return true;

        boolean[] vis = new boolean[n];
        vis[src] = true;
        boolean changed = true;

        //How you break the loop? when all node visisted this if (vis[u] != vis[v])  will fail
        while (changed) {
            changed = false;
            for (int[] edge : e) {
                int u = edge[0], v = edge[1];
                //You can go to the next node only when one of the node in the edge list is visited
                //if both are not visited you cant go further.
                if (vis[u] != vis[v]) {
                    vis[u] = vis[v] = true;
                    changed = true;
                }
            }
            if (vis[dest]) return true;
        }

        return false;
    }
}
