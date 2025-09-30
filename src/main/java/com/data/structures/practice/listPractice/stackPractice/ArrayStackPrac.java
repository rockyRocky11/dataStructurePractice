package com.data.structures.practice.listPractice.stackPractice;

import com.data.structures.practice.Employee;

import java.util.EmptyStackException;

public class ArrayStackPrac {

    private Employee[] stack;
    private int top;

    public ArrayStackPrac(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++]=employee;
    }

    public Employee pop(){

        if(top ==0){
            throw new EmptyStackException();
        }
        Employee removeItem = stack[--top];
        stack[top] = null;
        return removeItem;
    }

    public Employee peek(){

        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public boolean isEmpty(){
        return top==0;
    }

    public int size(){
        return top;
    }

    public void printStack(){
        for(int i= top-1;i>=0;i--){
            System.out.println(stack[i]);
        }
    }

}
