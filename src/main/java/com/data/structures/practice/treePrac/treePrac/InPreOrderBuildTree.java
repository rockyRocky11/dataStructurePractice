package com.data.structures.practice.treePrac.treePrac;

import java.util.*;

public class InPreOrderBuildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
       // int[] preorder = {1, 2}, inorder = {2, 1};
        System.out.println(buildTreeInOrder(preorder, inorder));
        System.out.println(buildTreeWithoutMap(preorder, inorder));
    }
    public static TreeNodeImpl buildTreeInOrder(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrdermap = new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            inOrdermap.put(inorder[i],i);
        }
        return buildTree(preorder, inOrdermap, 0, 0, inorder.length-1);
    }

    public static TreeNodeImpl buildTree(int[] preorder, Map<Integer, Integer> inOrdermap, int preOrderStart, int inOrderStart, int inOrderEnd) {

        if(inOrderStart>inOrderEnd){
            return null;
        }
        int curVal = preorder[preOrderStart];
        int inOrderCurEnd = inOrdermap.get(curVal);
        int noOfNodesInLeft =inOrderCurEnd- inOrderStart;
        TreeNodeImpl root = new TreeNodeImpl(curVal);
        root.left = buildTree(preorder, inOrdermap, preOrderStart+1, inOrderStart, inOrderCurEnd-1);
        root.right = buildTree(preorder, inOrdermap, preOrderStart+noOfNodesInLeft+1, inOrderCurEnd+1, inOrderEnd);


        return root;
    }

    static int  preOrderStart=0;
    static int  inOrderStart=0;
    public static TreeNodeImpl buildTreeWithoutMap(int[] preorder, int[] inorder) {
        preOrderStart=0;
        inOrderStart=0;
        return buildTree12(preorder, inorder,  Integer.MIN_VALUE);
    }

    public static TreeNodeImpl buildTree12(int[] preorder, int[] inorder, int inOrderEnd) {

        if(preOrderStart>=preorder.length){
            return null;
        }
        if(inorder[inOrderStart] == inOrderEnd){
            inOrderStart++;
            return null;
        }

        TreeNodeImpl root = new TreeNodeImpl(preorder[preOrderStart++]);
        root.left = buildTree12(preorder, inorder,  root.val);
        root.right = buildTree12(preorder, inorder,  inOrderEnd);

        return root;
    }
}
