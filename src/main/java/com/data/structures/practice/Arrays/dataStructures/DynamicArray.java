package com.data.structures.practice.Arrays.dataStructures;/*
 * Improved DynamicArray implementation.
 *
 * This implementation addresses several shortcomings of the original version:
 * - Uses a generic type parameter <T> instead of hard-coded int values.
 * - Validates indices against the logical size (not just capacity) to prevent
 *   accidental access to unused capacity or negative indexes.
 * - Handles zero or negative initial capacity by defaulting to a minimum
 *   capacity of 1, so that push operations work even when a capacity of 0 is passed.
 * - Implements a shrinking mechanism to reduce memory usage when the array
 *   becomes sparsely populated. When the number of elements falls to one
 *   quarter of the capacity, the underlying storage is halved.
 * - Provides clear method names using camelCase (`pushBack`, `popBack`),
 *   consistent with Java naming conventions.
 *
 * Note: Java does not allow direct instantiation of generic arrays.  Internally
 * this implementation uses an Object array and casts it to T[].  The
 * unchecked cast is suppressed with `@SuppressWarnings("unchecked")`.
 */

public class DynamicArray<T> {
    /**
     * Current number of elements stored in the array.
     */
    private int size;

    /**
     * Underlying storage for the elements.  The capacity of the dynamic array
     * is equal to arr.length.
     */
    private T[] arr;

    /**
     * Constructs a new DynamicArray with the given initial capacity.  If the
     * supplied capacity is less than or equal to zero, a default capacity of
     * one is used.  This avoids repeated resizing when pushBack() is called
     * on an array with zero capacity.
     *
     * @param capacity the initial capacity of the array
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            capacity = 1;
        }
        // Java prohibits direct generic array creation; we cast from Object[]
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param i the index of the element to retrieve
     * @return the element at index i, or null if the index is out of bounds
     */
    public T get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return arr[i];
    }

    /**
     * Replaces the element at the specified index with the provided value.
     *
     * @param i     the index of the element to replace
     * @param value the new value to assign
     * @throws IndexOutOfBoundsException if the index is out of the current size
     */
    public void set(int i, T value) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(
                "Index " + i + " is out of bounds for size " + size);
        }
        arr[i] = value;
    }

    /**
     * Appends the specified value to the end of the dynamic array.  If the
     * underlying array is full, the capacity is doubled before insertion.
     *
     * @param value the value to append
     */
    public void pushBack(T value) {
        if (size >= arr.length) {
            resize();
        }
        arr[size++] = value;
    }

    /**
     * Removes and returns the last element of the array.  If the array
     * becomes sparse after removal (i.e., the number of elements is at most
     * one quarter of the capacity), the underlying storage is shrunk by
     * half to free memory.
     *
     * @return the removed element, or null if the array is empty
     */
    public T popBack() {
        if (size == 0) {
            return null;
        }
        T res = arr[size - 1];
        arr[size - 1] = null; // help GC for reference types
        size--;
        // Shrink when usage falls to 25% or less of capacity
        if (size > 0 && size <= arr.length / 4) {
            shrink();
        }
        return res;
    }

    /**
     * Resizes the internal array to double its current capacity.  If the
     * current capacity is zero, it is increased to one.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = arr.length * 2;
        if (newCapacity == 0) {
            newCapacity = 1;
        }
        T[] newArr = (T[]) new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    /**
     * Shrinks the internal array to half its current capacity.  The new
     * capacity is at least one.  This method is called after a popBack
     * operation when the number of elements falls to 25% or less of the
     * current capacity.
     */
    @SuppressWarnings("unchecked")
    private void shrink() {
        int newCapacity = arr.length / 2;
        if (newCapacity < 1) {
            newCapacity = 1;
        }
        T[] newArr = (T[]) new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    /**
     * Returns the number of elements currently stored in the dynamic array.
     *
     * @return the current size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the current capacity of the underlying array (i.e., the length
     * of the internal storage).  This may be greater than the number of
     * elements actually stored.
     *
     * @return the current capacity
     */
    public int getCapacity() {
        return arr.length;
    }
}
