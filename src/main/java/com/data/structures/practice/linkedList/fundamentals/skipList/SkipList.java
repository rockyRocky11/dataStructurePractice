package com.data.structures.practice.linkedList.fundamentals.skipList;

public class SkipList {
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5; // probability of promotion

    private Node head;
    private int level; // current max level

    static class Node {
        int val;
        Node[] forward;

        Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level + 1];
        }
    }

    public SkipList() {
        head = new Node(-1, MAX_LEVEL); // dummy head
        level = 0;
    }

    private int randomLevel() {
        int lvl = 0;
        while (Math.random() < P && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }

    // Search
    public boolean search(int target) {
        Node curr = head;
        for (int i = level; i >= 0; i--) {// going down to all levels, because at zero level we have all nodes
            while (curr.forward[i] != null && curr.forward[i].val < target) {// going right until target value is greater than the node value
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    // Insert
    public void insert(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;//appending the tail rest of the portion from 9the insert position
        }
        curr = curr.forward[0];

        if (curr == null || curr.val != num) { // only insert if not present, remove this if duplicate allowed
            int lvl = randomLevel();
            if (lvl > level) {
                for (int i = level + 1; i <= lvl; i++) {
                    update[i] = head;
                }
                level = lvl;
            }
            Node newNode = new Node(num, lvl);// Make sure to pass the newLvl
            for (int i = 0; i <= lvl; i++) {// Make sure to run loop in the newLvl
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    // Delete
    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];
        if (curr != null && curr.val == num) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != curr) break;
                update[i].forward[i] = curr.forward[i];
            }
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.insert(1);
        sl.insert(3);
        sl.insert(7);
        sl.insert(9);
        sl.insert(11);
        sl.insert(2);

        System.out.println(sl.search(3)); // true
        System.out.println(sl.search(5)); // false

        sl.erase(3);
        System.out.println(sl.search(3)); // false
    }
}
