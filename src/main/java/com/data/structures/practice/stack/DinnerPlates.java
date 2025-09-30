package com.data.structures.practice.stack;

import java.util.EmptyStackException;

public class DinnerPlates {
    private int[] values= new int[Integer.MAX_VALUE];
    private int[] pointer= new int[Integer.MAX_VALUE];

    private int noOfStack = 3;

    public DinnerPlates(int size) {

    }

    public boolean isStackFull(int stackNo) {
        // System.out.println(stackNo);
//System.out.println(pointer[stackNo-1] +" "+(values.length/noOfStack)*stackNo);
        return pointer[stackNo - 1] == (values.length / noOfStack);

    }

    public boolean isStackEmpty(int stackNo) {
        // System.out.println(stackNo);
        // System.out.println(pointer[stackNo-1] +" "+(values.length/noOfStack)*stackNo);
        return pointer[stackNo - 1] == 0;

    }

    public void add(int stackNo, int value) {
        //System.out.println(stackNo +" "+value);

        if (isStackFull(stackNo)) {
            throw new StackOverflowError();
        }
        int startIndex = (stackNo - 1) * (values.length / noOfStack);
        values[startIndex + pointer[stackNo - 1]] = value;
        pointer[stackNo - 1]++;
    }

    public void remove(int stackNo, int index) {
        //System.out.println(stackNo +" "+index);

        if (isStackEmpty(stackNo)) {
            throw new EmptyStackException();
        }
        int startIndex = (stackNo - 1) * (values.length / noOfStack);
        values[startIndex + index - 1] = 0;
        pointer[stackNo - 1]--;
    }

    public void printAll() {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}
