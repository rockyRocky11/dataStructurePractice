package com.data.structures.practice.LeetCode.dynamicProgramming;

import java.util.Arrays;

public class StackingCubiods1 {

    public static void main(String[] args) {
        //int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        //int[][] cuboids = {{38, 25, 45}, {76, 35, 3}};
        int[][] cuboids = {{36,46,41},{15,100,100},{75,91,59},{13,82,64}};
        System.out.println(maxHeight(cuboids));
    }

    public static int maxHeight(int[][] cuboids) {

        int n = cuboids.length;
        int[] dp = new int[n];

        //as per given qeustion we can rearrange then dimensions of a particular cuboid
        //Step 1:sort dimensions of each cuboid so that we can rotate them freely
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid); // sort dimensions of each cuboid
        }
        //since we have to put cuboid stack in a manner that below is bigger in every side of cuboid above it
        //Step 2:sort cuboids based on dimensions for LIS

        /*✅ Summary
        b[0] - a[0] → descending (largest first).

        a[0] - b[0] → ascending (smallest first).

        Use Integer.compare(a, b) for clarity and to avoid overflow.*/

        Arrays.sort(cuboids, (a,b)->{
            if (a[0] != b[0]) return b[0] - a[0];//width
            if (a[1] != b[1]) return b[1] - a[1];//length
            return b[2]-a[2];//height
        });
        int max=0;
        for(int i=0;i<n;i++){
            dp[i]=cuboids[i][2];
            for(int j=0;j<i;j++){
                if(canPlace(cuboids[i], cuboids[j])){
                    //I is getting added on topof J
                    //If max is I, we will pick that
                    dp[i] = Math.max(dp[i], dp[j]+cuboids[i][2]);
                }

            }
            max = Math.max(max, dp[i]);
        }


        return max;
    }

    public static boolean canPlace(int[] prev, int[] cur) {
        return prev[0] <= cur[0]
                && prev[1] <= cur[1]
                && prev[2] <= cur[2];
    }
}
