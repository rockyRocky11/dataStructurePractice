package com.data.structures.practice.sorting;

public class Bubble {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, -1, -22};

        int sortedIndex = 0;
        int unSortedIndex = inputArray.length - 1;

        while (unSortedIndex > 0) {
            for (int i = sortedIndex; i < unSortedIndex; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    swap(inputArray, i, i + 1);
                }
            }
            unSortedIndex = unSortedIndex - 1;
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
