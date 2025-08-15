package com.data.structures.practice.LeetCode.math;

public class GCDLCM {

    public static void main(String[] args) {
        System.out.println(gcdUsingEuclidean(18, 12));
        System.out.println(lcmUsingGCDEuclidean(18, 12));
    }

   /* Time O(log(min(a,b)))*/
    public static int gcdUsingEuclidean(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    /*Time:
    O(log(min(a,b)))*/
    public static int lcmUsingGCDEuclidean(int a, int b){
        return (a/gcdUsingEuclidean(a,b))*b;
    }

}
