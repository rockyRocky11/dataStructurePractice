package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.ListNode;
import com.data.structures.practice.linkedList.fundamentals.ListNodeCode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
//        listNodeCode.addToFront(2);
//        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(1);
        //listNodeCode.addToFront(3);
        listNodeCode.addToFront(3);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(1);
       // listNodeCode.addToFront(1);

//        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(1);

        listNodeCode.PrintLinkedList();
        ListNode listNodeCode1 =  deleteDuplicatesDisticnt1(listNodeCode.getHead());
        listNodeCode.PrintLinkedList();


    }

    public ListNode deleteDuplicatesSimple(ListNode head) {
        ListNode current = head;


        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {

                current = current.next;
            }
        }

        return head;
    }

    public static ListNode deleteDuplicatesDisticnt(ListNode head) {
        ListNode unique = null;
        ListNode prev = null;
        ListNode current = head;
        boolean dup = false;

        while (current != null) {
            if (prev == null) {
                prev = current;
            } else if (dup && prev.val != current.val) {
                if(unique == null){
                    unique = current;

                }else{
                    unique.next = current;

                }
                dup = false;
                prev = current;
            } else if (prev.val == current.val) {
                dup = true;
            } else {
                dup = false;
                if(unique == null){
                    unique = prev;

                }else{
                    unique.next = prev;

                }
                prev = current;
            }

            current = current.next;
        }

        return unique;
    }

    public static ListNode deleteDuplicatesDisticnt1(ListNode head) {
        ListNode unique = null;
        ListNode uniqueCurrent = null;
        int prev = 1;
        ListNode current = head;

        while (current != null ) {
            int curVal = current.val;
            int nextVal = current.next != null?current.next.val:0;
            if(curVal != prev && curVal != nextVal){
                if(uniqueCurrent == null){
                    unique = new ListNode(curVal);
                    uniqueCurrent = unique;
                }else{
                    uniqueCurrent.next = new ListNode(curVal);
                    uniqueCurrent =uniqueCurrent.next;
                }
            }

            prev= curVal;
            current = current.next;
        }

        return unique;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val == prev.val) {
                curr = removeNode(prev, curr);
            }
            prev = curr;
            curr = curr == null ? null : curr.next;

        }

        return head;
    }

    public static ListNode removeNode(ListNode prevNode, ListNode removeNode) {

        prevNode.next = removeNode.next;
        removeNode.next = null;
        return prevNode;
    }
}
