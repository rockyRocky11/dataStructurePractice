package com.data.structures.practice.sorting;

import java.util.Arrays;

public class RadixStableCounting {
    public static void main(String[] args) {

        int[] inputArray = {4725, 4586, 1330, 8792, 1594, 5729};
        int max = 10;
        int min = 1;
        int width = 0;

        while (width <4) {
            int[] countingArray = new int[(max - min) + 1];
            for (int i = 0; i < inputArray.length; i++) {
                countingArray[getPositionElementNew(inputArray[i], width)]++;
            }
            System.out.println("Before Adjusting "+Arrays.toString(countingArray));
            int sum=0;
            for(int j=0;j< countingArray.length;j++){
                sum=sum+countingArray[j];
                countingArray[j]=sum;
            }
            int[] tempArray = new int[inputArray.length];
            System.out.println("After Adjusting "+Arrays.toString(countingArray));
            int sdf=0;

            for(int k=inputArray.length-1;k>=0;k--){
                tempArray[--countingArray[getPositionElementNew(inputArray[k], width)]]=inputArray[k];
            }
            System.out.println("After temp sorting "+Arrays.toString(tempArray));
            System.arraycopy(tempArray,0,inputArray, 0, tempArray.length);
            System.out.println("After final sorting "+Arrays.toString(inputArray));
            System.out.println("");
            width++;
        }

        System.out.println("After final sorting "+Arrays.toString(inputArray));
    }

    private static int getPositionElement(int element, int position){
        return Integer.parseInt((element+"").substring(position-1, position));
    }
    private static int getPositionElementNew(int element, int position){
        //Mod by 10 because inputArray is integer- width is 0-9
        //2^3 Any non-zero base raised to the power of 0 is 1.0.
        return element/(int) Math.pow(10, position)%10;
    }

}
