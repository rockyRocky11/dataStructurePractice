package com.data.structures.practice.treePrac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TSTImpl {
    public static void main(String[] args) {
        TSTree tsTree = new TSTree();
        tsTree.insert("bbab");
        /*tsTree.insert("cat");
        tsTree.insert("catter");
        tsTree.insert("bat");
        System.out.println(tsTree.search("bat"));
        System.out.println(tsTree.search("batc"));
        System.out.println(tsTree.findAllPrefix("cat"));*/
        System.out.println(tsTree.findAllPrefix("b"));
    }

    static class TSTNode{

        char ch;
        TSTNode left, middle, right;
        String word;
        TSTNode(char ch){
            this.ch = ch;
        }
    }

    static class TSTree{
        TSTNode root;

        void insert(String key){
            root=insert( key, root, 0);
        }

        TSTNode insert(String s, TSTNode node, int i){
            char c = s.charAt(i);
            if(node == null) node = new TSTNode(c);
            if(c< node.ch){
                node.left = insert( s, node.left, i);
            }else if(c> node.ch){
                node.right = insert( s, node.right, i);
            }else{
                if(i < s.length()-1){
                    node.middle = insert( s, node.middle, i+1);
                }else{
                    node.word= s;
                }
            }
            return node;
        }

        boolean search(String key){
        TSTNode node = search(key, root, 0);
        return node!=null && node.word != null;
        }

        TSTNode search(String s, TSTNode node, int i){
            if(node == null)return null;
            char c = s.charAt(i);
            if(c<node.ch){
                return search(s, node.left, i);
            }else if(c > node.ch){
                return search(s, node.right, i);
            }else{
                if(i< s.length()-1){
                    return search(s, node.middle,i+1);
                }
            }
            return node;
        }

        List<String> findAllPrefix(String prefix){
            if(root ==null)return null;
            List<String> res = new ArrayList<>();
            TSTNode node = search(prefix, root, 0);
            if (node == null) return res;
            if(node.word != null)res.add(node.word);
            collect(   res,  node.left);
            collect(   res,  node.right);
            collect(   res,  node.middle);
            return res;
        }

        void collect(List<String> res, TSTNode node){
            if(node == null)return;
            if(node.word != null)res.add(node.word);
            collect(   res,  node.left);
            collect(   res,  node.right);
            collect(   res,  node.middle);
        }

    }
}
