package com.data.structures.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    ArrayList<Node> nodes;
    int[][] matrix;

    Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];// Thats why space is O(v^2)
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst) {
    matrix[src][dst]=1;
    }

    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst]==1;
    }

    public void print(){
        System.out.print("  ");
        for(Node node:nodes){
            System.out.print(node.data+" ");
        }
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            System.out.print(nodes.get(i).data+" ");
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }

    }

    public void depthFirstSearch(int src){

        boolean[] visited = new boolean[matrix.length];
        for(int i=0;i<matrix.length;i++) {
            dfsHelper(i, visited);

        }

    }

    private void dfsHelper(int src, boolean[] visited) {

        if(visited[src]){
            return;
        }
        visited[src]=true;
        System.out.println(nodes.get(src).data+" = visited");

        for(int i=0;i< matrix[src].length;i++){
            //System.out.println("src ="+src);
            //System.out.println("i ="+i);
            //System.out.println();
            if (matrix[src][i]==1){
                dfsHelper(i, visited);
            }
        }
        return;
    }

    public void breadthFirstSearch(int src){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src]=true;
        while (queue.size() !=0){
            src=queue.poll();
            System.out.println(nodes.get(src).data+" = visited");

            for(int i=0;i< matrix[src].length;i++){
                if(matrix[src][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }

    }
}
