package com.data.structures.practice.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackingCubiods {

    public static void main(String[] args) {
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        //int[][] cuboids = {{38, 25, 45}, {76, 35, 3}};
        System.out.println(maxHeight(cuboids));
    }

    public static int maxHeight(int[][] cuboids) {

        int n = cuboids.length;

        for (int[] cuboid : cuboids)
            Arrays.sort(cuboid);

        Arrays.sort(cuboids, (a, b) -> {
            for (int i = 2; i >= 0; i--)
                if (a[i] != b[i]) return b[i] - a[i];
            return 0;
        });


        Integer[][] dp = new Integer[n][n + 1];

        return dfs(0, -1, cuboids, dp);
    }

    private static int dfs(int curr, int prevIndex, int[][] cuboids, Integer[][] dp) {
        if (curr == cuboids.length) return 0;

        if (dp[curr][prevIndex + 1] != null)
            return dp[curr][prevIndex + 1];

        int max = dfs(curr + 1, prevIndex, cuboids, dp);

        if (prevIndex == -1 || canStack(cuboids[curr], cuboids[prevIndex])) {
            int take = cuboids[curr][2] + dfs(curr + 1, curr, cuboids, dp);
            max = Math.max(max, take);
        }

        dp[curr][prevIndex + 1] = max;
        return max;
    }

    private static boolean canStack(int[] top, int[] bottom) {
        return top[0] <= bottom[0] &&
                top[1] <= bottom[1] &&
                top[2] <= bottom[2];
    }
}
