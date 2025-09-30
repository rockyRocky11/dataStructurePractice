package com.data.structures.practice.backtracking;

import java.util.Stack;

public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);

    }


    public static void solveSudoku(char[][] board) {
        Stack<Character> stack = new Stack<>();
        backTrack(board, 0, 0, stack);

    }

    public static boolean backTrack(char[][] board, int i, int j, Stack<Character> stack) {
        if (i == 9) {
            return true;
        }

        if (j == 9) return backTrack(board, i + 1, 0, stack);

        if (board[i][j] != '.') return backTrack(board, i, j + 1, stack);


        char[] c = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char v : c) {
            //for (char v = '1'; v <= '9'; v++) {
            if (checkRow(board, i, j, v)  && checkSubBox(board, i, j, v)) {
                //if (isValid(board, i, j, v)) {
                board[i][j] = v;
                if (backTrack(board, i, j + 1, stack)) return true;
                board[i][j] = '.';
            }
        }


        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char d) {
        int n = 9;

        for (int i = 0; i < n; i++) {
            // row check
            if (board[row][i] == d) return false;
            // col check
            if (board[i][col] == d) return false;
            // 3x3 box check
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == d) return false;
        }

        return true;
    }

    public static boolean checkRow(char[][] board, int row, int col, char newVal) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == newVal) return false;
            if (board[i][col] == newVal) return false;
        }
        return true;
    }

    public static boolean checkCol(char[][] board, int row, int col, char newVal) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == newVal) return false;
        }
        return true;
    }

    public static boolean checkSubBox(char[][] board, int row, int col, char newVal) {

        int rowStart = 0;
        int rowEnd = 3;
        int colStart = 0;
        int colEnd = 3;

        if (row >= 3 && row < 6) {
            rowStart = 3;
            rowEnd = rowStart + 3;
        } else if (row >= 6 && row < 9) {
            rowStart = 6;
            rowEnd = rowStart + 3;
        }

        if (col >= 3 && col < 6) {
            colStart = 3;
            colEnd = colStart + 3;
        } else if (col >= 6 && col < 9) {
            colStart = 6;
            colEnd = colStart + 3;
        }

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (board[i][j] == newVal) return false;
            }
        }
        return true;
    }
}
