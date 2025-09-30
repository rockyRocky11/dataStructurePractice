package com.data.structures.practice.string;

public class isPalindrome {
    public static void main(String[] args) {
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("1b1"));
    }

    public static boolean isPalindrome(String s) {

        int i=0;
        int j=s.length()-1;
        while(i<j) {
            int front = s.charAt(i);
            if (front !=48 && front !=49 &&front !=50 &&front !=51 &&front !=52 &&front !=53 &&front !=54 &&front !=55 &&front !=56 &&
                    front !=57 && (front < 65 || front > 122 || front == 91 || front == 92 || front == 93 || front == 94 || front == 95 || front == 96)) {
                i++;
                continue;
            }
            int back = s.charAt(j);
            if (back !=48 && back !=49 &&back !=50 &&back !=51 &&back !=52 &&back !=53 &&back !=54 &&back !=55 &&back !=56 &&
                    back !=57 &&  (back < 65 || back > 122 || back == 91 || back == 92 || back == 93 || back == 94 || back == 95 || back == 96)) {
                j--;
                continue;
            }


            if (front !=48 && front !=49 &&front !=50 &&front !=51 &&front !=52 &&front !=53 &&front !=54 &&front !=55 &&front !=56 &&
                    front !=57 &&  back !=48 && back !=49 &&back !=50 &&back !=51 &&back !=52 &&back !=53 &&back !=54 &&back !=55 &&back !=56 &&
                    back !=57){
                if (front > 90) {
                    front = front - 97;
                } else {
                    front = front - 65;
                }
                if (back > 90) {
                    back = back - 97;
                } else {
                    back = back - 65;
                }
            }
            if(front !=back){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
