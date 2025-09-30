package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CircleDetectionII {


   /* ⚡ Complexity

    Time: O(n) (at most 2 passes of the list).

    Space: O(1) (just pointers).*/
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next ==null)return null;

        ListNode slow=head;
        ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            // System.out.println(slow.val+" "+fast.val);
            if(slow == fast)break;
        }
        if(fast ==null || fast.next ==null)return null;
        fast = head;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }

        return fast;
    }

}
