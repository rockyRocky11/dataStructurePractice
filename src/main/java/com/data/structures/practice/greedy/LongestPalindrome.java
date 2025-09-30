package com.data.structures.practice.greedy;

import java.util.Arrays;

public class LongestPalindrome {

    static {
        for (int i = 0; i < 100; i++) {
            longestPalindrome("A");
        }
    }
    public static void main(String[] args) {
        String s ="abccccdd";
        //String s ="ccc";
        //String s ="a";

        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));
    }

    public static int longestPalindrome(String s) {

        String[] inputArray = s.split("");
        int[] countingArray = new int[inputArray.length];
        Arrays.sort(inputArray);
        String current = inputArray[0];
        countingArray[0]++;
        int counter=0;
        for(int i=1;i<inputArray.length;i++){
            if(!current.equals(inputArray[i])){
                counter++;
                current=inputArray[i];
            }
            countingArray[counter]++;
        }
        Arrays.sort(countingArray);

        int twos=0;
        int ones =0;
        int index =countingArray.length-1;
        while(index >=0 && countingArray[index]>0){

            if(ones == 0 && countingArray[index] ==1){
                ones =1;
            }
            else if(countingArray[index] >1) {
                twos += countingArray[index] / 2;
                if(countingArray[index] % 2 >0 && ones == 0){
                    ones =1;
                }
            }

            index--;
        }
        return (twos> 0?(twos*2):0)+ones;

    }

    public static int longestPalindrome1(String s) {

        int[] countingArray = new int[256];
        for(int i=0;i<s.length();i++){

            countingArray[s.charAt(i)]++;

        }
        Arrays.sort(countingArray);

        int twos=0;
        int ones =0;
        int index =countingArray.length-1;
        while(index >=0 && countingArray[index]>0){

            if(ones == 0 && countingArray[index] ==1){
                ones =1;
            }
            else if(countingArray[index] >1) {
                twos += countingArray[index] / 2;
                if(countingArray[index] % 2 >0 && ones == 0){
                    ones =1;
                }
            }

            index--;
        }
        return (twos> 0?(twos*2):0)+ones;

    }
}
