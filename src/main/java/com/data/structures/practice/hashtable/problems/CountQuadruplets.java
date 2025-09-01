package com.data.structures.practice.hashtable.problems;



public class CountQuadruplets {
    public static void main(String[] args) {

        //int[] nums = {1, 2, 3, 6};
        //int[] nums = {3,3,6,4};
        //int[] nums = {1,1,1,3,5};
        //int[] nums = {35, 15, 38, 1, 10, 26};
        int[] nums = {1,1,1,3,5};
        //int[] nums = {2,16,9,27,3,39};
        //int[] nums = {28,8,49,85,37,90,20,8};
        System.out.println(countQuadruplets(nums));
        //System.out.println(countQuadruplets1(nums));
    }
//a+b=d-c
    public static int countQuadruplets(int[] nums) {

        int count = 0;
        int[] sumArray = new int[100];
        for (int b = 1; b < nums.length-2; b++) {
            for (int a = b-1; a>=0; a--) {
                if(nums[a]+nums[b]<=100){
                    System.out.println(nums[a]+" , "+nums[b]+" SUm ==> "+(nums[a]+nums[b]));

                    sumArray[nums[a]+nums[b]]++;
                }

            }

            for (int d = b+2; d<nums.length; d++) {
                int c=b+1;
               // for (int c = d-1; c>b; c--) {
                    if(nums[d]-nums[c] >=0 && sumArray[nums[d]-nums[c]]>0){
                        System.out.println(nums[d]+" , "+nums[c]+" diff ==> "+(nums[d]-nums[c]));
                        count+=sumArray[nums[d]-nums[c]];
                    }
             //   }
            }

        }
        return count;
    }

    public static int countQuadruplets1(int[] nums) {
        //a+b =d-c
        //a<b<c<d
        int count = 0;
        for (int b = 1; b < nums.length-2; b++) {
            for (int a = b-1; a>=0; a--) {
                if(nums[a]+nums[b]<=100){
                    System.out.println(nums[a]+" , "+nums[b]+" SUm ==> "+(nums[a]+nums[b]));

                    for (int d = b+2; d<nums.length; d++) {
                        for (int c = d-1; c>b; c--) {
                            if(nums[d]-nums[c] >=0 && nums[a]+nums[b] == nums[d]-nums[c]){
                                count++;
                            }
                        }
                    }
                }

            }



        }
        return count;
    }

    public int best(int[] nums) {
        int[] freq = new int[301];
        int res = 0;
        for(int b = 1;b<nums.length-2;b++){
            for(int a = 0;a<b;a++){
                int sum = nums[a] + nums[b];
                freq[sum]++;
            }
            int c = nums[b+1];
            for(int d = b+2;d<nums.length;d++){
                int diff = nums[d] - c;
                if(diff >= 0 && diff < 301){
                    res += freq[diff];
                }
            }
        }
        return res;
    }

}
