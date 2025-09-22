package com.data.structures.practice.dynamicProgramming;

public class Divide {

    public static void main(String[] args) {
        //System.out.println(divide( 10,  3));
        System.out.println(divide(-2147483648, 1));
    }

    public static int divide(int dividend1, int divisor1) {
        if (dividend1 == Integer.MIN_VALUE && divisor1 == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend1 == Integer.MIN_VALUE && divisor1 == 1) {
            return Integer.MIN_VALUE;
        }
        long dividend = dividend1;
        long divisor = divisor1;

        if (dividend == 0) {
            return 0;
        }
        int i = 1;
        boolean negative1 = false;
        boolean negative = false;
        boolean equ = false;
        if (divisor < 0) {
            divisor = -divisor;
            negative1 = true;
        }
        if (dividend < 0) {
            dividend = -dividend;
            negative = true;
        }
        if(dividend<divisor){
            return 0;
        }
        long temp = divisor;
        while (dividend >= divisor) {
            if (dividend == divisor) {
                equ = true;
                break;
            }


            divisor = divisor + temp;
            i++;
        }

        if (equ) {
            if ((negative &&  !negative1) || (!negative &&  negative1)) {
                i = -i;
            }
            return i;
        }
        i--;
        if ((negative &&  !negative1) || (!negative &&  negative1)) {

            i = -i;
        }
        return i;
    }
}
