package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.ListNode;
import com.data.structures.practice.linkedList.fundamentals.ListNodeCode;

public class Palindrome {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
        listNodeCode.addToFront(1);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(2);
        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(1);
//        listNodeCode.addToFront(0);
//        listNodeCode.addToFront(1);
        listNodeCode.PrintLinkedList();
        System.out.println(isPalindrome1(listNodeCode.getHead()));
    }

    public static boolean isPalindrome1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head.next == null) {
            return true;
        }
        ListNode reverse = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow;
            slow = slow.next;

            temp.next = reverse;
            reverse = temp;


        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null && reverse.val == slow.val) {
            slow = slow.next;
            reverse = reverse.next;
        }
        return slow != null ? false : true;


    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head.next == null) {
            return true;
        }

        String val1 = "";
        String val2 = "";

        while (fast != null && fast.next != null) {
            val1 += slow.val;

            slow = slow.next;
            fast = fast.next.next;

        }

        while (slow != null) {

            val2 = slow.val + val2;
            slow = slow.next;
        }

        if (val1.length() == val2.length()) {
            return val1.equals(val2);
        } else {
            return val1.equals(val2.substring(0, val2.length() - 1));
        }

    }
}
