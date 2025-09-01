package com.data.structures.practice.linkedList.fundamentals.circular;

public class CircularLinkedList {

    CircularListNode head;
    CircularListNode tail;

    public void insertAtTail(int val){
        CircularListNode node = new CircularListNode(val);
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;// circle back
        }else{
            tail.next = node;
            tail = node;
            tail.next = head;// maintain circle
        }
    }

    public void insertAtFront(int val){
        CircularListNode node = new CircularListNode(val);
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;// circle back
        }else{
            node.next = head;
            head =node;
            tail.next = head;
        }
    }

    public void printCircular(){
        CircularListNode node = head;
        do{
            System.out.print(node.val+" ");
            node = node.next;
        }while(node != head);
        System.out.println();
    }

    public void deleteByValue(int val){

        if(head == null)return;

        CircularListNode curr = head, prev = tail;
        do{
            if(curr.val == val){
                if(curr == head){
                    head = head.next;
                    tail.next = head;
                }else if(curr == tail){
                    tail = prev;
                    tail.next=head;
                }else{
                    prev.next = curr.next;
                }
                return;// This circular, so we need to break
            }
            prev = curr;
            curr = curr.next;
        }while(curr != head);

    }
}
