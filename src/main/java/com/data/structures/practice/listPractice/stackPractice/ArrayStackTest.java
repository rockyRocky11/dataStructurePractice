package com.data.structures.practice.listPractice.stackPractice;

import com.data.structures.practice.Employee;


public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStackPrac arrayStackPrac = new ArrayStackPrac(5);

        arrayStackPrac.push(new Employee(1, "vivek", "dev"));
        arrayStackPrac.push(new Employee(2, "vivek2", "dev1"));
        arrayStackPrac.push(new Employee(3, "vivek3", "dev2"));
        arrayStackPrac.push(new Employee(4, "vivek4", "dev3"));
        arrayStackPrac.printStack();
        System.out.println(arrayStackPrac.isEmpty());
        System.out.println(arrayStackPrac.peek());
        System.out.println(arrayStackPrac.size());
        System.out.println(arrayStackPrac.pop());
        System.out.println(arrayStackPrac.size());
        System.out.println(arrayStackPrac.peek());
    }
}
