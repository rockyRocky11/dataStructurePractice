package com.data.structures.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quick2 {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(inputArray, 0, inputArray.length);

        for (int j : inputArray) {
            System.out.println(j);
        }

    }

    private static void quickSort(int[] inputArray, int start, int end){
        if(end-start <2){
            return;
        }
        System.out.println("\n");
        System.out.println("start ="+start+", end ="+end);
        int pivotIndex= partition(inputArray, start, end);
        quickSort(inputArray, start, pivotIndex);
        quickSort(inputArray, pivotIndex+1, end);

    }

    private static int partition(int[] inputArray, int start, int end){
        int pivotElement = inputArray[start];
        int[] slice = Arrays.copyOfRange(inputArray, start, end);
        System.out.println(Arrays.toString(slice));
        System.out.println("pivotElement "+pivotElement);
        int i = start;
        int j = end;
        while (i < j) {
            // alternate method is empty while loop
            while (i < j && inputArray[--j] >= pivotElement) ;
            if (i < j) {
                inputArray[i] = inputArray[j];
            }
            while (i < j && inputArray[++i] <= pivotElement);
            if (i < j) {
                inputArray[j] = inputArray[i];
            }
        }
        inputArray[j] = pivotElement;
        int[] slice1 = Arrays.copyOfRange(inputArray, start, end);
        System.out.println(Arrays.toString(slice1));
        return j;
    }
}
