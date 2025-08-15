package com.data.structures.practice.LeetCode.treePrac;


import com.data.structures.practice.treePrac.TrieImpl;

import java.util.HashMap;
import java.util.Map;

public class WordSearchUsingTrie {


    public static void main(String[] args) {

        //char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
        //char[][] board = {{'a', 'a'}};
        //String word = 'SEE';//true
        //String word = "ABCCED";//true
        String word = "AAB";//false
        //String word = 'ABCB';//false
        //String word = 'aaa';//false
        System.out.println(exist(board, word));

    }

    static class TrieNode {
        boolean isWord;
        TrieNode[] c = new TrieNode[123];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        TrieNode insert(String word) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (node.c[ch] == null) {
                    node.c[ch] = new TrieNode();
                }
                node = node.c[ch];
            }

            node.isWord = true;
            return root;
        }

        TrieNode findChar(char c) {
            TrieNode node = root;
            return node.c[c];
        }


    }

    public static boolean exist(char[][] board, String word) {

        Trie trie = new Trie();
        TrieNode trieNode=trie.insert(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, trieNode)) return true;
            }
        }


        return false;
    }

    public static boolean dfs(char[][] board, int row, int col, TrieNode trieNode) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') {
            return false;
        }
        char c = board[row][col];
        TrieNode node = trieNode.c[c];
        if (node == null) return false;

        if (node.isWord) return true;
        board[row][col] = '#';

        boolean down = dfs(board, row + 1, col, node);//down
        boolean up = dfs(board, row - 1, col, node);//up
        boolean right = dfs(board, row, col + 1, node);//right
        boolean left = dfs(board, row, col - 1, node);//left
        board[row][col] = c;
        return down || up || right || left;
    }
}
