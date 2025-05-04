package com.data.structures.practice.sorting;

public class Shell {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, -1, -22};

        for(int i = inputArray.length/2;i>=1;i=i/2)
        {
            System.out.println("Gap = "+i);

            for(int j=i;j<inputArray.length;j++){
                int unSortedValue= inputArray[j];
                int diff = j;
                boolean swaped = false;
                int swapIndex = 0;
                while(diff-i>=0){
                    int sortedValue= inputArray[diff-i];
                    if (sortedValue >unSortedValue) {
                        inputArray[diff]=sortedValue;
                        swapIndex =diff-i;
                        swaped=true;
                    }
                    diff=diff-i;
                }
                if(swaped){
                inputArray[swapIndex]=unSortedValue;
                }

            }

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
