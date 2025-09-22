package com.data.structures.practice.sorting.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

public class MergeSortLinkedList {

  /*  ✅ Time Complexity: O(n log n)

✅ Space Complexity: O(1) (only recursion stack)

            ✅ Uses original nodes (no new allocations).*/
    public ListNode sortList(ListNode head) {
        return rec(head);
    }

    public ListNode rec(ListNode head){
        if(head == null || head.next == null)return head;
        //head is the start, slow is the mid, fast is the end and prev is used to split by setting null
        ListNode slow=head, fast=head, prev=null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next=null;// Here we disconnecting the first half by setting to null

        ListNode left = rec(head);
        ListNode right = rec(slow);
        return merge(left, right);
    }

    public ListNode merge(ListNode src, ListNode dest){
        //  System.out.println("merge :"+src.val);
        // if(dest == null)return src;

        ListNode dummy = new ListNode(-1);
        ListNode temp= dummy;

        while(dest != null && src !=null){
            // System.out.println("cur :"+dest.val);
            if(src.val<=dest.val){
                temp.next = src;
                temp = temp.next;
                src = src.next;
                //break;
            }else{
                temp.next = dest;
                temp = temp.next;
                dest = dest.next;
            }

        }
        temp.next = src != null? src: dest;
        return dummy.next;
    }
}
