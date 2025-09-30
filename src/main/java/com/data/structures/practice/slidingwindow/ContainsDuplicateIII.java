package com.data.structures.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    public static void main(String[] args) {
        //[-3,3]//2//4//false

        //[-1,-1]//1//0//true

        //[8,7,15,1,6,1,9,15]//1//3//true
    }
}

class SolutionBruteForce {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i] - valueDiff;
            if (valueDiff == 0) {
                if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= indexDiff)
                    return true;
            } else {
                while (Math.abs(nums[i] - j) <= valueDiff) {
                    if (map.containsKey(j) && i - map.get(j) <= indexDiff)
                        return true;
                    j++;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

class SolutionBucket {
    long size;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        Map<Long, Long> bucket = new HashMap<>();
        size = valueDiff + 1; //max value can go into bucket

        for (int i = 0; i < nums.length; i++) {
            long value = nums[i];
            long bucketID = getBucketID(value);
            //Current value falls in a existing active window
            if (bucket.containsKey(bucketID))
                return true;

            //current value lies in a existing active neighbour bucket
            if (bucket.containsKey(bucketID + 1) && Math.abs(bucket.get(bucketID + 1) - value) <= valueDiff)
                return true;
            //current value lies in a existing active neighbour bucket
            if (bucket.containsKey(bucketID - 1) && Math.abs(bucket.get(bucketID - 1) - value) <= valueDiff)
                return true;

            bucket.put(bucketID, value);

            //Maintaining Window
            if (i >= indexDiff) {
                long oldBucketID = getBucketID(nums[i - indexDiff]);
                bucket.remove(oldBucketID);
            }
        }
        return false;
    }

    public long getBucketID(long value) {
      /*  integer division rounds toward zero in Java, which messes up negatives.
                We want buckets that are contiguous, evenly spaced intervals, even for negatives.*/
        return value < 0 ? (value + 1) / size - 1 : value / size;
    }
}
