package com.data.structures.practice.greedy;

import java.util.Arrays;

public class AssignCookies {

    static {
        int[] g = {10,9,8,7}, s = {5,6,7,8};
        for (int i = 0; i < 300; i++) findContentChildren(g, s);
    }
    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
       // int[] g = {1, 2, 3}, s = {};
        //int[] g = {1, 2, 3}, s = {3};
        //int[] g = {10,9,8,7}, s = {5,6,7,8};
        //int[] g = {1, 2}, s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
        System.out.println(findContentChildren1(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        //Arrays.sort(s);


        int res = 0;
        if(s.length==0){
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < g.length; i++) {

            while (counter < s.length) {
                if (g[i] <= s[counter]) {
                    res++;
                    counter++;
                    break;
                }
                counter++;
            }
        }
        return res;
    }

    public static int findContentChildren1(int[] g, int[] s) {

        Thread t1 = new Thread(() -> Arrays.sort(g));
        Thread t2 = new Thread(() -> Arrays.sort(s));
        // Arrays.sort(g);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){}

        int res = 0;
       int i = 0;
       int j=0;
       int n=g.length;
       int m=s.length;
       while(i< n&& j<m){
           if(s[j]>=g[i]){
               res++;
               i++;
           }
               j++;

       }
        return res;
    }
}
