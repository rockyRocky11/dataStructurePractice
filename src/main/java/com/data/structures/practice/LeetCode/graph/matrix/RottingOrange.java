package com.data.structures.practice.LeetCode.graph.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange {

   /* ⏱️ Complexity
    Time: O(m * n) (scan once + BFS once).

    Space: O(m * n) in the worst case (queue holds all oranges).*/

    public static void main(String[] args) {
        //int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};//ans=4
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}};//ans 2
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        int mins = 0;
        int totalFresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    totalFresh++;
                }
            }
        }
        if(totalFresh ==0)return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int k = 0; k < size; k++) {
                int[] src = queue.poll();
                int x = src[0];
                int y = src[1];
                for (int[] dir : dirs) {
                    if (isFreshExist(grid, x + dir[0], y + dir[1]) && grid[x + dir[0]][y + dir[1]] == 1) {
                        totalFresh--;
                        rottedThisMinute = true;
                        queue.offer(new int[]{x + dir[0], y + dir[1]});
                        grid[x + dir[0]][y + dir[1]] = 0;
                    }
                }

            }
            if (rottedThisMinute) {
                mins++;

            }

        }
        return totalFresh > 0 ? -1 : mins;
    }

    private static boolean isFreshExist(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
