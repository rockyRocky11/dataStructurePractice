package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GnerateParentheses {
    public static void main(String[] args) {
        int  n = 3;
        System.out.println(generateParenthesis(n));

    }

    public static List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        StringBuffer sol = new StringBuffer();
        sol.append("(");
        backTrack(resList, sol, n, 0, 0);
        return resList;
    }

    public static void backTrack(List<String> resList, StringBuffer sol, int n, int openParenthesesLeft, int closeParenthesesLeft){

        if(sol.length() == (2*n)){
            resList.add(sol.toString());
            return;
        }
        if(openParenthesesLeft <n-1) {
            sol.append("(");
            backTrack(resList, sol, n, openParenthesesLeft+1, closeParenthesesLeft);
            sol.deleteCharAt(sol.length()-1);
        }
        if(closeParenthesesLeft <n && closeParenthesesLeft<=openParenthesesLeft){
            sol.append(")");
            backTrack(resList, sol, n, openParenthesesLeft, closeParenthesesLeft+1);
            sol.deleteCharAt(sol.length()-1);
        }

    }
}
