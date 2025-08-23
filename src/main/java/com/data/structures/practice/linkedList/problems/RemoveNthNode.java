package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.ListNode;
import com.data.structures.practice.linkedList.fundamentals.ListNodeCode;

import java.util.*;

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
        listNodeCode.addToFront(11);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(1);
        listNodeCode.addToFront(6);
        listNodeCode.addToFront(8);


        listNodeCode.PrintLinkedList();
        ListNode node = removeNthFromMiddleRunnerMethod(listNodeCode.getHead());
        listNodeCode.PrintLinkedList();

    }

    public static ListNode removeNthFromMiddleRunnerMethod(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow.next != null)
            slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEndRunnerMethod(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=1; i<=n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next != null)
            slow.next = slow.next.next;
        return head;
    }

    private static int toRemoveAt = 1;

    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        deleteRecursive(dummyNode, dummyNode.next, n);
        return dummyNode.next;
    }

    public static void deleteRecursive(ListNode prev, ListNode curr,  int n) {
        if(curr == null){
            return;
        }

        deleteRecursive(prev.next, curr.next, n);

        if (toRemoveAt == n){
            prev.next = curr.next;
        }

        toRemoveAt++;
    }

    public static ListNode removeNode(ListNode head, int n) {

        if(head == null){
            return head;
        }

        List<ListNode> refArray = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            refArray.add(curr);
            curr = curr.next;

        }

        int removeIndex = refArray.size()-n;

        if(removeIndex == 0 && refArray.size()>1){
            head = refArray.get(1);
            return head;
        }

        if(removeIndex == 0 && refArray.size() == 1){
            return null;
        }

        if ( removeIndex == 1 && refArray.size() ==2 ) {
            ListNode prev = refArray.get(removeIndex-1);
            prev.next = null;
            return head;

        }

        if ( removeIndex == refArray.size()-1 ) {
            ListNode prev = refArray.get(removeIndex-1);
            prev.next = null;
            return head;

        }

        ListNode prev = refArray.get(removeIndex-1);
        prev.next = refArray.get(removeIndex+1);



        return head;
    }
}
