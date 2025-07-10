package com.data.structures.practice.LeetCode.graph.matrix;

import com.data.structures.practice.listPractice.queue.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland2 {
    public static void main(String[] args) {
        //char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        //char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] grid = {{'1'}, {'1'}};
        //char[][] grid = {{'0'}};
        //char[][] grid = {{'1'}};
        System.out.println(numIslands(grid)
        );
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }


        int islanCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    islanCount++;
                    helper(grid, i, j);

                }

            }
        }

        return islanCount;
    }

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];

                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
                            continue;
                        }

                        grid[x][y] = '0'; // mark as visited

                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return numIslands;
    }


    public static void helper(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||   grid[row][col] != '1') {
            return;
        }


        grid[row][col] = '0';
        helper(grid, row + 1, col);//down
        helper(grid, row - 1, col);//up
        helper(grid, row, col + 1);//right
        helper(grid, row, col - 1);//left

    }

}
