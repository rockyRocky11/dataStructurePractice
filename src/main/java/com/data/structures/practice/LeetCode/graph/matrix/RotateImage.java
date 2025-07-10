package com.data.structures.practice.LeetCode.graph.matrix;

public class RotateImage {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
        rotate(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {

        int midColCounter=1;

        int startrow = 0;
        int col1 = matrix[0].length - 1;
        int row2 = matrix.length - 1;
        int col3 = 0;

        int nstartCol = 0;
        int nrow1 = 0;
        int ncol2 = matrix[0].length - 1;
        int nrow3 = matrix.length - 1;
        while (startrow < matrix[0].length /2) {
            int startCol = nstartCol;
            int row1 = nrow1;
            int col2 = ncol2;
            int row3 = nrow3;

            while (startCol < matrix[0].length - midColCounter) {

                int temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[startrow][startCol];
                int temp1 = matrix[row2][col2];
                matrix[row2][col2] = temp;
                int temp2 = matrix[row3][col3];
                matrix[row3][col3] = temp1;
                matrix[startrow][startCol] = temp2;

                row3--;
                col2--;
                row1++;
                startCol++;
            }

            nstartCol++;
            nrow1++;
            ncol2--;
            nrow3--;

            startrow++;
            col1--;
            row2--;
            col3++;
            midColCounter++;
        }

    }
}
