package com.data.structures.practice.sorting.problems;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
    //int[] input = {3,2,3};
    //int[] input = {8,8,7,7,7};
    int[] input = {3,3,4};
    System.out.println(majorityElement(input));
    System.out.println(BoyerMooreVotingAlgorithm(input));
    System.out.println(majorityElementWithSorting(input));
    }

    public static int majorityElement(int[] nums) {
        int maxtimes=1;
        int maxValues=nums[0];
        HashMap<Integer, Integer> countingMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(countingMap.containsKey(nums[i])){
                countingMap.put(nums[i], countingMap.get(nums[i])+1);
                if(countingMap.get(nums[i])>maxtimes){
                    maxtimes=countingMap.get(nums[i]);
                    maxValues=nums[i];
                    if(maxtimes>(nums.length/2)) {
                        return maxValues;
                    }
                }
            }else{
                countingMap.put(nums[i], 1);
            }
        }
        return maxValues;
    }

    public static int BoyerMooreVotingAlgorithm(int[] nums) {
        int candidate = nums[0];
        int counter = 1;

        for(int i=1;i< nums.length;i++){
            if(candidate != nums[i]){
                counter--;
            }
            else{
                counter++;
            }
            if(counter ==0){
                counter=1;
                candidate=nums[i];
            }
        }
        return candidate;
    }

    public static int majorityElementWithSorting(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}
