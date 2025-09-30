package com.data.structures.practice.dynamicProgramming.linear;

public class CircularKadane {

    //EditDistanceBruteForce
    // O(n^2)
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < n-1; j++) {
            int maxSubArray = nums[j];
            int i = j+1;
            // System.out.println("J " + j);
            while (i!=j ) {// exit the loop after reaching the start point again
                //System.out.println("i " + i);
                //System.out.println("sub " + maxSubArray);
                //System.out.println("res " + res);
                int curr = nums[i];
                if (curr + maxSubArray > curr) {
                    maxSubArray = curr + maxSubArray;
                } else {
                    maxSubArray = curr;
                }
                res = Math.max(res, maxSubArray);
                i = (i + 1) % n;
            }
        }
        return res;
    }

    //Find Min Sub Array and Max Sub Array
    //Max of Max Sub Array, Total sum -(min sub)
    public int maxSubarraySumCircularOptimize(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int maxx = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int sum = nums[0];
        int maxSubArray = nums[0];
        int minSubArray = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            //Find Max Sub Array
            if (nums[i] + maxSubArray > nums[i]) {
                maxSubArray = nums[i] + maxSubArray;
            } else {
                maxSubArray = nums[i];
            }
            maxx = Math.max(maxx, maxSubArray);

            //Find Min Sub Array
            if (nums[i] + minSubArray > nums[i]) {
                minSubArray = nums[i];
            } else {
                minSubArray = nums[i] + minSubArray;
            }
            minn = Math.min(minn, minSubArray);
        }
        if (sum == minn)
            return maxx;// if all values are negative then simply return maxx
        return Math.max(maxx, sum - minn);// max will return if the maxSum is in linear but if the max is in circular then find minSub and remove from total sum, this gives maxSub in Circular.
    }
}
