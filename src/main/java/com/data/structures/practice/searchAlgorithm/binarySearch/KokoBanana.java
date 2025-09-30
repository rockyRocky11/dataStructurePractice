package com.data.structures.practice.searchAlgorithm.binarySearch;

public class KokoBanana {
    public static void main(String[] args) {
        //int[] piles = {3, 6, 7, 11};
        //int h = 8;
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    /*O(nlogm) time and O(1) space, where n is the size of the input array, and m is the maximum value in the array.

*/
    public static int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        int min = 1;

        while (min <= max) {
            int mid = (min + (max - min) / 2);
            if (minEatingSpeed(piles, h, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public static boolean minEatingSpeed(int[] piles, int h, int k) {

        int i = 0;
        int totalHours = 0;
        while (i < piles.length) {

            // it takes pile[i]/k to eat this pile, if koko eating banana at k rate per hour
            totalHours += (piles[i] + k - 1) / k;
            if (totalHours > h) {
                return false;
            }
            i++;
        }
        return true;
    }
}
