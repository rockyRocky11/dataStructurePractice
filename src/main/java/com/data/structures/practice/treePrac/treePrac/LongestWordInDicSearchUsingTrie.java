package com.data.structures.practice.treePrac.treePrac;


import java.util.*;

public class LongestWordInDicSearchUsingTrie {

    public static void main(String[] args) {

        //String[] words = {"w","wo","wor","worl","world"};
        String[] words = {"banana"};
        //String[] words = {"w","wo","wor","worl","world"};
        //String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        //String[] words = {"htncv","htncvn","b","mvaqrm","mv","mvaqr","mva","ht","mvaq","i","h","htnc"};
       /// System.out.println(longestWord(words));
        //System.out.println(longestWordSet(words));
        System.out.println(longestWord(words));

    }

   /* Sorting the array (Arrays.sort(words)):
    The sort operates in O(n log n), where n is the number of words.
    It relies on string comparisons, so each comparison may take up to O(L) time, with L being the maximum word length. Thus, sorting overall costs O(n × L × log n).
    simplyleet.com

    Iterating through each word:

    There are n words, so n iterations.

    In each iteration:

    A substring operation (word.substring(...)) takes O(L) in the worst case.

    Checking valid.contains(...) is O(L) for hashing and comparison.

    So each iteration costs O(L). For all n words, that's O(n × L).

    Total Time Complexity:
    Combining both stages gives:
    O(n × L × log n + n × L) ≈ O(n × L × log n).*/
   public static String longestWordSet(String[] words) {

       String res="";
       Set<String> valid = new HashSet<>();
       Arrays.sort(words);
       for(String word: words){
           if(word.length() ==1 || valid.contains(word.substring(0, word.length()-1))){
               valid.add(word);
               if(word.length()>res.length() || (word.length()==res.length() && word.compareTo(res)<0)){
                   res = word;
               }
           }

       }
       return res;

   }

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


   /* Time Complexity
    Building the Trie

    Inserting all words into the Trie takes O(N) time, where N is the total number of characters across all words.
    Franco Fernando
    Fernando Franco SWE

    Depth-First Search (DFS) Traversal

    The DFS explores every valid path (i.e. nodes where word != null), but doesn't repeatedly explore branches—each node is visited at most once.

    Thus, DFS runs in O(N), since N is proportional to the total number of Trie nodes, which is bounded by total characters.
    Franco Fernando
    Fernando Franco SWE

    Overall Time Complexity:
    O(N) — linear in the total input size (sum of word lengths).*/
    public static String longestWord(String[] words) {
       Trie trie = new Trie();
        TrieNode node =trie.insert(words);
        return dfs( node);
    }

    public static String dfs(TrieNode node) {
        String ans=node.word==null?"":node.word;
        for(TrieNode trieNode: node.c){
            if(trieNode != null && trieNode.word != null){
                System.out.println(trieNode.word);

                String childWord = dfs( trieNode);
                if(childWord.length()>ans.length()){
                    ans = childWord;
                }
            }
        }
        return ans;
    }

}

