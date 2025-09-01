package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;
import com.data.structures.practice.linkedList.fundamentals.singly.ListNodeCode;

public class ReverseLinkedListKGroups {

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
        ListNode current = reverseList(listNodeCode.getHead(), 3);
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /*⚡ Complexity

Time: O(n) → Every node is visited and reversed at most twice (once forward, once backward in the leftover group).

Space: O(1) → Only pointers used.*/

    public static ListNode reverseList(ListNode head, int k) {
        ListNode ans = new ListNode(-1);
        ListNode newNode = ans;
        while (head != null){
            ListNode cur = head;
            ListNode reverse = null;
            int i=0;
            while(i<k && head != null){
                ListNode temp = head;
                head = head.next;
                temp.next = reverse;
                reverse = temp;
                i++;
            }
            if(i==k){
                newNode.next = reverse;
                newNode = cur;
            }else{
                ListNode tail = null;
                while( reverse != null){
                    ListNode temp = reverse;
                    reverse = reverse.next;
                    temp.next = tail;
                    tail = temp;
                }
                newNode.next = tail;

            }
        }
        return ans.next;
    }
}


