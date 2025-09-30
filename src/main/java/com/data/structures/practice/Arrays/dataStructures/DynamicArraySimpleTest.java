package com.data.structures.practice.Arrays.dataStructures;

public class DynamicArraySimpleTest {
    public static void main(String[] args) {
        DynamicArraySimple dynamicArraySimple = new DynamicArraySimple(2);
        assert dynamicArraySimple.getCapacity()==2;
        assert dynamicArraySimple.getSize()==0;

        dynamicArraySimple.pushback(5);
        assert dynamicArraySimple.get(0)==5;
        System.out.println("All test cases executed successfully !!");
    }
}
