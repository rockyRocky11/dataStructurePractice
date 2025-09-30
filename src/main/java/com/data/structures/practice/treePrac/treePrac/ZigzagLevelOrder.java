package com.data.structures.practice.treePrac.treePrac;

import java.util.*;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        //Integer[] root = {2, 1, 3};
        Integer[] root = {1,2,3,4,null,null,5};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree = tree.inertBulkLevelOrder(root);
        // inorderSuccessor(tree, new TreeNode(3));
        System.out.println(levelOrder1(tree));
        System.out.println(zigzagLevelOrder(tree));
    }
/*⏱ Time and Space Complexity
    Time Complexity: O(n) where n is the number of nodes — each node is visited once.

    Space Complexity: O(n) for the result list and queue.*/
    public static List<List<Integer>> zigzagLevelOrder(TreeNodeImpl root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNodeImpl> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isRev = false;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                if (!isRev) {
                    TreeNodeImpl r = queue.poll();
                    tmp.add(r.val);
                    if (r.left != null)queue.offer(r.left);
                    if (r.right != null)queue.offer(r.right);
                } else {
                    TreeNodeImpl r = queue.pollLast();
                    tmp.add(r.val);
                    if (r.right != null)queue.offerFirst(r.right);
                    if (r.left != null)queue.offerFirst(r.left);

                }
            }
            res.add(tmp);
            isRev = !isRev;
        }

        return res;
    }

    public static List<List<Integer>> levelOrder1(TreeNodeImpl root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        Deque<TreeNodeImpl> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isRev = false;
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int l = queue.size();
            /*First, for root this loop will run once, next time 2 times, next time 4 times*/
            for(int i = 0; i<l; i++){
                TreeNodeImpl r = queue.poll();
                tmp.add(r.val);
                if(r.left != null)  queue.offer(r.left);
                if(r.right != null) queue.offer(r.right);
            }
            if(isRev){
                Collections.reverse(tmp);
                res.add(tmp);
                isRev=false;
            }else{
                res.add(tmp);
                isRev=true;
            }
        }

        return res;
    }
}
