package com.data.structures.practice.bitmanipulation;

import java.util.Arrays;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBitsBetterVersion(21));
        //System.out.println(reverseBits(-3));

    }
    public static long reverseBits(int n) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<32;i++){
            int num =(n & (1 << i)) != 0?1:0;
            res.append(num);
        }

        return Integer.parseInt(res.toString(),2);
    }

    public static long reverseBitsBetterVersion(int n) {
        /*long result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Step 1: Shift result left by 1 to make space
            result |= (n & 1);     // Step 2: Copy the least significant bit (LSB) of n to result
            n >>= 1;               // Step 3: Shift n right to process the next bit
        }
        return result;*/
        int res=0;
        for(int i=0;i<32;i++){
            res=res<<1;//I'm moving least bit one step to left
            int temp=n&1;//temp becomes 1 is the last bit is 1
            res=res|temp;
            n=n>>1;//pick the next  bit from the input

        }
        return res;
    }
}
