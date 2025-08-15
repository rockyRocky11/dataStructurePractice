package com.data.structures.practice.LeetCode.treePrac;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.data.structures.practice.LeetCode.treePrac.MultipleWordSearchUsingTrie.Solution.findWords;

public class MultipleWordSearchUsingTrie {

    /*Summary Table
    Component	Time Complexity	Space Complexity
    Build Trie	O(W × L)	O(W × L)
    DFS on Board	O(m × n × 4^L)	O(L) (call stack)
    Result Storage	—	O(W × L)
    Total	O(W × L + m × n × 4^L)	O(W × L + L)*/
    public static void main(String[] args) {

        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = { "oath","oathk"};
        System.out.println(findWords(board, words));

    }

    class Solution {
        static class TrieNode {
            String word;
            TrieNode[] c = new TrieNode[26];
        }

        static class Trie {
            TrieNode root = new TrieNode();

            TrieNode insert(String[] words) {


                for (String word : words) {
                    TrieNode node = root;
                    for (char ch : word.toCharArray()) {
                        int i = ch - 'a';
                        if (node.c[i] == null) {
                            node.c[i] = new TrieNode();
                        }
                        node = node.c[i];
                    }
                    node.word = word;

                }

                return root;
            }
            TrieNode findChar(char c) {
                TrieNode node = root;
                return node.c[c];
            }

//101, 97, 116
        }

        public static List<String> findWords(char[][] board, String[] words) {

            Trie trie = new Trie();
            List<String> res = new ArrayList<>();
            // for(String word: words) {
            Set<String> set = new HashSet<>();
            TrieNode trieNode = trie.insert(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, trieNode, set);
                }
            }
            //}


            return new ArrayList(set);
        }

        public static void dfs(char[][] board, int row, int col, TrieNode trieNode, Set<String> set) {

            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#' ) {
                return;
            }
            char c = board[row][col];
            if(trieNode.c[c-'a'] == null)return ;
            TrieNode node = trieNode.c[c - 'a'];

            board[row][col] = '#';
            if (node.word != null) {
                set.add(node.word);
                node.word=null;
                //board[row][col] = c;
                // sb.deleteCharAt(sb.length() - 1);
                // return;
            }

            dfs(board, row + 1, col, node, set);//down
            dfs(board, row - 1, col, node, set);//up
            dfs(board, row, col + 1, node, set);//right
            dfs(board, row, col - 1, node, set);//left
            board[row][col] = c;
        }
    }
}
