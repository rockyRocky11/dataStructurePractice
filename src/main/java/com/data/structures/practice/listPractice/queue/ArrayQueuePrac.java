package com.data.structures.practice.listPractice.queue;

import com.data.structures.practice.Employee;

public class ArrayQueuePrac {
    public static void main(String[] args) {
        ArrayQueue arrayQueuePrac = new ArrayQueue(5);

        arrayQueuePrac.add(new Employee(1, "vivek", "dev"));
        arrayQueuePrac.add(new Employee(2, "vivek2", "dev1"));
        arrayQueuePrac.add(new Employee(3, "vivek3", "dev2"));
        arrayQueuePrac.add(new Employee(4, "vivek4", "dev3"));
        arrayQueuePrac.printStack();
    }
}
