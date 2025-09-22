package com.data.structures.practice.dynamicProgramming;

public class BuyStock {
    public static void main(String[] args) {
        int[] inputArray ={7,1,5,3,6,4};//5
        int[] inputArray1 ={7,6,4,3,1};//0
        int[] inputArray2 ={2,4,1};//0
        //System.out.println(maxProfit2(inputArray));
       // System.out.println(maxProfit(inputArray1));
        //System.out.println(maxProfit2(inputArray));
       // System.out.println(maxProfit2(inputArray1));
        //System.out.println(maxProfit2(inputArray));
        System.out.println(maxProfit2(inputArray2));
      //  System.out.println(maxProfit2(inputArray1));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentMax = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<=currentMax) {
                int buyPrice = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - buyPrice;
                    if (profit > 0 && profit > maxProfit) {
                        maxProfit = profit;
                    }

                }
                currentMax=prices[i];
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;

        for(int i= 1;i<prices.length;i++){
            int currentProfit = prices[i]-buyPrice;
            if(prices[i]<buyPrice){
                buyPrice = prices[i];
               // maxProfit=currentProfit;

            }
            maxProfit=Math.max(maxProfit,currentProfit);

        }
        return Math.max(maxProfit, 0);
    }
}
