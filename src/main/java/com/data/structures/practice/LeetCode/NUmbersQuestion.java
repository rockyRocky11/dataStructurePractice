package com.data.structures.practice.LeetCode;

public class NUmbersQuestion {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(-123));

    }
    public static int reverse(int x) {
        if(x==0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE){
            return 0;
        }

        long res = 0;
        while (x != 0) {
            int temp= (x % 10) ;
            res=(res*10)+temp;
            x /= 10;
            if(res>=Integer.MAX_VALUE){
                return 0;
            }
        }

        return (int)res;
    }
}
