package com.data.structures.practice.LeetCode.graph.matrix;

public class ShortestPathBinaryMatrixDFS {

    int ans = Integer.MAX_VALUE;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0)return -1;
        boolean[][] v = new boolean[grid.length][grid[0].length];
        ans = Integer.MAX_VALUE;
        dfs(grid, 0, 0, 0, v);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public void dfs(int[][] grid, int row, int col, int path, boolean[][] v) {
        v[row][col] = true;
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            ans = Math.min(ans, path + 1);
            v[row][col] = false;
            return;
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        for (int[] dir : dirs) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if (isPathExist(grid, x, y, v)) {
                //System.out.println(x + " " + y);

                dfs(grid, x, y, path + 1, v);
            }
        }

        v[row][col] = false;

    }

    private static boolean isPathExist(int[][] grid, int row, int col, boolean[][] v) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 0
                && v[row][col] == false;
    }
}
