package com.data.structures.practice.LeetCode.stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }

    StackNode top;

    public MinStack() {

    }

    public void push(long val) {

        StackNode newNode = new StackNode();
        newNode.val = val;

        if (top == null) {


            newNode.min = val;

        }else{
            newNode.next = top;
            if (val < top.min) {
                newNode.min = val;
            } else {
                newNode.min = top.min;
            }
        }



        top = newNode;


    }

    public void pop() {

        StackNode newTop = top.next;
        top=newTop;

    }

    public long top() {

        return top.val;

    }

    public long getMin() {
        return top.min;
    }
}
