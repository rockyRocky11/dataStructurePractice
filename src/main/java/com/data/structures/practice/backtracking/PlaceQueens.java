package com.data.structures.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PlaceQueens {
    public static void main(String[] args) {
        int  n = 4;
        System.out.println(solveNQueens(n));

    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList();
        List<String> sol = new ArrayList();
        int[][] visited = new int[n][n];
        backTrack(n, resList, visited, sol, 0);
        return resList;
    }

    public static void backTrack(int n, List<List<String>> resList, int[][] visited, List<String> sol, int i) {
        if(i==n){
            if(sol.size() ==n){
                resList.add(new ArrayList<>(sol));
            }
            return;
        }
        int j=0;
        while(j<n){
            if(visited[i][j]>0){
                j++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int num =0;num<n;num++){

                if(j==num){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            sol.add(sb.toString());
            updateFlag(i, j, visited, n, sol.size());
            backTrack(n, resList, visited, sol, i+1);
            removeFlag(i, j, visited, n, sol.size());
            sol.remove(sol.size()-1);
            j++;
        }
    }

    public static void updateFlag(int i, int j, int[][] visited, int n, int index) {
        int[][] directions = {
                {-1, 0}, {1, 0},  // vertical up & down
                {0, -1}, {0, 1},  // horizontal left & right
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // all 4 diagonals
        };
        visited[i][j] = index;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            while (x >= 0 && x < n && y >= 0 && y < n) {
                if (visited[x][y] == 0) {
                    visited[x][y] = index;
                }
                x += dir[0];
                y += dir[1];
            }
        }
    }
    public static void removeFlag(int i, int j, int[][] visited, int n, int index) {
        int[][] directions = {
                {-1, 0}, {1, 0},
                {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        visited[i][j] = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            while (x >= 0 && x < n && y >= 0 && y < n) {
                if (visited[x][y] == index) {
                    visited[x][y] = 0;
                }
                x += dir[0];
                y += dir[1];
            }
        }
    }


}
