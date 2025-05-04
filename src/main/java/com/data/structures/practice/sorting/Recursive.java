package com.data.structures.practice.sorting;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(recuriseveCall(3));
    }

    private static int recuriseveCall(int number){

        if(number == 0){
            return 1;
        }
        return number*recuriseveCall(number-1);

    }
}
