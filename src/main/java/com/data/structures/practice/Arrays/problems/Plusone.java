package com.data.structures.practice.Arrays.problems;

import java.util.Arrays;

public class Plusone {

    public static void main(String[] args) {
        //int[] nums1 = {9};
        //int[] nums1 = {9,8,7,6,5,4,3,2,1,0};
        //int[] nums1 = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        //int[] nums1 = {9,9,9};
        int[] nums1 = {8, 9, 9, 9};
        // System.out.println(Arrays.toString(plusOne(nums)));
        // System.out.println(Arrays.toString(plusOne(nums1)));
//System.out.println(Arrays.toString(nums));
//System.out.println(Arrays.toString(plusOneWithPower(nums1)));
        System.out.println(Arrays.toString(directAdd(nums1)));
    }

    private static int[] plusOne(int[] digits) {
        String finalValue = "";
        for (int k = 0; k < digits.length; k++) {
            if (k == 0) {
                if (k == digits.length - 1) {
                    finalValue = (digits[k] + 1) + "";
                } else {
                    finalValue = digits[k] + "";
                }
            } else if (k == digits.length - 1) {
                finalValue = finalValue + "," + (digits[k] + 1);
            } else {
                finalValue = finalValue + "," + digits[k];
            }

        }
//        int counter=1;
//        long finalValue1 = Long.parseLong(finalValue)+1;
//        System.out.println(finalValue1);
//        String finalValue2=finalValue1+"";
//        int width= finalValue2.length()-1;
        String[] response1 = finalValue.split(",");
        int[] response = new int[response1.length];

        for (int k = 0; k < response1.length; k++) {
            response[k] = Integer.parseInt(response1[k]);
        }
        int arryCOu = 0;
//        while (width >=0 )
//        {
//            response[arryCOu++]=(int)Math.floor(finalValue1/(int)Math.pow(10,width))%10;
//            width--;
//        }
        return response;
    }

    private static int[] plusOneWithPower(int[] digits) {
        long largeInteger = 0;
        int width = digits.length - 1;
        for (int k = 0; k < digits.length; k++) {
            if (k == digits.length - 1) {
                largeInteger = largeInteger + (digits[k] * (long) Math.pow(10, width)) + 1;

            } else {
                largeInteger = largeInteger + (digits[k] * (long) Math.pow(10, width));
            }
            width--;
        }
        String[] response1 = (largeInteger + "").split("");
        int[] response = new int[response1.length];
        for (int k = 0; k < response1.length; k++) {
            response[k] = Integer.parseInt(response1[k]);
        }
        return response;
    }

    private static int[] directAdd(int[] digits) {
        int reminder = 0;
        for (int k = digits.length - 1; k >= 0; k--) {
            int currentValue = digits[k] + reminder;
            if (k == digits.length - 1) {
                currentValue = currentValue + 1;
            }
            if (currentValue == 10) {
                digits[k] = 0;
                reminder = 1;
            } else {
                digits[k] = currentValue;
                reminder = 0;
            }
        }
        if (reminder == 1) {
            int[] response1 = new int[digits.length + 1];
            System.arraycopy(response1, 1, digits, 0, digits.length);
            response1[0] = reminder;
            return response1;
        }
        return digits;
    }
}
