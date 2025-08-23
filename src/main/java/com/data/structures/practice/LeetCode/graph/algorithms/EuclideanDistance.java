package com.data.structures.practice.LeetCode.graph.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class EuclideanDistance {

    public static void main(String[] args) {
        int[][] grid ={{0 ,0 ,0},{1 ,1 ,0},{0,0,0}};

        int[] start = {0,0}, end = {2,2};
    }

    class Node {
        int x, y, g;
        double f;
        Node(int x, int y, int g, double f) {
            this.x = x; this.y = y; this.g = g; this.f = f;
        }
    }

    // 8 directions (4 straight + 4 diagonal)
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

    public int shortestPath(int[][] grid, int[] start, int[] end) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->Double.compare(a.f, b.f));
        int[][] dist = new int[m][n];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        dist[start[0]][start[1]] = 0;
        pq.offer(new Node(start[0], start[1], 0, heuristic(start, end)));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == end[0] && cur.y == end[1]) return cur.g; // reached goal

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0], ny = cur.y + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 1) continue;

                int stepCost = (dir[0] == 0 || dir[1] == 0) ? 1 : 2;
                // straight move cost = 1, diagonal move cost = 2 (can tweak to sqrt(2))

                int ng = cur.g + stepCost;
                if (ng < dist[nx][ny]) {
                    dist[nx][ny] = ng;
                    double nf = ng + heuristic(new int[]{nx, ny}, end);
                    pq.offer(new Node(nx, ny, ng, nf));
                }
            }
        }
        return -1; // no path
    }

    private double heuristic(int[] a, int[] b) {
        // Euclidean distance
        return Math.sqrt(Math.pow(a[0]-b[0], 2) + Math.pow(a[1]-b[1], 2));
    }
}
