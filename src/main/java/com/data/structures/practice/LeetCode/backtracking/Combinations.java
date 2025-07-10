package com.data.structures.practice.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }




    //O(C(N,K)∗K)
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList();
        List<Integer> sol = new ArrayList();
        ;
        backTrack(1, n, k, resList, sol);

        return resList;
    }

    public static void backTrack(int currentIndexInSubList, int n, int k, List<List<Integer>> resList, List<Integer> sol) {

        if (sol.size() == k) {
            System.out.println(sol);
            resList.add(new ArrayList<>(sol));
            return;
        }
        int j = currentIndexInSubList;
        //Add all possible options
        while (j <= n) {
            sol.add(j);
            backTrack(j + 1, n, k, resList, sol);
            sol.remove(sol.size() - 1);
            j++;
        }
    }

    //    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> resList = new ArrayList();
//        List<Integer> sol = new ArrayList();
//        ;
//        backTrack(n , k, resList, sol);
//
//        return resList;
//    }

//    public static void backTrack( int n, int k, List<List<Integer>> resList, List<Integer> sol) {
//
//        if (sol.size() == k) {
//            resList.add(new ArrayList<>(sol));
//            return;
//        }
//
//        //Dont pick n
//        int left = n;
//        int still_need = k-sol.size();
//        if(left>still_need) {
//            backTrack(n - 1, k, resList, sol);
//        }
//        //pick n
//        sol.add(n);
//        backTrack(n -1, k, resList, sol);
//        sol.remove(sol.size()-1);
//
//    }

}
