package com.data.structures.practice.listPractice.queue;

import com.data.structures.practice.Employee;

import java.util.EmptyStackException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;//Always front
    private int back; //always back-1

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        //unwrap teh queue when you resize for circular queue optimization
        if (size() == queue.length - 1) {
            int numberItems = size();
            Employee[] newQueue = new Employee[2 * queue.length];
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);
            queue = newQueue;
            back = numberItems;
            front = 0;
        }
        //Optimization
        //if back reach capacity then point the back to 0
        //0-->back 2
        //1-->back 1
        //2-->current back
        //3-->front 0
        //4-->front 1
        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        Employee removeItem = queue[front];
        queue[front] = null;
        front++;

        //Optimization
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        //This is for optimization - if front reaches end after a remove then you have to wrap it
        else if (front == queue.length) {
            front = 0;
        }
        return removeItem;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public void printStack() {
        if (front < back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}
