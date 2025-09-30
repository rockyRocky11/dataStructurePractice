package com.data.structures.practice.Heap;

public class MedianFinder {

    int[] largeArray;
    int size;
    public MedianFinder() {
        largeArray = new int[100000];
    }

    public void addNum(int num) {
        if(size ==0){
            largeArray[size++]=num;
            return;
        }
        int pos = findInsertPosition(num);
        adjustArray(pos);
        largeArray[pos]=num;
        size++;

    }

    public double findMedian() {

        if(size%2==0){
            int mid=size/2;
            return (double) (largeArray[mid] + largeArray[mid - 1]) /2;
        }
        return (double) largeArray[size/2];
    }


    private int findInsertPosition(int num){
        int i=0;
        int j=size;
        while(i<j){
            int mid = i+(j-i)/2;//this method will handle large values
            if(num<largeArray[mid]){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return i;
    }

    private void adjustArray(int pos){

        for(int i=size;i>pos;i--){
            largeArray[i]=largeArray[i-1];
        }

    }

    public static void main(String[] args) {

        /*MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());*////2

        /*MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());*///0.0

         MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
    }
}
