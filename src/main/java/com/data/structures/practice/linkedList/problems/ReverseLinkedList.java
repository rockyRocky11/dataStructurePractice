package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;
import com.data.structures.practice.linkedList.fundamentals.singly.ListNodeCode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
        listNodeCode.addToFront(5);
        listNodeCode.addToFront(4);
        listNodeCode.addToFront(3);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(0);
//        listNodeCode.addToFront(1);
        listNodeCode.PrintLinkedList();
        ListNode listNodeCode1 =  reverseList(listNodeCode.getHead());
        listNodeCode.PrintLinkedList();
    }

    public static ListNode reverseList(ListNode head) {

        ListNode reverse = null;
        while (head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = reverse; //current node will go into the next of new node
            reverse = temp;

        }
        return reverse;

    }
}


