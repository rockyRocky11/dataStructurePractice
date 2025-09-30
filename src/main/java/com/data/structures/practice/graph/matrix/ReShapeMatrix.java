package com.data.structures.practice.graph.matrix;

import java.util.Arrays;

public class ReShapeMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
       // int r = 4, c = 1;
        System.out.println(Arrays.toString(matrixReshape1(mat, r, c)));

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        if (r * c != mat[0].length * mat.length) {
            return mat;
        }

        int response[][] = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {

                if (col >= c) {
                    row++;
                    col = 0;
                }
                if (row >= r) {
                    return mat;
                }
                response[row][col++] = mat[i][j];
                //System.out.println(mat[i][j]);
            }


        }
        return response;
    }

    public static int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n)
            return nums;
        int[][] reshaped = new int[r][c];
        for (int i = 0; i < r * c; i++)
            reshaped[i/c][i%c] = nums[i/n][i%n];
        return reshaped;
    }
}
