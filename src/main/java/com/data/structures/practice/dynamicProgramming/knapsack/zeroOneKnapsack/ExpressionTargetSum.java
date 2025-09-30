package com.data.structures.practice.dynamicProgramming.knapsack.zeroOneKnapsack;

import java.util.HashMap;
import java.util.Map;

public class ExpressionTargetSum {

    static int res = 0;
    public static void main(String[] args) {
        res = 0;
        int[] nums = {1000};
       // int[] nums = {1};
        //int[] nums = {5,6,7,8};
        //int[] nums = {6,2,1,2,4,5};
        System.out.println(findTargetSumWays(nums,3));
        System.out.println(findTargetSumWaysRecMemo(nums,3));
        System.out.println(findTargetSumWaysRecBottomUp(nums,1000));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        res = 0;
        maxAlternatingSumRec(nums, true, 0, target);
        return res;
    }

    //Time N^2
    public static void maxAlternatingSumRec(int[] nums, boolean add, int i, int sum) {

        if (i >= nums.length) {
            if(sum ==0){
                res++;
            }

            return;
        }
        maxAlternatingSumRec(nums, !add, i + 1,sum - nums[i]);
        maxAlternatingSumRec(nums, add, i + 1, sum + nums[i]);
    }
    public static int findTargetSumWaysRecMemo(int[] nums, int target) {
        res = 0;
        Map<String, Integer> dp = new HashMap<>();
        int res =maxAlternatingSumRecMemo(nums, 0, target, dp);
        return res;
    }

    /*⏱ Time & Space Complexity
    Time: O(n * sum), where sum is the range of possible target values

    Space: O(n * sum) for memo map and call stack

    Works well even for larger inputs (up to 1000 range), since you're avoiding duplicate work.*/
    public static int maxAlternatingSumRecMemo(int[] nums, int i, int sum, Map<String, Integer> dp) {

        if (i >= nums.length) {
            if(sum ==0){
                return 1;
            }
            return 0;
        }
        if(dp.containsKey(i+","+sum)){
            return dp.get(i+","+sum);
        }


        int addition = maxAlternatingSumRecMemo(nums, i + 1,sum - nums[i], dp);
        int sub=maxAlternatingSumRecMemo(nums, i + 1, sum + nums[i], dp);


        dp.put(i+","+sum, addition+sub);
        return addition+sub;
    }

    public static int findTargetSumWaysRecBottomUp(int[] nums, int target) {
        int totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }
        /*Let:
	    • sum(P) be the sum of positive-signed numbers
	    • sum(N) be the sum of negative-signed numbers
        Then:
        sum(P) - sum(N) = target   ⬅️ Equation ①
        Also, we know:
        sum(P) + sum(N) = totalSum   ⬅️ Equation ②
        (sum(P) - sum(N)) + (sum(P) + sum(N)) = target + totalSum*/
        int newTarget = (totalSum+target)/2;

        if((totalSum+target)%2 != 0 || totalSum<Math.abs(target))
        {
            return 0;
        }

        int[] dp = new int[newTarget+1];
        dp[0]=1;
        //In 0/1 knapsack, iterate with the values first, because you are not allowed to reuse the items
        for(int num: nums){
            //checking upto only num , otherwise it will give negative number
            for(int i=newTarget;i>=num;i--){
                dp[i] +=dp[i-num];
            }
        }
        return dp[newTarget];
    }

}
