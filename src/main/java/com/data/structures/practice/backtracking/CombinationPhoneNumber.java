package com.data.structures.practice.backtracking;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationPhoneNumber {
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));

    }

    public static List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList();
        StringBuffer sol = new StringBuffer();

        char[] digitArray = digits.toCharArray();

        Map<Character, List<Character>> store = new HashMap<>();
        store.put('2', List.of(new Character[]{'a', 'b', 'c'}));
        store.put('3', List.of(new Character[]{'d', 'e', 'f'}));
        store.put('4', List.of(new Character[]{'g', 'h', 'i'}));
        store.put('5', List.of(new Character[]{'j', 'k', 'l'}));
        store.put('6', List.of(new Character[]{'m', 'n', '0'}));
        store.put('7', List.of(new Character[]{'p', 'q', 'r', 's'}));
        store.put('8', List.of(new Character[]{'t', 'u', 'v'}));
        store.put('9', List.of(new Character[]{'w', 'x', 'y', 'z'}));
        backTrack(digitArray, 0,  resList, sol, store);

        return resList;
    }



    public static void backTrack(char[] digitArray, int index, List<String> resList, StringBuffer sol, Map<Character, List<Character>> store) {
        if (sol.length() == digitArray.length) {
            resList.add(sol.toString());
            return;
        }
        if(index >= digitArray.length){
            return;
        }
        char key = digitArray[index];
        for(int i=0;i< store.get(digitArray[index]).size();i++){
            System.out.println("index start "+index);
            sol.append(store.get(key).get(i));
            backTrack(digitArray, index + 1,  resList, sol, store);
            System.out.println("index end "+index);

            sol.deleteCharAt(sol.length() - 1);
        }
    }
}
