package com.data.structures.practice.slidingwindow;

public class GroupAllOnesMinSwap {

    public static void main(String[] args) {
        int[] nums={1, 0, 1, 0, 1, 0, 0};
        Solution solution = new Solution();
        System.out.println(solution.minSwaps(nums));

    }


}
 class Solution{

    public int minSwaps(int[] nums){

        int totalNoOfOnes = 0;
        for(int i: nums){
            totalNoOfOnes+=i;
        }
        int maxNoOfOnes = -1;
        int n=nums.length;
        int noOfOnesInWindow=0;
        for(int i=0;i<totalNoOfOnes;i++){//to find a max no of ones in given window
            noOfOnesInWindow+=nums[i];
        }
        maxNoOfOnes = noOfOnesInWindow;

        for(int i=totalNoOfOnes;i<n;i++){//move the window to find a new window with max 1's
            noOfOnesInWindow+=nums[i];// add the new one in the window
            noOfOnesInWindow-=nums[i-totalNoOfOnes];//this will remove the  1 thats moving out of the new old window
            maxNoOfOnes = Math.max(maxNoOfOnes, noOfOnesInWindow);
        }
        return totalNoOfOnes-maxNoOfOnes;
    }

}
