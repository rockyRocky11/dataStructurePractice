package com.data.structures.practice.treePrac;

public class AVLTreeImpl {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int height;

        TreeNode(int val) {
            this.val = val;
            this.height = 1;// By default height is 1
        }

    }

    static class AVLTree {
        TreeNode root;

        int getHeight(TreeNode n) {
            return n == null ? 0 : n.height;
        }

        int getBalance(TreeNode n) {
            return n == null ? 0 : getHeight(n.left) - getHeight(n.right);
        }

        TreeNode rightRotate(TreeNode y) {// LL case
            TreeNode x = y.left;
            TreeNode t2 = x.right;

            //Rotating Right
            x.right = y;
            y.left = t2;

            //Update Hight on both node involved
            x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left));
            y.height = 1 + Math.max(getHeight(y.right), getHeight(y.left));
            return x;
        }

        TreeNode leftRotate(TreeNode x) {// RR case
            TreeNode y = x.right;
            TreeNode t2 = y.left;

            //Rotating Left
            y.left = x;
            x.right = t2;

            //Update Hight on both node involved
            x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left));
            y.height = 1 + Math.max(getHeight(y.right), getHeight(y.left));
            return y;
        }

        void insert(int val) {
            root = insert(root, val);
        }

        TreeNode insert(TreeNode node, int val) {
            if (node == null) return new TreeNode(val);
            if (val < node.val) {
                node.left = insert(node.left, val);
            } else if (val > node.val) {
                node.right = insert(node.right, val);
            } else {
                return node;
            }

            //Update the height
            node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

            //Check if balanced
            int bal = getBalance(node);

            //LL Case Do Right ROtate
            if (bal > 1 && val < node.left.val) {
                return rightRotate(node);
            }

            //RR case DO left rotate
            if (bal < -1 && val > node.right.val) {
                return leftRotate(node);
            }

            //LR Case Do Left Right ROtate
            if (bal > 1 && val > node.left.val) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            //RL Case Do Right Left ROtate
            if (bal < -1 && val < node.right.val) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            return node;

        }

        void preOrder(TreeNode node){
            if(node != null){
            System.out.println(node.val+" ");
            preOrder(node.left);
            preOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] keys = { 30, 20, 10, 25, 40, 50, 45 };
        for (int k : keys) {
            avlTree.insert(k);
        }

        System.out.println("Preorder traversal after insertions:");
        avlTree.preOrder(avlTree.root);
    }
}
