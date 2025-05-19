package com.data.structures.practice.listPractice.linkedListPrac;

import com.data.structures.practice.Employee;

public class EmployeeLinkedList {
    private EmployeeNodeDto head;
    private int size;
    public void addToFront (Employee employee){
        EmployeeNodeDto node = new EmployeeNodeDto(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNodeDto removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNodeDto removeNode = head;
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public void PrintLinkedList(){
        EmployeeNodeDto current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.toString());
            System.out.print(" -> ");
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
