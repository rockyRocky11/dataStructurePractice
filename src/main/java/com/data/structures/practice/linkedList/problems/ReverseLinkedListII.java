package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;
import com.data.structures.practice.linkedList.fundamentals.singly.ListNodeCode;

public class ReverseLinkedListII {

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
        ListNode listNodeCode1 =  reverseList(listNodeCode.getHead(), 2, 4);
        listNodeCode.PrintLinkedList();
    }

    /*⚡ Complexity

    Time: O(n) (single traversal + reversal).

    Space: O(1) (in-place reversal).*/

    public static ListNode reverseList(ListNode head, int left, int right) {
        int count =1;
        ListNode front = new ListNode(-1);
        ListNode newfront = front;
        while (count<left){
            newfront.next = head;
            head= head.next;
            newfront = newfront.next;
            count++;
        }

        ListNode reverse = null;
        ListNode tail = head;
        while (count<=right){
            ListNode temp = head;
            head = head.next;
            temp.next = reverse; //current node will go into the next of new node
             reverse = temp;
            count++;
        }
        newfront.next = reverse;
        tail.next=head;
        return front.next;

    }
}


