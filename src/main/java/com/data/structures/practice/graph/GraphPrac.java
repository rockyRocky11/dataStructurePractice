package com.data.structures.practice.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphPrac {
    public static void main(String[] args) {
        Graph graph =new Graph(5);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2);
//
//        graph.print();
//        System.out.println(graph.checkEdge(0,1));
//       //graph.depthFirstSearch(0);
//        graph.depthFirstSearch(1);

//        Graph graph =new Graph(5);
//        graph.addNode(new Node('A'));
//        graph.addNode(new Node('B'));
//        graph.addNode(new Node('C'));
//        graph.addNode(new Node('D'));
//        graph.addNode(new Node('E'));
//
//        graph.addEdge(0,0);
//        graph.addEdge(0,1);
//        graph.addEdge(1,0);
//        graph.addEdge(1,1);
//        graph.addEdge(2,2);
//        graph.addEdge(3,3);
//        graph.addEdge(3,4);


        graph.print();
        System.out.println(graph.checkEdge(0,1));
        //graph.depthFirstSearch(0);

//        for(int i=0;i<graph.matrix.length;i++){
//            graph.depthFirstSearch(i);
//            System.out.println();
//        }
        graph.depthFirstSearch(0);
        System.out.println();
        graph.breadthFirstSearch(0);

    }

   /* With edge List
    Time Complexity: O(V + E)
    Space Complexity: O(V) (visited array + queue)*/
    void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    //DFS RECURSION

    void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    /*DFS ITERATIVE
    Time Complexity: O(V + E)
    Space Complexity:

    Recursive DFS → O(V) (call stack)

    Iterative DFS → O(V) (stack)*/

    void dfsIterative(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

}
