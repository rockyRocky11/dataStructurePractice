package com.data.structures.practice.slidingwindow;

import java.util.*;
public class FourSUm {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    /*Time: O(n³), where n is the length of the input array

    Space: O(1) (excluding output list)*/

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int a=0;
        while(a<n-3){
            if(a>0 && nums[a] == nums[a-1]){
                a++;
                continue;
            }
            long taSum = target - nums[a];
            int b=a+1;
            while(b<n-2){
                if(b>a+1 && nums[b] == nums[b-1]){
                    b++;
                    continue;
                }
                long tbSum = taSum - nums[b];
                int c=b+1;
                int d = n-1;
                while(c<d){
                    long cdSum = nums[c]+nums[d];
                    if(cdSum == tbSum){
                        resList.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        while(c<d && nums[c]==nums[c-1])c++;
                        while(c<d && nums[d]==nums[d+1])d--;
                    }else if(cdSum>tbSum){
                        d--;
                    }else{
                        c++;
                    }
                }
                b++;
            }
            a++;
        }
        return resList;

    }
}
