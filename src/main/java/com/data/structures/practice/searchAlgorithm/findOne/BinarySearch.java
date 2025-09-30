package com.data.structures.practice.searchAlgorithm.findOne;

public class BinarySearch {
    public static void main(String[] args) {
        int[] inputArrray= {-22, -15, 1, 7, 20, 35, 55};
        //System.out.println(iterativeBinarySearch(inputArrray, 90));
        System.out.println(recurssiveBinarySearch(inputArrray, -15));
    }

    private static int iterativeBinarySearch(int[] inputArrray, int value){
        int start=0;
        int end=inputArrray.length;

        while(start < end){
            int mid=(start+end)/2;
            if(inputArrray[mid]== value){
                return mid;
            }else if(inputArrray[mid]< value){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return -1;
    }

    private static int recurssiveBinarySearch(int[] inputArrray, int value){

        return recurssiveBinarySearch(inputArrray,0, inputArrray.length, value);
    }

    private static int recurssiveBinarySearch(int[] inputArrray,int start, int end, int value){

        if(start>=end){ //this breaker and the above while(start<end)
            return -1;
        }

        int mid = start+end/2;

        if(inputArrray[mid]==value){
            return mid;
        } else if(inputArrray[mid]<value){
            return recurssiveBinarySearch(inputArrray, mid+1, end, value);
        }
        else{
            return  recurssiveBinarySearch(inputArrray, 0, mid, value);
        }
    }

}
