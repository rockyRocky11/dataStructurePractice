package com.data.structures.practice.LeetCode.treePrac;

public class InOrderSuccessor {
    private static int successor = -1;
    private static boolean successorFOund;

    public static void main(String[] args) {
        //Integer[] root = {2, 1, 3};
        Integer[] root = {20, 8, 22, 4, 12, null, null, null, null, 10, 14};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        // inorderSuccessor(tree, new TreeNode(3));
        System.out.println(inorderSuccessor1(tree, new TreeNodeImpl(8)));
    }

    /*This code performs usual inorder traversal, while doing it we find the successor*/
    //Time and Space is O(n)--> this is inefficient
    public static TreeNodeImpl inorderSuccessor(TreeNodeImpl root, TreeNodeImpl x) {

        if (root == null) {
            return root;
        }
        TreeNodeImpl l = inorderSuccessor(root.left, x);
        if (successorFOund) {
            successor = root.val;
            successorFOund = false;
            return root;
        }
        if (root.val == x.val) {
            successorFOund = true;
        }
        TreeNodeImpl r = inorderSuccessor(root.right, x);
        return root;
    }


    /*Here, we are using some unique logic to find the inorder successor, refer notes from note to understand, under BST section.*/
    public static int inorderSuccessor1(TreeNodeImpl root, TreeNodeImpl x) {

        if (root == null) {
            return -1;
        }
        TreeNodeImpl givenNode = findNode(root, x);
        if (givenNode.right != null) {
            return findMin(givenNode.right).val;
        } else {
            return findAncestor( root,  givenNode);
        }
    }

    //Time COmp: O(H)
    public static int findAncestor(TreeNodeImpl root, TreeNodeImpl givenNode) {

        TreeNodeImpl successor = null;
        TreeNodeImpl ancestor = root;
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
    public static TreeNodeImpl findNode(TreeNodeImpl root, TreeNodeImpl x) {

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
    public static TreeNodeImpl findMin(TreeNodeImpl root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
