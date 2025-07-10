package com.data.structures.practice.LeetCode.treePrac;

public class InOrderSuccessor {
    private static int successor = -1;
    private static boolean successorFOund;

    public static void main(String[] args) {
        //Integer[] root = {2, 1, 3};
        Integer[] root = {20, 8, 22, 4, 12, null, null, null, null, 10, 14};
        TreeNode tree = new TreeNode();
        tree = tree.inertBulkLevelOrder(root);
        // inorderSuccessor(tree, new TreeNode(3));
        System.out.println(inorderSuccessor1(tree, new TreeNode(8)));
    }

    /*This code performs usual inorder traversal, while doing it we find the successor*/
    //Time and Space is O(n)--> this is inefficient
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode x) {

        if (root == null) {
            return root;
        }
        TreeNode l = inorderSuccessor(root.left, x);
        if (successorFOund) {
            successor = root.val;
            successorFOund = false;
            return root;
        }
        if (root.val == x.val) {
            successorFOund = true;
        }
        TreeNode r = inorderSuccessor(root.right, x);
        return root;
    }


    /*Here, we are using some unique logic to find the inorder successor, refer notes from note to understand, under BST section.*/
    public static int inorderSuccessor1(TreeNode root, TreeNode x) {

        if (root == null) {
            return -1;
        }
        TreeNode givenNode = findNode(root, x);
        if (givenNode.right != null) {
            return findMin(givenNode.right).val;
        } else {
            return findAncestor( root,  givenNode);
        }
    }

    //Time COmp: O(H)
    public static int findAncestor(TreeNode root, TreeNode givenNode) {

        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != null) {
            if (givenNode.val < ancestor.val) {
                successor = ancestor;
                ancestor = ancestor.left;

            } else {
                ancestor = ancestor.right;
            }
        }
        return successor.val;
    }

    //Time COmp: O(H)
    public static TreeNode findNode(TreeNode root, TreeNode x) {

        if (root == null) {
            return null;
        }
        if (root.val == x.val) {
            return root;
        }

        if (x.val < root.val) {
            return findNode(root.left, x);
        } else {
            return findNode(root.right, x);
        }
    }

    //Time COmp: O(H)
    public static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
