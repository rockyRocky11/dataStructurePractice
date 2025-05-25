package com.data.structures.practice.Heap;

public class Heap {
    private int[] heap;
    private int size;// This is next available position

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        int leftIndex = 2 * index + 1;
        if (leftIndex >= size) {
            return -1;
        }
        return leftIndex;
    }

    public int rightChild(int index) {
        int rightIndex = 2 * index + 2;
        if (rightIndex >= size) {
            return -1;
        }
        return rightIndex;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;

    }

    public int peek(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        return heap[0];
    }

    public int delete(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index]=heap[size-1];
        if(index == 0 || heap[index]< heap[parent]){
            fixHeaBelow(index, size-1);
        }
        else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    public void sort(){
        int lastHeapIndex = size-1;
        for(int i=0;i<lastHeapIndex;i++){
            int temp = heap[0];
             heap[0] = heap[lastHeapIndex-i];
             heap[lastHeapIndex-i]=temp;
             fixHeaBelow(0, lastHeapIndex-i-1);
        }

    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();

    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getChild(int index, boolean left){
        if (left){
            return 2*index+1;
        }
        return 2*index+2;
    }

    public void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeaBelow(int index, int lastHeapIndex){
        int childToSwap;
        while (index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex){
                if(rightChild> lastHeapIndex){
                    childToSwap = leftChild;
                }
                else{
                    childToSwap = heap[leftChild] > heap[rightChild] ?leftChild:rightChild;
                }
                if (heap[index] < heap[childToSwap]){
                    int temp= heap[childToSwap];
                    heap[childToSwap]= heap[index];
                    heap[index]=temp;
                }
                else{
                    break;
                }
                index=childToSwap;
            }
            else{
                break;
            }

        }
    }

}
