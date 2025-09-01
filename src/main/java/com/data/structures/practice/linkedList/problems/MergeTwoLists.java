package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

public class MergeTwoLists {

    /*Time complexity: O(n + m)

    Space complexity: O(1) (ignoring recursion stack).*/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-101);
        ListNode temp = dummy;
        while(list2 != null && list1 != null){
            if( list2.val <= list1.val){
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if(list2 != null)temp.next = list2;
        if(list1 != null)temp.next = list1;
        return dummy.next;
    }
}
