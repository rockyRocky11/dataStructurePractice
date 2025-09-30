package com.data.structures.practice.treePrac;


public class TrieImpl {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.searchWord("apple"));

    }

    static class TrieNode{
    boolean isWord;
    TrieNode[] c = new TrieNode[26];
}

    static class Trie{
        TrieNode root = new TrieNode();

        void insert(String word){

            TrieNode node = root;

            for(char c: word.toCharArray()){
                int i=c-'a';
                if(node.c[i] == null){
                    node.c[i] = new TrieNode();
                }
                node = node.c[i];
            }
            node.isWord = true;
        }

        boolean startsWIth(String word){
            return find(word) != null;
        }

        boolean searchWord(String word){
            TrieNode res = find(word);
            return res != null && res.isWord;
        }

        TrieNode find(String word){
            TrieNode node = root;

            for(char c: word.toCharArray()){
                int i=c-'a';
                if(node.c[i] == null){
                   return null;
                }
                node = node.c[i];
            }
            return node;
        }
        //if prefix is present return it else return emmpty string
        public String findPrefix(String word){
            TrieNode temp=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                int index=ch-'a';
                //the character is not present prefix cannot be found
                if(temp.c[index]==null){
                    return "";
                }
                //move temp to that child node
                temp=temp.c[index];
                if(temp.isWord){
                    return word.substring(0,i+1);
                }
            }
            return "";
        }

    }
}
