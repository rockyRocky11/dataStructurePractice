package com.data.structures.practice.LeetCode.greedy;

public class CanJump {
    public static void main(String[] args) {
        //int[] nums={3,2,1,0,4};
        //  int[] nums={1,1,1,0};
       // int[] nums = {1, 1, 0, 1};
         int[] nums={2,3,1,1,4};
        // int[] nums={1,1,2,2,0,1,1};

        System.out.println(canJump(nums));

    }
 /*Time & Space Complexity:
    Time: O(n)

    Space: O(1)*/


    public static boolean canJump(int[] nums) {
        int f = nums.length;
        int max = 0;
        for (int i = 0; i < f; i++) {
            if (i > max) {
                return false;
            }
            //At each index i, update the farthest index:
            max = Math.max(max, nums[i] + i);
            if (max >= f - 1) {
                return true;
            }
        }
        return true;
    }
}
