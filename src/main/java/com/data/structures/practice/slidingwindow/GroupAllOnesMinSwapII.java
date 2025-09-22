package com.data.structures.practice.slidingwindow;

public class GroupAllOnesMinSwapII {

    public static void main(String[] args) {
        int[] nums={1, 0, 1, 0, 1, 0, 0};
        SolutionII solution = new SolutionII();
        System.out.println(solution.minSwaps(nums));

    }


}
 class SolutionII{

    public int minSwaps(int[] nums){

        int n=nums.length;
        int totalNoOfOnes = 0;
        for(int i: nums){
            totalNoOfOnes+=i;
        }
        if(n==1 || totalNoOfOnes==0 || totalNoOfOnes==n)return 0;
        int maxNoOfOnes = -1;
        int noOfOnesInWindow=0;
        for(int i=0;i<totalNoOfOnes;i++){//to find a max no of ones in given window
            noOfOnesInWindow+=nums[i];
        }
        maxNoOfOnes = noOfOnesInWindow;
        int i=totalNoOfOnes;
        while(i!= (totalNoOfOnes-1)){//move the window to find a new window with max 1's
            noOfOnesInWindow+=nums[i];// add the new one in the window
            //System.out.println(i+" "+nums[i]);
            noOfOnesInWindow-=nums[(i-totalNoOfOnes+n)%n];//this will remove the  1 thats moving out of the new old window
            //i-totalNoOfOnes+n)%n --> this is take care of negative index
            maxNoOfOnes = Math.max(maxNoOfOnes, noOfOnesInWindow);
            i=(i+1)%n;// this incremental logic is circle back
        }
        return totalNoOfOnes-maxNoOfOnes;
    }

}
