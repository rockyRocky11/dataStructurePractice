package com.data.structures.practice.graph;

public class GraphPrac {
    public static void main(String[] args) {
        Graph graph =new Graph(5);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0,1);
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
       // graph.depthFirstSearch(0);
        System.out.println();
        graph.breadthFirstSearch(0);

    }
}
