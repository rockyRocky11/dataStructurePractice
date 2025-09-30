package com.data.structures.practice.stack;

import java.util.*;

public class DinnerPlatesStackTreeSet {
    List<Stack<Integer>>  values = new ArrayList<>();
    TreeSet<Integer> minQueue = new TreeSet<>();


    public static void main(String[] args) {

        DinnerPlatesStackTreeSet dinnerPlatesHard = new DinnerPlatesStackTreeSet(2);
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
//
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        dinnerPlatesHard.printAll();
//        dinnerPlatesHard.printAll();

//        DinnerPlatesStack dinnerPlatesHard = new DinnerPlatesStack(2);
//        dinnerPlatesHard.push(1);
//        dinnerPlatesHard.push(2);
//        dinnerPlatesHard.push(3);
//        dinnerPlatesHard.push(4);
//        dinnerPlatesHard.push(5);
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(0));
//        //dinnerPlatesHard.printAll();
//        dinnerPlatesHard.push(20);
//        dinnerPlatesHard.push(21);
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(0));
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(2));
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();

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

//        DinnerPlatesStack dinnerPlatesHard = new DinnerPlatesStack(1);
//        dinnerPlatesHard.push(1);
//        dinnerPlatesHard.push(2);
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.popAtStack(1));
//        dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
//        dinnerPlatesHard.push(1);
//        dinnerPlatesHard.push(2);
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
//        System.out.println(dinnerPlatesHard.pop());
//        //dinnerPlatesHard.printAll();
    }

    int capacity;

    public DinnerPlatesStackTreeSet(int capacity) {

        this.capacity = capacity;
    }

    public boolean isStackEmpty(int index) {
        return values.get(index).isEmpty();

    }

    public boolean isStackFull(int index) {
        return values.get(index).size() == capacity;

    }

    public void push(int value) {


        if(values.size() ==0){
            Stack<Integer> stack = new Stack<>();
            stack.push(value);
            values.add(stack);
            minQueue.add(0);
            return;
        }
        int stackNo = minQueue.first();

        if (isStackFull(stackNo)) {
            //System.out.println("Stack capacity reached :" + stackNo);
            minQueue.remove(stackNo);
            if (minQueue.isEmpty()) {
                stackNo++;
                minQueue.add(stackNo);
            } else {
                stackNo = minQueue.first();
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(value);
            if(stackNo>= values.size()){
                values.add(stack);
            }else{
                values.get(stackNo).push(value);
            }
            //System.out.println("Stack Available to insert :" + stackNo);

        }else {
            //System.out.println("Stack Available to insert :" + stackNo);
            values.get(stackNo).push(value);
        }

        if(minQueue.size()>1 && isStackFull(stackNo)){
            minQueue.remove(stackNo);
        }
    }

    public int pop() {

        int lastStackNo = values.size()-1;
        if(lastStackNo<0){
            return -1;
        }
        if(values.get(lastStackNo).isEmpty()) {
            while (values.get(lastStackNo).isEmpty()) {
                values.remove(lastStackNo);
                //System.out.println(minQueue.remove(lastStackNo));
                lastStackNo = values.size() - 1;
            }
        }

        //System.out.println("stackNo for POP"+lastStackNo);
        int valueRemoved = values.get(lastStackNo).pop();

        if(!minQueue.contains(lastStackNo)){
            minQueue.add(lastStackNo);

        }

        if(values.get(lastStackNo).isEmpty()){
            values.remove(lastStackNo);
            System.out.println(minQueue.remove(lastStackNo));
        }
        return valueRemoved;
    }

    public int popAtStack(int index) {
        if(index >=values.size()){
            return -1;
        }

        //System.out.println("popAtStack :" + index);
        if(values.get(index).isEmpty()){
            return -1;
        }

        int valueRemoved = values.get(index).pop();
        if(!minQueue.contains(index)) {
            minQueue.add(index);
        }


        return valueRemoved;
    }

    public void printAll() {
        for (int i = 0; i < values.size(); i++) {
            Object[] temp = values.get(i).toArray();
            System.out.println("Stack No: "+i);
            for(Object nums: temp){
                System.out.print(nums + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
