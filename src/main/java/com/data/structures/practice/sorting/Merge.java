package com.data.structures.practice.sorting;

import java.util.ArrayList;
import java.util.List;

public class Merge {
    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, -1, -22};



        recursiveSplit(inputArray, 0, 7);
        for (int j : inputArray) {
            System.out.println(j);
        }
    }

    private static void recursiveSplit(int[] inputArray, int start, int end) {
        System.out.println("\n");
        List tempArray=new ArrayList();
        System.out.println("start ="+start+", end ="+end);
        for (int i = start; i < end; i++) {
            tempArray.add(inputArray[i]);
            System.out.println(inputArray[i]+" "+i);
        }
        if (end- start<2) {
            return;
        }
        int mid=(start+end)/2;
        recursiveSplit(inputArray, start, mid) ;
        recursiveSplit(inputArray, mid, end);
        sortMerge(inputArray, start, mid, end);

    }

    private static void sortMerge(int[] inputArray, int start, int mid, int end){

        System.out.println("Merge "+start+" "+mid+" "+end);

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray= new int[end-start];


        while(i<mid && j < end){
            tempArray[tempIndex++] = inputArray[i] < inputArray[j]? inputArray[i++]: inputArray[j++];
        }
        System.arraycopy(inputArray, i, inputArray, start+tempIndex, mid-i); // This is to take care of left overs on the left side, we dont have to worry about the right side
        System.arraycopy(tempArray, 0, inputArray, start, tempIndex);

    }

}
