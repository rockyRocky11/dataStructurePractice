package com.data.structures.practice.listPractice.linkedListPrac;

import com.data.structures.practice.Employee;

public class EmployeeDoublyLinkedList {
    private EmployeeDoublyNodeDto head;
    private EmployeeDoublyNodeDto tail;
    private int size;
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

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
