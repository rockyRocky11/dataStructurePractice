package com.data.structures.practice.LeetCode.slidingwindow;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
       // int[] height = {8,10,14,0,13,10,9,9,11,11};
        //int[] height = {1,2,3,1000,9};
        //int[] height = {1,2,4,3};
        //int[] height = {1,1};

        System.out.println(maxArea(height));

    }

   /* ⏱️ Time and Space Complexity:
    Time: O(n)

    Space: O(1)*/
    public static int maxArea(int[] height) {

        int l=0;
        int r=height.length-1;
        int n = height.length;
        int resArea=0;
        while(l<n && r>=0){
            int area1=0;
            int maxHeight = Math.min(height[l], height[r]);
            area1 = maxHeight*(r-l);

            resArea = Math.max(resArea, area1);

            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }

        }
        //int maxHeight = Math.min(height[l], height[r-1]);
       // return maxHeight*(r-l-1);
        return resArea;

    }
}
