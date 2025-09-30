package com.data.structures.practice.searchAlgorithm.binarySearch;

public class SquareRoot {
    public static void main(String[] args) {
System.out.println(mySqrt3(8));
System.out.println(mySqrt(8));
System.out.println(mySqrt1(2147483647));
System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt3(int x) {
        if(x==0 || x==1){
            return x;
        }
        int low=1,high=x/2;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            long val=(long)mid*mid;
            if(val==x){
                return mid;
            }
            else if(val<x){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }

        return  ans;
    }

    public static int mySqrt(int x) {


        long value = 2;
        long prev = 2;
        boolean highest = false;
        while (value<x){
            if(value*value == x){
                return (int)value;
            }
            if(highest && value*value < x){
                return (int)prev;
            }
            if(value*value < x){
                value=value*2;
            }else{
                value--;
                highest = true;
            }


            prev = value;

            ///value++;

        }
        return 1;
    }

    public static int mySqrt1(int x) {


        long value = 2;
        long prev = 2;
        while (value<x){
            if(value*value == x){
                return (int)value;
            }
            if(value*value > x){
                return (int)prev;
            }
            prev = value;

            value++;

        }
        return 1;
    }

    public static int mySqrt2(int x) {


        long value = x/2;
        long prev = x/2;
        boolean lowest = false;
        while (value>0 && value <x){
            if(value*value == x){
                return (int)value;
            }

            if(value*value > x){
                value=value/2;
            }else{
                value++;
                lowest = true;
            }

            if(lowest && value*value > x){
                return (int)prev;
            }

            prev = value;

            //value--;

        }
        return 1;
    }
}

