package com.data.structures.practice.Arrays.dataStructures;

/*
 * Simple test class for the DynamicArray class.  This test suite exercises
 * the basic operations of the DynamicArray, including pushing and popping
 * elements, setting and getting values, and verifying that the array
 * grows and shrinks as expected.  Assertions are used for verification;
 * run with the `-ea` flag to enable them (e.g. `java -ea DynamicArrayTest`).
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        // Test construction with zero capacity (should default to capacity = 1)
        DynamicArray<Integer> arr = new DynamicArray<>(0);
        assert arr.getSize() == 0 : "Size should be 0 on initialization";
        assert arr.getCapacity() == 1 : "Capacity should default to 1 when initialized with 0";

        // Test pushBack and automatic resizing
        arr.pushBack(10);
        arr.pushBack(20);
        arr.pushBack(30);
        assert arr.getSize() == 3 : "Size should be 3 after three pushBack operations";
        assert arr.getCapacity() >= 3 : "Capacity should be at least 3 after pushBack";
        assert arr.get(0) == 10 : "First element should be 10";
        assert arr.get(1) == 20 : "Second element should be 20";
        assert arr.get(2) == 30 : "Third element should be 30";

        // Test set and get within bounds
        arr.set(1, 200);
        assert arr.get(1) == 200 : "set() should update the element at index 1";

        // Test popping elements and shrink
        Integer last = arr.popBack();
        assert last == 30 : "popBack() should return the last element (30)";
        assert arr.getSize() == 2 : "Size should decrease after popBack";

        last = arr.popBack();
        assert last == 200 : "popBack() should return the updated element (200)";
        assert arr.getSize() == 1 : "Size should be 1 after second popBack";

        last = arr.popBack();
        assert last == 10 : "popBack() should return the remaining element (10)";
        assert arr.getSize() == 0 : "Size should be 0 after popping all elements";

        // Test popping from empty array
        last = arr.popBack();
        assert last == null : "popBack() should return null when empty";

        // Test get and set out of bounds
        assert arr.get(0) == null : "get() should return null for invalid index";
        boolean threw = false;
        try {
            arr.set(0, 5);
        } catch (IndexOutOfBoundsException e) {
            threw = true;
        }
        assert threw : "set() should throw IndexOutOfBoundsException for invalid index";

        System.out.println("All DynamicArray tests passed.");
    }
}
