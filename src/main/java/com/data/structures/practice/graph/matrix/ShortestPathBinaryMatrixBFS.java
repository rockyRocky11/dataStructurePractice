package com.data.structures.practice.graph.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathBinaryMatrixBFS {

    /*Time & Space Complexity
    Time: O(m*n)
    Each cell is enqueued/processed at most once.

    Space: O(m*n)*/
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m-1][n-1] !=0)
            return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0 });
        grid[0][0] = 1;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int dist = grid[cur[0]][cur[1]];
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if (isPathExist(grid, x, y)) {
                    grid[x][y] = dist + 1;
                    queue.offer(new int[] { x, y });
                }
            }
        }

        return grid[m - 1][n - 1] != 0 ? grid[m - 1][n - 1] : -1;
    }

    private static boolean isPathExist(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 0;
    }
}
