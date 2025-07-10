package com.data.structures.practice.LeetCode.graph.matrix;

import java.util.HashMap;
import java.util.Map;

public class ZeroMatrix {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        //int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1, 3,1,5}};
        //int[][] matrix = {{0,1,2,3}, {3,4,5,0}, {1, 3,1,5}};
        //int[][] matrix = {{0, 1, 2, 3}, {3, 4, 0, 7}, {1, 3, 1, 5}};
        int[][] matrix = {{1,2,3,4}, {5,0,7,8}, {0,10,11,12}, {13,14,15,0}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
        setZeroesInPlace(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void setZeroesInPlace(int[][] matrix) {

        boolean firstCol =false;
        boolean firstRow =false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0 ){
                    if(i !=0) {
                        matrix[i][0] = 0;
                    }else{
                        firstRow=true;
                    }
                    if(j !=0) {
                        matrix[0][j] = 0;
                    }else {
                        firstCol=true;
                    }
                }

            }

        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }

            }

        }


        if(firstCol){
            for (int i = 0; i < matrix.length; i++) {

                matrix[i][0]=0;
            }
        }

        if(firstRow){
            for (int i = 0; i < matrix[0].length; i++) {

                matrix[0][i]=0;
            }
        }

    }

    public static void setZeroes(int[][] matrix) {

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        int row = 0;

        while (row < matrix.length) {
            if (!rowMap.containsKey(row)) {
                int col = 0;

                while (col < matrix[0].length) {

                    if (!colMap.containsKey(col)) {


                        if (matrix[row][col] == 0) {
                            setZeroesToRowCol(matrix, row, col, rowMap, colMap);
                            break;
                        }
                    }

                    col++;

                }
            }
            row++;

        }

    }

    public static void setZeroesToRowCol(int[][] matrix, int row, int col, Map<Integer, Integer> rowMap, Map<Integer, Integer> colMap) {

        if (!rowMap.containsKey(row)) {
            rowMap.put(row, 1);
            int tempCol = 0;
            while (tempCol < matrix[0].length) {
                if (tempCol != col && matrix[row][tempCol] == 0) {
                    System.out.println("Set this entire col zero" + tempCol);
                    setZeroesToRowCol(matrix, row, tempCol, rowMap, colMap);
                }
                matrix[row][tempCol] = 0;
                tempCol++;
            }
        }
        if (!colMap.containsKey(col)) {

            colMap.put(col, 1);
            int temprow = 0;
            while (temprow < matrix.length) {
                if (temprow != row && matrix[temprow][col] == 0) {
                    System.out.println("Set this entire col zero" + temprow);
                    setZeroesToRowCol(matrix, temprow, col, rowMap, colMap);
                }
                matrix[temprow][col] = 0;
                temprow++;
            }
        }

    }
}
