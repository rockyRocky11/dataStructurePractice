package com.data.structures.practice.hashtable.fundamental;

public class ChainingHashMap {

    class HashTable<K, V> {
        private class Node<K, V> {
            K key;
            V value;
            Node<K, V> next;
            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity = 16;
        private Node<K, V>[] buckets;

        @SuppressWarnings("unchecked")
        public HashTable() {
            buckets = new Node[capacity];
        }

        private int getIndex(K key) {
            return key.hashCode() & (capacity - 1); // same as mod if capacity power of 2
        }

        public void put(K key, V value) {
            int index = getIndex(key);
            Node<K, V> head = buckets[index];

            // update if key exists
            for (Node<K, V> curr = head; curr != null; curr = curr.next) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
            }

            // else insert new at head
            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = head;
            buckets[index] = newNode;
        }

        public V get(K key) {
            int index = getIndex(key);
            Node<K, V> head = buckets[index];
            for (Node<K, V> curr = head; curr != null; curr = curr.next) {
                if (curr.key.equals(key)) return curr.value;
            }
            return null;
        }

        public void remove(K key) {
            int index = getIndex(key);
            Node<K, V> curr = buckets[index];
            Node<K, V> prev = null;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev != null) prev.next = curr.next;
                    else buckets[index] = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

}
