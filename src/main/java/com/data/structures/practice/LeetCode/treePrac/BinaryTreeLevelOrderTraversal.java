package com.data.structures.practice.LeetCode.treePrac;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        Integer[] root = {3,9,20,null,null,15,7};
        TreeNodeImpl tree = new TreeNodeImpl();
        tree= tree.inertBulkLevelOrder(root);

        System.out.println(levelOrder(tree));
    }

    /*Idea here is to use hashmap to  keep track of root and its child, with that im grouping the child in one level*/
    public static List<List<Integer>> levelOrder(TreeNodeImpl root) {

        List<List<Integer>> response = new ArrayList<>();

        HashMap<TreeNodeImpl, Integer> store = new HashMap<>();

        Queue<TreeNodeImpl> queue = new LinkedList<>();
        queue.add(root);
        store.put(root, 0);
        response.add(new ArrayList<>(Arrays.asList(root.val)));

        while(!queue.isEmpty()){
            TreeNodeImpl tempRoot = queue.poll();
            System.out.println(tempRoot.val);
            if(tempRoot.left != null){
                queue.add(tempRoot.left);
                store.put(tempRoot.left, store.get(tempRoot)+1);
                if(store.get(tempRoot.left) >= response.size()){
                    response.add(new ArrayList<>(Arrays.asList(tempRoot.left.val)));
                }else{
                    response.get(store.get(tempRoot.left)).add(tempRoot.left.val);
                }
            }
            if(tempRoot.right != null){
                queue.add(tempRoot.right);
                store.put(tempRoot.right, store.get(tempRoot)+1);
                if(store.get(tempRoot.right) >= response.size()){
                    response.add(new ArrayList<>(Arrays.asList(tempRoot.right.val)));

                }else{
                    response.get(store.get(tempRoot.right)).add(tempRoot.right.val);
                }
            }

        }

        return null;

    }

    /*Here, poll all the nodes in one level using for loop with lenght of current Queue*/
    public List<List<Integer>> levelOrder1(TreeNodeImpl root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        Deque<TreeNodeImpl> queue = new ArrayDeque<>();
        queue.offer(root);
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
            res.add(tmp);
        }

        return res;
    }

}
