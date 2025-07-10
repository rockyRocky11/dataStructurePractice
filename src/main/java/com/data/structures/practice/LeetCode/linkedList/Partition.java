package com.data.structures.practice.LeetCode.linkedList;

public class Partition {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();

        listNodeCode.addToFront(2);
        listNodeCode.addToFront(5);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(3);
        listNodeCode.addToFront(4);
        listNodeCode.addToFront(1);

//        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(2);

        listNodeCode.PrintLinkedList();
        ListNode listNodeCode1 =  partition(listNodeCode.getHead(),3);
        listNodeCode.PrintLinkedList(listNodeCode1);

    }

    public static ListNode partition(ListNode head, int x) {

        ListNode left = new ListNode(0);
        ListNode tempL = left;
        ListNode right = new ListNode(0);
        ListNode tempR = right;
        while(head!=null){
            if(head.val<x){
                tempL.next = head;
                tempL = tempL.next; // this is same as incrementing for linkedlist iteration
            } else{
                tempR.next = head;
                tempR = tempR.next;// this is same as incrementing for linkedlist iteration
            }
            head = head.next;

        }
        tempL.next = right.next;
        tempR.next = null;
        return left.next;


    }
}
