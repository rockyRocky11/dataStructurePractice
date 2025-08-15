package com.data.structures.practice.LeetCode.treePrac;


import com.data.structures.practice.treePrac.TrieImpl;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {

    static class TrieNode{
        boolean isWord;
        TrieNode[] c = new TrieNode[26];
    }


    public static void main(String[] args) {

       // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a','a'}};
        //String word = "SEE";//true
       // String word = "ABCCED";//true
        //String word = "ABCB";//false
        String word = "aaa";//false
        System.out.println(exist2(board, word));

    }
    public static boolean exist(char[][] board, String word) {
        Map<String, Boolean> visited = new HashMap<>();
        dfs( board,  0,  0, visited);
        return false;
    }
    public static boolean exist2(char[][] board, String word) {

        char firstChar = word.charAt(0);

        outerLoop:
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==firstChar){
                    if(findMatch( board,  i,  j,  word)){
                        return true;
                    }
                }
            }
        }



        return false;
    }

    public static boolean findMatch(char[][] board, int row, int col, String word){
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(row+""+col, true);
        for(int i=1;i<word.length();i++){
            char c = word.charAt(i);
            boolean curCharExist = false;

            if(isCharMatch(board, row+1, col, c, visited)){
                curCharExist = true;
                row = row+1;
                visited.put(row+""+col, true);

            } else if (isCharMatch(board, row-1, col, c, visited)){
                curCharExist = true;
                row = row-1;
                visited.put(row+""+col, true);
            } else if(isCharMatch(board, row, col+1, c, visited)){
                curCharExist = true;
                col = col+1;
                visited.put(row+""+col, true);

            } else if (isCharMatch(board, row, col-1, c, visited)){
                curCharExist = true;
                col = col-1;
                visited.put(row+""+col, true);
            }

            if(!curCharExist){
                return false;
            }

        }
        return true;
    }

    public static boolean isCharMatch(char[][] board, int row, int col, char c, Map<String, Boolean> visited){
        return row >=0 && col >=0 && row< board.length && col<board[0].length && board[row][col]==c &&  !visited.containsKey(row+""+col);
    }



    public static void dfs(char[][] board, int row, int col, Map<String, Boolean> visited) {

        if(row <0 || col <0 || row>= board.length || col>=board[0].length || visited.containsKey(row+""+col)){
            return;
        }
        System.out.print(board[row][col]);
        visited.put(row+""+col, true);

        dfs( board,  row+1,  col, visited);//down
        dfs( board,  row-1,  col, visited);//up
        dfs( board,  row,  col+1, visited);//right
        dfs( board,  row,  col-1, visited);//left

    }
}
