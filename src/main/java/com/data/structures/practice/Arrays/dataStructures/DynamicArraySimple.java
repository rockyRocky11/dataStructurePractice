package com.data.structures.practice.Arrays.dataStructures;

public class DynamicArraySimple {
    int size;
    int[] arr;

    public DynamicArraySimple(int capacity) {
        this.arr = new int[capacity];
        size=0;
    }

    public int get(int i) {
        if(i>=arr.length)return -1;
        return arr[i];
    }

    public void set(int i, int n) {
        if(i>=arr.length)return;
        arr[i]=n;
    }

    public void pushback(int n) {
        if(size>=arr.length)resize();
        arr[size++]=n;
    }

    public int popback() {
        if(size==0)return -1;
        int res = arr[size-1];
        arr[size-1]=0;
        size--;
        return res;
    }

    private void resize() {

        int[] temp = arr;
        arr =new int[2*arr.length];
        System.arraycopy(temp, 0, arr, 0, temp.length);

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }
}
