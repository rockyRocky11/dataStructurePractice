package com.data.structures.practice.bitmanipulation;

public class DivideTwoNumbers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
    public static int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        // Determine if the result should be negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to positive longs
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;

        // Bit-shifting division logic
        while (a >= b) {
            long tempDivisor = b;
            long multiple = 1;

            while (a >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;// this is 2^x;How many times i did 2^x;
            }

            a -= tempDivisor;
            result += multiple;
        }

        return (int) (negative ? -result : result);
    }
}
