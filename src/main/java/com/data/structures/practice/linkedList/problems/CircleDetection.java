package com.data.structures.practice.linkedList.problems;

import com.data.structures.practice.linkedList.fundamentals.singly.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CircleDetection {

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> storeMap = new HashMap<>();
        while(head != null){
            if(storeMap.containsKey(head)){
                return true;
            }
            storeMap.put(head, 1);
            head = head.next;
        }

        return false;
    }

   /* Floyd’s Tortoise & Hare Algorithm

    ⚡ Complexity

    Time: O(n) → Each pointer traverses at most n nodes.

            Space: O(1) → No extra memory.*/
    public boolean hasCycleFloyd(ListNode head) {
        if(head == null || head.next ==null)return false;

        ListNode slow=head;
        ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }


}
