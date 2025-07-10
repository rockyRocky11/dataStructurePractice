package com.data.structures.practice.LeetCode.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static void main(String[] args) {
        //int[] input = {3,2,3};
        //int[] input = {170,-368,148,672,397,-629,-788,192,170,309,-615,-237};
        //int[] input = {8,8,7,7,7};
        //int[] input = {3,3,4};
        //int[] input = {1,2,3,4};
        int[] input = {1,2,3,1};
        //int[] input = {25, -1, 10, 55, 1, -20};
        System.out.println(containsDuplicate(input));
        System.out.println(containsDuplicateBySorting(input));
        System.out.println(containsDuplicateUsingSet(input));
        System.out.println(containsDuplicateByInsertionSorting(input));
        System.out.println(containsDuplicate1(input));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> countingMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            if(countingMap.containsKey(nums[i])){
                return true;
            }else{
                countingMap.put(nums[i], countingMap.getOrDefault(nums[i], 1)+1);
            }
        }
        return false;
    }

    public static boolean containsDuplicateUsingSet(int[] nums) {
        Set<Integer> countingMap = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(countingMap.contains(nums[i]))return true;
            countingMap.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicateBySorting(int[] nums) {

        Arrays.sort(nums);
        int current = nums[0];
        for(int i=1;i<nums.length;i++){
            if(current == nums[i])return true;
            current=nums[i];
        }
        return false;
    }

    public static boolean containsDuplicateByInsertionSorting(int[] nums) {

       int sortedIndex = 0;
       while(sortedIndex < nums.length){

           int unsortedIndex = sortedIndex+1;
           int unsortedValue = nums[unsortedIndex];
           for(int j=sortedIndex;j>=0;j--){
               if(nums[unsortedIndex] == nums[j]){
                   return true;
               }
               else if(nums[unsortedIndex] < nums[j]){
                   int temp= nums[j];
                   nums[j] = unsortedValue;
                   nums[unsortedIndex]=temp;
               }else{
                   break;
               }
           }
           sortedIndex++;

       }

       System.out.println(Arrays.toString(nums));
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j>0;j--){
                count++;
                if(nums[j]==nums[j-1]){
                    System.out.println(count);
                    return true;
                }else if(nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return false;
        // return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
