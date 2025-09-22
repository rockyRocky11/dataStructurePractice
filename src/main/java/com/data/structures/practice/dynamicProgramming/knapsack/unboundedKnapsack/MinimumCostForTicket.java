package com.data.structures.practice.dynamicProgramming.knapsack.unboundedKnapsack;

public class MinimumCostForTicket {
    static int totalCost =Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        //int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        //int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        //int[] costs = {7,2,15};
        System.out.println(mincostTickets(days, costs));
        System.out.println(minCostTicketsMemo(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
         dfs(days, costs, days.length-1,  0);
         return totalCost;
    }

    public static void dfs(int[] days, int[] costs, int currentDaysIndex, int cost) {
        if(currentDaysIndex <0 ){
            totalCost = Math.min(totalCost, cost);
            return;
        }
        int i=0;
        while(i< costs.length){
            cost = cost+costs[i];
            dfs(days, costs,getNewDaysIndex(i, days, currentDaysIndex),cost);
            cost = cost-costs[i];
            i++;
        }
    }

   /* Complexity:
    Time: O(n), where n = number of travel days

    Space: O(n) for memoization*/

    public static int minCostTicketsMemo(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length];
        return dfsMemo(days, costs, days.length-1, memo);
    }

    //Memo --> store the minim ticket needed for each day
    public static int dfsMemo(int[] days, int[] costs, int currentDaysIndex,Integer[] memo) {
        if(currentDaysIndex <0 ){
            return 0;
        }
        if (memo[currentDaysIndex] != null) {                     // Already computed
            return memo[currentDaysIndex];
        }

        int i=0;
        int minn = Integer.MAX_VALUE;
        while(i< costs.length){
            int cost = costs[i]+ dfsMemo(days, costs,getNewDaysIndex(i, days, currentDaysIndex), memo);
            minn=Math.min(minn, cost);
            i++;
        }
        memo[currentDaysIndex]=minn;
        return minn;
    }

    public static int getNewDaysIndex(int costIndex, int[] daysList, int currentDaysIndex) {

        int days = 0;
        if (costIndex == 0) {
            days = 1;
        }
        if (costIndex == 1) {
            days = 7;
        }
        if (costIndex == 2) {
            days = 30;
        }
        int temp = daysList[currentDaysIndex]-days;
        while (currentDaysIndex >=0 && daysList[currentDaysIndex] > temp) {
            currentDaysIndex--;
        }
        return currentDaysIndex;
    }


}
