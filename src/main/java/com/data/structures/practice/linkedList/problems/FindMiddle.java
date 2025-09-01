package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

public class FindMiddle {

   /* https://leetcode.com/problems/middle-of-the-linked-list/

     ⚡ Complexity

    Time: O(n) (single traversal).

    Space: O(1) (just pointers).*/
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }
        // if(fast == null)return slow;
        // if(fast.next == null)return slow;
        return slow;
    }
}
