package com.data.structures.practice.sorting.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

public class MergeKSortedLinkedList {

   /* Time: O(N log k)

    Space: O(log k) for recursion stack.

    K is number of linkedList*/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKRange(lists, 0, lists.length);
    }

    public ListNode mergeKRange(ListNode[] lists, int l, int r) {
        //System.out.println(l + " " + r);
        if (r - l < 2)
            return lists[l];
        int mid = l + (r - l) / 2;
        ListNode le = mergeKRange(lists, l, mid);
        ListNode ri = mergeKRange(lists, mid, r);

        return mergeSorted(le, ri);
    }

    public ListNode mergeSorted(ListNode a, ListNode b) {
        //System.out.println(a.val);
        //System.out.println(b.val);
        ListNode ans = new ListNode(0);
        ListNode last = ans;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                last.next = a;
                last = last.next;
                a = a.next;
            } else {
                last.next = b;
                last = last.next;
                b = b.next;
            }
        }

        last.next = a != null ? a : b;

        return ans.next;

    }
}
