package com.data.structures.practice.linkedList.fundamentals.singly;

import com.data.structures.practice.Employee;
import com.data.structures.practice.linkedList.fundamentals.doubly.EmployeeLinkedList;

public class LinkedListPrac {

    public static void main(String[] args) {

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(new Employee(1, "vivek", "dev"));
        list.addToFront(new Employee(2, "vivek2", "dev1"));
        list.addToFront(new Employee(3, "vivek3", "dev2"));
        list.addToFront(new Employee(4, "vivek4", "dev3"));
        list.PrintLinkedList();
       //System.out.println(list.getSize());
        //System.out.println(list.isEmpty());
        //list.removeFromFront();
        //list.PrintLinkedList();
       // System.out.println(list.getSize());
        list.addToTail(new Employee(0, "Last", "guy"));
        list.PrintLinkedList();

    }
}
