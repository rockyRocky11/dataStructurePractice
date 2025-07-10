package com.data.structures.practice.LeetCode.linkedList;

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


}
