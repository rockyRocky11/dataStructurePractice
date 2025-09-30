package com.data.structures.practice.linkedList.fundamentals.doubly;

import com.data.structures.practice.Employee;

public class EmployeeDoublyLinkedList {
    private EmployeeDoublyNodeDto head;
    private EmployeeDoublyNodeDto tail;
    private int size;

    //O(1)
    public void addToFront (Employee employee){
        EmployeeDoublyNodeDto node = new EmployeeDoublyNodeDto(employee);
        node.setNext(head);
        if(head == null){
            tail = node;
        }
        else{
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public void addToEnd (Employee employee){
        EmployeeDoublyNodeDto node = new EmployeeDoublyNodeDto(employee);
        if(tail == null){
            head = node;
        }
        else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public EmployeeDoublyNodeDto removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeDoublyNodeDto removeNode = head;
        if(size == 1){
            head = null;
            tail = null;
            return removeNode;
        }
        EmployeeDoublyNodeDto newHead = head.getNext();
        newHead.setPrevious(null);
        head = newHead;
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeDoublyNodeDto removeFromEnd(){
        if(isEmpty()){
            return null;
        }
        EmployeeDoublyNodeDto removeNode = tail;
        if(size == 1){
            head = null;
            tail = null;
            return removeNode;
        }
        EmployeeDoublyNodeDto newHead = tail.getPrevious();
        newHead.setNext(null);
        tail = newHead;
        size--;
        removeNode.setPrevious(null);
        return removeNode;
    }

    public void removeByValue(int val){
        if(head == null)return;
        EmployeeDoublyNodeDto cur = head;
        while(cur != null && cur.getEmployee().getId() != val){
            cur = cur.next;
        }
        if(cur == null)return;

        if(cur.getPrevious() != null){//This is to update if any node prev to the deleting node
            cur.getPrevious().next= cur.next;
        }else{
            head = cur.next;//deleting head
        }

        if(cur.next != null){// This is to update any node next to the deleting node
            cur.next.previous= cur.previous;
        }else{
            tail = cur.previous;//deleting tail
        }

    }

    // Search for a value
    public boolean search(int val) {
        EmployeeDoublyNodeDto curr = head;
        while (curr != null) {
            if (curr.getEmployee().getId() == val) return true;
            curr = curr.next;
        }
        return false;
    }

    public void PrintLinkedList(){
        EmployeeDoublyNodeDto current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.toString());
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void PrintLinkedListBack(){
        EmployeeDoublyNodeDto current = tail;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.toString());
            System.out.print(" <=> ");
            current = current.previous;
        }
        System.out.println("null");
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
