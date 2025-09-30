package com.data.structures.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resList = new ArrayList();
        List<Integer> sol = new ArrayList();
        backTrack(k, n, 1, resList, sol);
        return resList;
    }

    public void backTrack(int k, int n,int curr,  List<List<Integer>> resList, List<Integer> sol){

        if(sol.size()==k && n != 0){
            return;
        }
        if(sol.size() == k && n ==0){
            resList.add(new ArrayList(sol));
        }
        if(sol.size()>k ){
            return;
        }
        if(n < 0){
            return;
        }

        int i = curr;
        while(i<10){
            sol.add(i);
            backTrack(k, n-i, i+1, resList, sol);
            sol.remove(sol.size()-1);
            i++;
        }

    }
}
