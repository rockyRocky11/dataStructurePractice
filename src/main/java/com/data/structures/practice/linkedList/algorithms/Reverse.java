package com.data.structures.practice.linkedList.algorithms;


public class Reverse {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }


    /*Time: O(n)
    Space: O(1)*/
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while (head != null){
            ListNode temp = head;// create a new Node with current head value
            head = head.next; // move head to next for iteration
            temp.next = reverse; // move what is in the reverse node into the temp new node in that way he temp has everything
            reverse = temp;// make temp as reverse

        }
        return reverse;
    }


    /*Time: O(n)
    Space: O(n) (due to recursion call stack).*/
    public ListNode reverseListRecursive(ListNode head) {
        // base case: empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // reverse the rest
        ListNode newHead = reverseListRecursive(head.next);

        // put current node at the end
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
