package com.data.structures.practice.linkedList.fundamentals.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
       System.out.println( lru.get(1));
        lru.put(3,3);
        System.out.println( lru.get(2));
        lru.put(4,4);
        System.out.println( lru.get(1));

    }


    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        // System.out.println(map.containsKey(key));

        Node node = map.get(key);
        if (node != null) {
            removeByNode(node);
            addToFront(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeByNode(map.get(key));
        } else if (cap == map.size()) {
            int rem = removeFromback();
            if (rem != -1)
                map.remove(rem);
        }
        Node newNode = new Node(key, value);
        map.put(key, addToFront(newNode));
    }

    private void removeByNode(Node removeNode) {

        if (removeNode.prev != null) {//Not head
            removeNode.prev.next = removeNode.next;
        } else {
            head = removeNode.next;
        }

        if (removeNode.next != null) {//Not tail
            removeNode.next.prev = removeNode.prev;
        } else {
            tail = removeNode.prev;
        }

        removeNode.prev = null;
        removeNode.next = null;

    }

    private Node addToFront(Node newNode) {
        newNode.next = head;
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        return newNode;
    }

    private int removeFromback() {

        if (tail == null)
            return -1;
        Node remove = tail;
        if (map.size() == 1) {
            head = null;
            tail = null;
            return remove.k;
        }
        Node newTail = tail.prev;
        tail = newTail;
        newTail.next = null;
        remove.prev = null;
        return remove.k;
    }
}

class Node {

    int k, v;
    Node next;
    Node prev;

    public Node(int k, int v) {
        this.k = k;
        this.v = v;
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */