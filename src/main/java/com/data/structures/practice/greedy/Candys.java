package com.data.structures.practice.greedy;

import java.util.ArrayList;
import java.util.List;

public class Candys {
    public static void main(String[] args) {
        //int[] ratings = {1, 0, 2};
      //  int[] ratings = {1,2,3,1,0};
        //int[] ratings = {1,2,2};
        //int[] ratings = {1,2,87,87,87,2,1,0};
       // int[] ratings = {1,6,10,8,7,3,2};
       // int[] ratings = {1,2,3,5,4,3,2,1};
        int[] ratings = {29,51,87,87,72,12};
        System.out.println(candy(ratings));
        List<int[]> res=new ArrayList<>();
        res.toArray();
    }
   /* Time: O(n)
        Space: O(1)*/

    public static int candy(int[] ratings) {
        final int n = ratings.length;
        if (n <= 1) return n;

        int totalCandies = 1;
        int up = 1, down = 0, prev = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                down = 0;
                prev = (ratings[i] == ratings[i - 1]) ? 1 : prev + 1;
                totalCandies += prev;
                up = prev;
            } else {
                down++;
                if (down == up) {
                    down++;
                }
                totalCandies += down;
                prev = 1;
            }
        }

        return totalCandies;
    }

    public static int candyTwoPass(int[] ratings) {
        int n=ratings.length;
        int candies[]=new int[n];
        int totalCandies = 0;
        //give candy to each student
        for(int i=0;i<n;i++)
        {
            candies[i]=1;
        }
        //left to right
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                candies[i]=Math.max(candies[i],candies[i+1]+1);
        }
        for (int c : candies) {
            totalCandies += c;
        }

        return totalCandies;
    }

    public static int candyMyOriginal(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }
        int candys = 0;
        int[] sc = new int[n + 1];
        int adjustIndex = -1;
        int adjustLeft = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 && ratings[i] < ratings[i + 1] || i == n - 1 && ratings[i] < ratings[i - 1]) {
                sc[i]++;
                candys++;
                adjustIndex = -1;
                adjustLeft = 0;
                continue;
            }

            if (i != 0 && ratings[i] > ratings[i - 1]) {
                candys += sc[i - 1] + 1;
                sc[i] = sc[i - 1] + 1;
                if (i != 0 && ratings[i] > ratings[i - 1] && i != n - 1 && ratings[i] > ratings[i + 1]) {
                    adjustIndex = adjustIndex == -1 ? i : adjustIndex;
                    //if(sc[i]>2){

                    //}
                } else {
                    adjustIndex = -1;
                    adjustLeft++;
                }
            } else if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                candys += 2;
                sc[i] = 2;
                if (adjustIndex >= 0) {
                    candys += Math.abs(adjustIndex - i);
                    if (adjustLeft > 0) {
                        adjustLeft--;
                        candys--;
                    }
                } else {
                    adjustLeft = 0;

                }
                adjustIndex = adjustIndex == -1 ? i : adjustIndex;
            } else {
                sc[i]++;
                candys++;
                adjustIndex = -1;
                adjustLeft = -0;
            }
        }
        return candys;
    }
}
