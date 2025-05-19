package com.data.structures.practice.listPractice.linkedListPrac;

import com.data.structures.practice.Employee;

public class DoublyLinkedListPrac {

    public static void main(String[] args) {

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(new Employee(1, "vivek", "dev"));
        list.addToFront(new Employee(2, "vivek2", "dev1"));
        list.addToFront(new Employee(3, "vivek3", "dev2"));
        list.addToFront(new Employee(4, "vivek4", "dev3"));
        list.PrintLinkedList();
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
        list.addToEnd(new Employee(8, "vivek9", "dev9"));
        list.PrintLinkedList();
        System.out.println(list.getSize());
        list.removeFromFront();
        list.PrintLinkedList();
        System.out.println(list.getSize());
        list.removeFromEnd();
        list.PrintLinkedList();
        System.out.println(list.getSize());
    }
}
