package com.data.structures.practice.greedy;

public class GasStation {
    public static void main(String[] args) {
    int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
   // int[] gas = {2,3,4}, cost = {3,4,3};
    System.out.println(canCompleteCircuit(gas, cost));
    }

    /*Time Complexity
    O(n) – Just one pass through the array.*/
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalTank = 0;
        int curretnTank = 0;
        int i = 0;
        int start = 0;
        int n = gas.length;
        while (i < n) {
            //Total distance traveled so far it will have negative too
            int gain = gas[i] - cost[i];
            totalTank += gain;
            curretnTank += gain;
            // totalTank is just tracking whether a solution is possible overall.

            //currTank is tracking whether you can reach the next station from the current start point.
            if (curretnTank < 0) {
                start = i + 1;
                curretnTank = 0;
            }
            i++;
        }
        return totalTank >= 0 ? start : -1;
    }
}
