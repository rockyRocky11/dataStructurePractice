package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

public class OddEvenList {

    /*https://leetcode.com/problems/odd-even-linked-list/

    ⚡ Complexity

    Time: O(n) (one traversal).

    Space: O(1) (ignoring dummy nodes overhead).*/

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = new ListNode(-1);
        ListNode oddDummy = odd;
        ListNode tOdd = head;
        ListNode even = new ListNode(-1);
        ListNode evenDummy = even;
        ListNode tEven = head.next;

        while (tOdd != null && tOdd.next != null && tEven != null && tEven.next != null) {
            oddDummy.next = tOdd;
            oddDummy = oddDummy.next;
            tOdd = tOdd.next.next;
            evenDummy.next = tEven;
            evenDummy = evenDummy.next;
            tEven = tEven.next.next;

        }
        if (tOdd != null)
            oddDummy.next = tOdd;
        if (tEven != null) {
            evenDummy.next = tEven;
            tEven.next = null;//break cycle
        }else{
            evenDummy.next =null;//break cycle
        }
        tOdd.next = even.next;
        return odd.next;
    }

    //This is like Swapping
    public ListNode oddEvenListInPlace(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;            // first node
        ListNode even = head.next;      // second node
        ListNode evenHead = even;       // save even start

        while (even != null && even.next != null) {
            odd.next = even.next;       // link odd to next odd
            odd = odd.next;             // move odd pointer

            even.next = odd.next;       // link even to next even
            even = even.next;           // move even pointer
        }

        odd.next = evenHead;            // attach evens after odds
        return head;
    }
}
