package com.data.structures.practice.sorting.implementation;

import java.util.Arrays;

public class Counting {
    public static void main(String[] args) {

        int[] inputArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        int max = 10;
        int min= 1;

        int[] countingArray = new int[(max - min)+1];

        for (int i=0;i< inputArray.length;i++){
            countingArray[inputArray[i]-1]++;
        }
        System.out.println(Arrays.toString(countingArray));
        int c=0;
        for(int j=0;j<countingArray.length;j++){
            int currentValue = countingArray[j];
            while(currentValue>0){
                inputArray[c++]=j+1;
                currentValue--;
            }

        }
        for (int j : inputArray) {
            System.out.println(j);
        }
    }

}
