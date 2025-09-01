package com.data.structures.practice.linkedList.algorithms;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

public class FloydsAlgorithmCycle {

   /* ⚡ Complexity

    Time: O(n) → Each pointer traverses at most n nodes.

            Space: O(1) → No extra memory.*/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {         // collision → cycle exists
                return true;
            }
        }

        return false; // reached end → no cycle
    }
}
