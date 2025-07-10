package com.data.structures.practice.LeetCode.linkedList;

public class RemoveDuplicatesUnSorted {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(3);
        listNodeCode.addToFront(1);
        listNodeCode.addToFront(6);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(3);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(1);
        listNodeCode.addToFront(5);


        listNodeCode.PrintLinkedList();
        ListNode listNodeCode1 =  deleteDuplicatesSimple(listNodeCode.getHead());
        listNodeCode.PrintLinkedList(listNodeCode1);


    }

    public static ListNode deleteDuplicatesSimple(ListNode head) {
        ListNode current = head;
        ListNode unique = null;
        ListNode uniqueCurrent = null;
        int[] countingArray = new int[100];


        while (current != null ) {
            countingArray[current.val]++;
            if(countingArray[current.val] == 1){
                if(unique == null){
                    unique = new ListNode((current.val));
                    uniqueCurrent = unique;
                }
                else{
                    uniqueCurrent.next = new ListNode(current.val);
                    uniqueCurrent =uniqueCurrent.next;
                }
            }

                current = current.next;

        }

        return unique;
    }


    public static ListNode removeNode(ListNode prevNode, ListNode removeNode) {

        prevNode.next = removeNode.next;
        removeNode.next = null;
        return prevNode;
    }
}
