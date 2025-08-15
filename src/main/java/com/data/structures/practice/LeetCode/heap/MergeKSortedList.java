package com.data.structures.practice.LeetCode.heap;

import com.data.structures.practice.LeetCode.linkedList.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {

    }

    //Time : O(NlogN)
    //Space: O(N)
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode ln : lists) {
            while (ln != null) {
                pq.offer(ln.val);
                ln = ln.next;
            }
        }

        ListNode ans = null;
        if (pq.peek() == null)
            return ans;
        ans = new ListNode(pq.poll());
        ListNode last = ans;
        while (pq.peek() != null) {
            ListNode node = new ListNode(pq.poll());
            last.next = node;
            last = last.next;

        }
        return ans;
    }
}
