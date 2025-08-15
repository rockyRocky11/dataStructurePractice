package com.data.structures.practice.LeetCode.treePrac;

public class hasPathSum {
    public static void main(String[] args) {
        //Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,null,1}; // Expected output: true
        Integer[] root = {1}; // Expected output: true
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        //System.out.println(hasPathSum(tree, 22));
        System.out.println(hasPathSum(tree, 1));
    }

    public boolean hasPathSumSpecial(TreeNodeImpl root, int targetSum) {
        if(root==null)
            return false;
        if(root.val==targetSum && root.left == null && root.right==null)
            return true;
        else
            return hasPathSumSpecial(root.left,targetSum-root.val)|| hasPathSumSpecial(root.right,targetSum-root.val);

    }

    public static boolean hasPathSum(TreeNodeImpl root, int targetSum) {
        if(root == null){
            return false;
        }

        int[] sum = new int[1];
        sum[0] = root.val;
        return dfs(root, targetSum, sum);
    }

    public static boolean dfs(TreeNodeImpl root, int targetSum, int[] sum){

       if(isLeafNode(root)){
           return sum[0] == targetSum;
       }
       if(root.left != null){
           sum[0]+=root.left.val;
           if(dfs(root.left, targetSum, sum)){
               return true;
           }else{
               sum[0]-=root.left.val;
           }
       }

        if(root.right != null){
            sum[0]+=root.right.val;
            if(dfs(root.right, targetSum, sum)){
                return true;
            }else{
                sum[0]-=root.right.val;
            }
        }

        return false;
    }

    public static boolean isLeafNode(TreeNodeImpl root){
        return root != null && root.left == null && root.right == null;
    }
}
