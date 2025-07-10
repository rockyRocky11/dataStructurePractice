package com.data.structures.practice.LeetCode.stack;

public class ThreeStackOneArrayPrac {
    public static void main(String[] args) {
        ThreeStackOneArray threeStackOneArray = new ThreeStackOneArray(5);
        threeStackOneArray.add(1, 1);
        threeStackOneArray.add(1, 5);
        threeStackOneArray.add(1, 9);
        threeStackOneArray.add(2, 1);
        threeStackOneArray.add(2, 2);
        threeStackOneArray.add(2, 5);
        threeStackOneArray.add(3, 1);
        threeStackOneArray.add(3, 6);
        threeStackOneArray.add(3, 7);
        threeStackOneArray.add(3, 9);
        threeStackOneArray.add(3, 4);
        threeStackOneArray.printAll();

        threeStackOneArray.remove(3, 5);
        threeStackOneArray.add(3, 3);

        threeStackOneArray.printAll();
    }
}
