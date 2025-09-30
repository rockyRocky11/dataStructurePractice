package com.data.structures.practice.stack;

import java.util.PriorityQueue;

public class DinnerPlatesHard {
    private int[] values = new int[200000000];
    private int[] pointer = new int[200000000];

    int top = 0;
    int lastStackNo = 0;

    PriorityQueue<Integer> minQueue = new PriorityQueue<>();


    public static void main(String[] args) {

        DinnerPlatesHard dinnerPlatesHard = new DinnerPlatesHard(2);
        dinnerPlatesHard.push(471);
        dinnerPlatesHard.push(177);
        dinnerPlatesHard.push(1);
        dinnerPlatesHard.push(29);
        dinnerPlatesHard.push(333);
        dinnerPlatesHard.push(154);
        dinnerPlatesHard.push(130);
        dinnerPlatesHard.push(333);
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.popAtStack(1));
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.popAtStack(0));
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.popAtStack(2));
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.popAtStack(0));
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(165);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(383);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(267);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(367);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(53);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(373);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(388);
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.push(249);
        dinnerPlatesHard.printAll();

        System.out.println(dinnerPlatesHard.pop());
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.pop());
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.pop());
        dinnerPlatesHard.printAll();
        System.out.println(dinnerPlatesHard.pop());
        dinnerPlatesHard.printAll();
        dinnerPlatesHard.printAll();

//        DinnerPlatesHard dinnerPlatesHard = new DinnerPlatesHard(2);
//        dinnerPlatesHard.push(1);
//        dinnerPlatesHard.push(2);
//        dinnerPlatesHard.push(3);
//        dinnerPlatesHard.push(4);
//        dinnerPlatesHard.push(5);
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(1));
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(1));
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(0));
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();

//        DinnerPlatesHard dinnerPlatesHard = new DinnerPlatesHard(1);
//        dinnerPlatesHard.push(1);
//        dinnerPlatesHard.push(2);
//        dinnerPlatesHard.push(3);
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(1));
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
    }

    int capacity;

    public DinnerPlatesHard(int capacity) {
        minQueue.add(0);
        this.capacity = capacity;
    }

    public boolean isStackEmpty(int index) {
        return pointer[index] == 0;

    }

    public boolean isStackFull(int index) {
        return pointer[index] == capacity;

    }

    public void push(int value) {

        int stackNo = minQueue.peek();

        if (isStackFull(stackNo)) {
            System.out.println("Stack capacity reached :" + stackNo);
            minQueue.remove(stackNo);
            if (minQueue.isEmpty()) {
                stackNo++;
                minQueue.add(stackNo);
            } else {
                stackNo = minQueue.peek();
            }

        }
        System.out.println("Stack Available to insert :" + stackNo);
        int indexInCurStack = pointer[stackNo];
        int stackPosInArray = stackNo * capacity;
        values[indexInCurStack + stackPosInArray] = value;
        pointer[stackNo]++;
        if (stackNo > lastStackNo) {
            lastStackNo = stackNo;
        }

        top++;
    }

    public int pop() {
        if(lastStackNo<0){
            return -1;
        }
        System.out.println("stackNo for POP"+lastStackNo);
        int indexInCurStack = pointer[lastStackNo];
        int stackPosInArray = lastStackNo * capacity;
        int indexInValues = indexInCurStack + stackPosInArray - 1;
        if(indexInValues<0){
            return -1;
        }
        int valueRemoved = values[indexInValues];
        values[indexInValues] = 0;
        minQueue.add(lastStackNo);
        pointer[lastStackNo]--;
        if(pointer[lastStackNo] ==0){
            while(lastStackNo>=0 && pointer[lastStackNo]==0){
                lastStackNo--;
            }
        }
        top--;
        return valueRemoved;
    }

    public int popAtStack(int index) {

        System.out.println("popAtStack :" + index);

        int indexToRemove = pointer[index];
        if(indexToRemove<=0){
            return -1;
        }
        int indexInValues = indexToRemove + (index * capacity) - 1;
        int valueRemoved = values[indexInValues];
        values[indexInValues] = 0;
        if(!minQueue.contains(index)) {
            minQueue.add(index);
        }
        pointer[index]--;
        return valueRemoved;
    }

    public void printAll() {
        for (int i = 0; i < top; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }


}
