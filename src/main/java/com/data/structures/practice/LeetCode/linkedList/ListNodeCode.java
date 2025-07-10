package com.data.structures.practice.LeetCode.linkedList;

import com.data.structures.practice.Employee;
import com.data.structures.practice.listPractice.linkedListPrac.EmployeeNodeDto;

public class ListNodeCode {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void addToFront (int val){
        ListNode node = new ListNode(val);
        node.next=head;
        head = node;
    }

    public void PrintLinkedList(){
        ListNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void PrintLinkedList(ListNode newHead){
        ListNode current = newHead;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
