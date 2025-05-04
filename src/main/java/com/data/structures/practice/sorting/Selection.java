package com.data.structures.practice.sorting;

public class Selection {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, -1, -22};


        int unSortedIndex = inputArray.length - 1;

        while (unSortedIndex > 0) {
            int largestIndex = 0;
            for (int i = largestIndex; i < unSortedIndex; i++) {
                if (inputArray[i + 1] >inputArray[largestIndex]) {
                    largestIndex=i + 1;
                }
            }
            swap(inputArray, largestIndex, unSortedIndex);
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
