package com.data.structures.practice.LeetCode.binarySearch;

public class FindBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
        System.out.println(firstBadVersionRecurrsion(2126753390));
    }

    public static int firstBadVersionRecurrsion(int n) {
        return helper(1, n);
    }

    private static int helper(int start, int end) {
        if(start >= end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if(isBadVersion(mid)) {
            return helper(start, mid);
        }
        return helper(mid + 1, end);
    }

    public static int firstBadVersion(int n) {

        long start = 1;
        long end = n;
        long mid = 0;
        boolean versionFound = false;
        while (start <= end) {
            mid = (end + start) / 2;
            if (isBadVersion((int)mid) && !isBadVersion((int)mid-1)) {
                end = mid-1;
            }
            if (isBadVersion((int)mid)) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return (int)mid;
    }

    public static boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        }
        return false;

    }
}
