package com.data.structures.practice.LeetCode.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};

        System.out.println(searchPosition(nums, 3));
        System.out.println(binarySearchPosition(nums, 3));
    }



    private static int searchPosition(int[] nums, int target) {
        int k = 0;
        for ( k = 0; k < nums.length; k++) {

            if(nums[k]== target){
                return k;
            }
            else if(nums[k]> target && k==0){
                return k;
            }
            else if(k+1==nums.length){
                return k+1;
            }
            else if(nums[k]<target && nums[k+1]>target){
                return k+1;

            }

        }
        return k;

    }

    private static int binarySearchPosition(int[] nums, int target) {
        int startPointer = 0;
        int endPointer = nums.length;
        while(startPointer< endPointer){
            int midPointer = (startPointer+endPointer)/2;
            if(nums[midPointer]==target){
                return midPointer;
            }
            else if(nums[midPointer]<target){
                startPointer=midPointer+1;
            }
            else if(nums[midPointer]>target){
                endPointer=midPointer;
            }
        }
        return startPointer;
    }
}
