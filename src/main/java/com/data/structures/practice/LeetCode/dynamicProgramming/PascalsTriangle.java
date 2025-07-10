package com.data.structures.practice.LeetCode.dynamicProgramming;


import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int input = 3;
        List<List<Integer>> res = generate1(input);
        //System.out.println(res.toArray().toString());
        //System.out.println(getRow(3));
        //System.out.println(getRowWithFormula(5));
        System.out.println(getPascalFormula(5));


    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> responseList = new ArrayList<>(30);
        responseList.add(List.of(1));

        return generateRecurrsion(numRows, responseList);
    }

    public static List<List<Integer>> generateRecurrsion(int numRows, List<List<Integer>> responseList) {
        if (numRows == 1) {
            return responseList;
        }
        responseList.add(List.of(1, 1));
        if (numRows == 2) {
            return responseList;
        }

        for (int k = 3; k <= numRows; k++) {
            List<Integer> temp = new ArrayList<>(k);
            temp.add(1);
            for (int i = 1; i < k - 1; i++) {
                List<Integer> prevArray = responseList.get(k - 2);
                // for (int j = 1; j < prevArray.size(); j++) {
                temp.add(prevArray.get(i - 1) + prevArray.get(i));
                //}

            }
            temp.add(1);
            responseList.add(temp);
        }

        return responseList;
    }

    public static List<Integer> getRow(int rowIndex) {
        return generate(rowIndex+1).get(rowIndex);
    }

    //Using Dynamic Programming
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generate(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        currentRow.add(1);
        result.add(currentRow);

        return result;
    }

    public static List<List<Integer>> getPascalFormula(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for(int r=0;r<numRows;r++) {

            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            long temp = 1;
            for (int i = 1, up = r, down = 1; i <= r; i++, up--, down++) {
                temp = temp * up / down;
                ans.add((int) temp);
            }
            result.add(ans);
        }
        return result;
    }

    public static List<Integer> getRowWithFormula(int r) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long temp = 1;
        for(int i=1,up=r,down=1;i<=r;i++,up--, down++){
            temp=temp*up/down;
            ans.add((int)temp);
        }
        return ans;
    }

}
