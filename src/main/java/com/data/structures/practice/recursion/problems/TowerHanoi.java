package com.data.structures.practice.recursion.problems;

import java.util.Stack;

public class TowerHanoi {
    public static void main(String[] args) {
        Stack<Integer> tower1 = new Stack<>();
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();


        //tower1.push(4);
        tower1.push(3);
        tower1.push(2);
        tower1.push(1);

        printTower(tower1,"Tower 1");
        printTower(tower2,"Tower 2");
        printTower(tower3,"Tower 3");
        System.out.println("-----------------------------");
        towerOfHanoi(tower1.size(), tower1, "tower1", tower3, "tower3", tower2,"tower2");


        System.out.println(towerOfHanoi(3, 1, 3, 2));
    }

    public static void towerOfHanoi(int n, Stack<Integer> from, String fromName, Stack<Integer> to, String toName, Stack<Integer> helper, String helperName) {


        if(n==1 ){
            if(!from.isEmpty()){
                System.out.println("-----------------------------");
                to.push(from.pop());
                printTower(from,fromName);
                printTower(helper,helperName);
                printTower(to,toName);
                System.out.println("-----------------------------");

            }
            return;
        }

        towerOfHanoi(n-1, from, fromName, helper, helperName, to, toName);
        if(!from.isEmpty()){
            to.push(from.pop());
            System.out.println("-----------------------------");
            printTower(from,fromName);
            printTower(helper,helperName);
            printTower(to,toName);
            System.out.println("-----------------------------");

        }
        towerOfHanoi(n-1, helper, helperName, to, toName, from, fromName);


    }

    public static void printTower(Stack<Integer> tower, String towerName){
        Object[] tower1Array= tower.toArray();
        System.out.println(towerName);

        for(Object num: tower1Array){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static int towerOfHanoi(int n, int from, int to, int aux) {
        // Your code here
        if(n<=1){
            return n;
        }
        int count = 1+towerOfHanoi((n-1), from, aux, to);

        return count +=towerOfHanoi((n-1), aux, to, from);

    }
}
