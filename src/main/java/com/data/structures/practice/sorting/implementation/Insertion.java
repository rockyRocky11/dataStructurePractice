package com.data.structures.practice.sorting.implementation;

public class Insertion {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, -1, -22};

        int sortedIndex = 0;


        while (sortedIndex < inputArray.length-1) {
            int unSortedIndex = sortedIndex+1;
            int unSortedValue = inputArray[unSortedIndex];
            for (int i = sortedIndex; i >=0; i--) {
                if (inputArray[i] >unSortedValue) {
                    swap(inputArray, i, unSortedIndex);
                    unSortedIndex=i;
               }
            }
            sortedIndex = sortedIndex + 1;
        }

        for (int j : inputArray) {
            System.out.println(j);
        }

    }

    private static void swap(int[] inputArray, int indexOne, int indexTwo) {

        if (indexOne == indexTwo) {
            return;
        }

        int tempObj = inputArray[indexOne];
        inputArray[indexOne] = inputArray[indexTwo];
        inputArray[indexTwo] = tempObj;

    }
}
