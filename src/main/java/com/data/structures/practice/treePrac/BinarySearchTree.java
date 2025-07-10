package com.data.structures.practice.treePrac;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    public static void main(String[] args) {
//        Tree intTree = new Tree();
//        intTree.insert(25);
//        intTree.insert(20);
//        intTree.insert(15);
//        intTree.insert(27);
//        intTree.insert(30);
//        intTree.insert(29);
//        intTree.insert(26);
//        intTree.insert(22);
//        intTree.insert(32);
//       // intTree.insert(17);
//        //intTree.traverseInOrder();
//        //System.out.println();
////        System.out.println(intTree.get(25).getData());
////        System.out.println(intTree.min());
////        System.out.println(intTree.max());
////        intTree.delete(15);
////        intTree.traverseInOrder();
////        System.out.println();
////        intTree.delete(17);
////        intTree.traverseInOrder();
////        System.out.println();
//       // intTree.delete(25);
//       // intTree.traverseInOrder();
//        //System.out.println();
//        //intTree.delete(251);
//        //intTree.inorderTraversal();
//        //System.out.println();
//
//        Tree intTree1 = new Tree();
//        intTree1.insertlevel(25);
//        intTree1.insertlevel(20);
//        intTree1.insertlevel(15);
//        intTree1.insertlevel(27);
//        intTree1.insertlevel(30);
//        intTree1.insertlevel(29);
//        intTree1.insertlevel(26);
//        intTree1.insertlevel(22);
//        intTree1.insertlevel(32);

//        Tree intTree1 = new Tree();
//        intTree1.insertlevel(2);
//        intTree1.insertlevel(2);
//        intTree1.insertlevel(2);
//        intTree1.insertlevel(0);
//        intTree1.insertlevel(2);
//        intTree1.insertlevel(0);
//        intTree1.insertlevel(0);
//        intTree1.insertlevel(2);
        Tree intTree1 = new Tree();
        Integer[] in ={1,2,2,3,4,4,3};
        //Integer[] in ={1,2,2,null,3,null,3};
        intTree1.buildTree(in);
        TreeNode treeNode = new TreeNode(10);
        List<Integer> res1 = treeNode.inorderTraversal(intTree1.getData().getLeftChild());
        System.out.println(res1);

        List<Integer> res2 = treeNode.inorderReverseTraversal(intTree1.getData().getRightChild());
        System.out.println(res2);

        System.out.println(treeNode.IsMirror(intTree1.getData().getLeftChild(), intTree1.getData().getRightChild()));

        System.out.println(res1.containsAll(res2));

        Tree intTree2 = new Tree();
        Integer[] in2 ={2,2,2,2,null,2,null};
        intTree2.buildTree(in2);
//        intTree2.insertlevel(2);
//        intTree2.insertlevel(2);
//        intTree2.insertlevel(2);
//        intTree2.insertlevel(2);
//        intTree2.insertlevel(0);
//        intTree2.insertlevel(2);
//        intTree2.insertlevel(0);
        List<Integer> res3 = intTree2.inorderTraversal();
        System.out.println(intTree2.inorderTraversal());

        System.out.println(inorderTraversalComp1(intTree1.getData(), intTree2.getData()));

//        int i=0;
//        int j=0;
//        while(i<res1.size() && j<res2.size()){
//            if(res1.get(i++)!= res2.get(j++)){
//                System.out.println(false);
//            }
//        }
//        System.out.println(true);
    }

    public static boolean inorderTraversalComp1(TreeNode root, TreeNode root1) {
        //List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();

        while ((root != null || root1 != null)|| !stack.isEmpty()) {
            while (root != null && root1 != null) {
                stack.push(root);
                stack1.push(root1);
                root = root.getLeftChild();
                root1 = root1.getLeftChild();


            }
            root = stack.pop();
            root1 = stack1.pop();
            if(root.getData() != root1.getData()){
                return false;
            }
            root = root.getRightChild();
            root1 = root1.getRightChild();
            if(root ==null && root1 == null){
                continue;
            }
            if(root1 == null || root == null){
                return false;
            }
        }
        return true;
    }
}
