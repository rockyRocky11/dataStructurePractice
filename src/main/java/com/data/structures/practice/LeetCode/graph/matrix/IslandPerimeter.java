package com.data.structures.practice.LeetCode.graph.matrix;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
       //int[][] grid = {{1}};
        //int[][] grid = {{1, 0}};
        //int[][] grid = {{0, 1}};
        System.out.println(islandPerimeter1(grid));
    }

    public static int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandPerimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    islandPerimeter+=islandPerimeterDFS(grid, i, j, visited);
                    return islandPerimeter;

                }

            }
        }
        return islandPerimeter;
    }

    public static int islandPerimeterDFS(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int up = isNodeExist(grid, row - 1, col);
        int down = isNodeExist(grid, row + 1, col);
        int right = isNodeExist(grid, row , col+1);
        int left = isNodeExist(grid, row , col-1);
        int cellPerimeter = 4-up-down-right-left;
        cellPerimeter+=islandPerimeterDFS(grid, row + 1, col, visited);//down
        cellPerimeter+=islandPerimeterDFS(grid, row - 1, col, visited);//up
        cellPerimeter+=islandPerimeterDFS(grid, row, col + 1, visited);//right
        cellPerimeter+=islandPerimeterDFS(grid, row, col - 1, visited);//left
        return cellPerimeter;

    }

    public static int isNodeExist(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }

        return 1;

    }

    public static int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    islands++;
                    if(i < grid.length - 1 && grid[i + 1][j] == 1){
                        neighbours++;
                    }
                    if(j < grid[i].length - 1 && grid[i][j + 1] == 1){
                        neighbours++;
                    }
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}
