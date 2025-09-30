package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;
import com.data.structures.practice.linkedList.fundamentals.singly.ListNodeCode;

public class FindElement {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
        listNodeCode.addToFront(11);
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
        System.out.println(findLast(listNodeCode.getHead()));
    }

    public static int findLast(ListNode head) {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            return head.val;
        }

        if (head.next.next == null) {
            return head.next.val;
        }


        ListNode fast = head.next.next;
        ListNode last = head.next.next;

        while (fast != null && fast.next != null) {
            last = fast;
            fast = fast.next.next;

        }

        if (fast != null) {
            return fast.val;
        } else {
            if(last.next != null) {
                return last.next.val;
            }
            else{
                return last.val;
            }
        }

    }
}
