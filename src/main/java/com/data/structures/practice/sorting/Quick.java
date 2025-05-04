package com.data.structures.practice.sorting;

public class Quick {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};

        for(int  pivotIndex=0;pivotIndex<inputArray.length; pivotIndex++){
            int pivotElement = inputArray[pivotIndex];
            int i = pivotIndex;
            int j= inputArray.length;
            while(i<j) {
                // alternate method is empty while loop
                while (i < j) {
                    if (inputArray[--j] < pivotElement) {
                        inputArray[i] = inputArray[j];
                        break;
                    }
                }
                while (i < j) {
                    if (inputArray[++i] > pivotElement) {
                        inputArray[j] = inputArray[i];
                        break;
                    }
                }
            }
            inputArray[i]=pivotElement;
        }

        for (int j : inputArray) {
            System.out.println(j);
        }

    }
}
