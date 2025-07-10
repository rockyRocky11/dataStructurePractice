package com.data.structures.practice.LeetCode.math;

public class Palindrome {
    public static void main(String[] args) {
        int x = 121;
        int x1 = -121;
        int x2 = 10;
        System.out.println(isPalindrome1(x));
        System.out.println(isPalindrome(x1));
        System.out.println(isPalindrome(x2));

    }
    public static boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String input = x+"";
        int start=0;
        int end=input.length()-1;
        while(start<end){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //This one works by hal
    public static boolean isPalindrome1(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            int digit = x % 10; // Get last digit
            reversed = reversed * 10 + digit; // Build reversed half
            x /= 10; // Remove last digit
        }

        // A palindrome means forward and backward values should match
        return x == reversed || x == reversed / 10; // Handles both even and odd-length numbers
    }
}
